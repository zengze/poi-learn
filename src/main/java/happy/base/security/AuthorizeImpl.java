package happy.base.security;

import happy.base.controller.JsonString2Map;
import happy.module.userinfo.dao.HwPerson;
import happy.module.userinfo.dao.HwPersonDao;
import happy.module.userinfo.dao.HwRole;
import happy.module.userinfo.dao.HwRoleDao;
import happy.module.userinfo.dao.HwUser;
import happy.module.userinfo.dao.HwUserDao;
import happy.module.userinfo.dao.HwView;
import happy.module.userinfo.dao.HwViewDao;
import happy.module.userinfo.dao.WrAdB;
import happy.module.userinfo.dao.WrAdBDao;
import happy.module.userinfo.dao.WrAdmaB;
import happy.module.userinfo.dao.WrAdmaBDao;
import happy.plugin.security.userlogin.AuthorizeHandle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 检测登陆本模块的用户是否合法 该类会被认证插件自动注入到spring-security中
 *
 * @author sparkok
 *
 */
public class AuthorizeImpl implements AuthorizeHandle {

	@Autowired
	@Qualifier("userRoleFlag")
	String userRoleFlag;

	@Autowired
	HwUserDao hwUserDao;

	@Autowired
	HwViewDao viewDao;

	@Autowired
	HwRoleDao hwRoleDao;

	@Autowired
	private WrAdmaBDao wrAdmaBDao;

	@Autowired
	private HwPersonDao hwPersonDao;

	/**
	 * 行政区划
	 */
	@Autowired
	private WrAdBDao wrAdBDao;


	/**
	 * 管理员密码
	 */

	String password;

	@Autowired(required = false)
	@Qualifier("password")
	public void setPassword(String password) {
		this.password = password;
	}

	String username;

	@Autowired(required = false)
	@Qualifier("username")
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 根据用户名获取
	 */
	public Map getMapByName(String argUsername) {
		if (hwUserDao == null)
			throw new UsernameNotFoundException("User not found");
		if (this.username != null && this.password != null
				&& username.equals(argUsername)) {
			Map map = new HashMap();
			map.put("password", password);
			map.put("type", userRoleFlag);
			map.put("state", new Integer(1));
			return map;
		} else {
			// 根据用户名获取用户对象
			HwUser userInfo = hwUserDao.getObjByName(argUsername);
			if (userInfo != null) {
				HwPerson hwPerson=hwPersonDao.getObj((String) userInfo.getPerson());
				WrAdmaB wrAdmaB = wrAdmaBDao.getObj((String) hwPerson.getOrgCdOfOrganize());

				Map map = new HashMap();
				map.put("password", (String) userInfo.getPassword());
				map.put("state", new Integer(userInfo.getState()));
				map.put("userName", (String)userInfo.getName());
				map.put("userid", (String) userInfo.getId());
				map.put("roleid", (String) userInfo.getTokenOfRole());
				map.put("orgcd", (String) hwPerson.getOrgCdOfOrganize());
				map.put("realName", (String)hwPerson.getName());

				Map<String, String> persons = new HashMap<String, String>();
				for (HwUser user:hwUserDao.queryList()) {
					String userName = user.getName();
					String realName = hwPersonDao.getObj(user.getTokenOfPerson()).getName();
					persons.put(userName,realName);
				}
				map.put("persons", persons);

				// 行政区划
				map.put("adCdOfDivision", (String)wrAdmaB.getAdCdOfDistrict());

				WrAdB wrAdB = wrAdBDao.getObj((String)wrAdmaB.getAdCdOfDistrict());
				map.put("adNm", (String) wrAdB.getAdNm());



				if (wrAdmaB != null) {
					map.put("orgShnm", (String) wrAdmaB.getOrgShnm());
					map.put("orgNm", (String) wrAdmaB.getOrgNm());

					List<WrAdmaB> lstAllWrAdmaB = wrAdmaBDao.queryList();
					List<WrAdmaB> lstWrAdmaB = new ArrayList<WrAdmaB>();
					lstWrAdmaB.add(wrAdmaB);

					// 使用递归方法取得全部的节点
					getWrAdmaBChild(lstAllWrAdmaB, lstWrAdmaB, wrAdmaB.getOrgCd());

					StringBuilder sbWrAdmaBOrgCd = new StringBuilder();

					for (int i = 0; i < lstWrAdmaB.size(); i++) {
						String orgCd = lstWrAdmaB.get(i).getOrgCd();
						if (i == 0) {
							sbWrAdmaBOrgCd.append(orgCd);
						} else {
							sbWrAdmaBOrgCd.append("^");
							sbWrAdmaBOrgCd.append(orgCd);
						}
					}

					map.put("orgCdMeAndChild", sbWrAdmaBOrgCd.toString());


				}

				HwRole role = this.hwRoleDao.getObj(userInfo.getTokenOfRole());
				if (role != null) {
					map.put("type", role.getType());
					map.put("modelid", role.getTokenOfModel());
				}

				return map;
			}
			return null;
		}
	}

	/**
	 * 取得全部的子组织
	 * @param lstAllWrAdmaB
	 * @param lstWrAdmaB
	 * @param orgCd
	 */
	private void getWrAdmaBChild(List<WrAdmaB> lstAllWrAdmaB,
								 List<WrAdmaB> lstWrAdmaB, String orgCd) {

		List<WrAdmaB> lstForQueryWrAdmaB = new ArrayList<WrAdmaB>();

		// 根据父组织代码，取得组织列表
		for(int i = 0; i < lstAllWrAdmaB.size(); i++) {
			WrAdmaB itemWrAdmaB = lstAllWrAdmaB.get(i);
			if (StringUtils.equals(itemWrAdmaB.getOrgCdOfParent(), orgCd)) {
				lstForQueryWrAdmaB.add(itemWrAdmaB);
			}
		}

		if (lstForQueryWrAdmaB.size() == 0) {
			return;
		}

		for (int j = 0; j < lstForQueryWrAdmaB.size(); j++) {
			WrAdmaB itemForAddWrAdmaB = lstForQueryWrAdmaB.get(j);
			lstWrAdmaB.add(itemForAddWrAdmaB);
			getWrAdmaBChild(lstAllWrAdmaB, lstWrAdmaB, itemForAddWrAdmaB.getOrgCd());
		}

	}

	public Object getViewObj(HttpServletRequest request) {
		//注释是因为单位需要树状结构，现在会报错
//		if (request.getSession().getAttribute("orgCdAllNodes") == null) {
//			OrgHelper oh = new OrgHelper();
//			String orgCdAllNodes = oh.getAllOrg(wrAdmaBDao, request.getSession().getAttribute("orgCd").toString());
//			request.getSession().setAttribute("orgCdAllNodes", orgCdAllNodes);
//		}
//		if (request.getSession().getAttribute("adCdAllNodes") == null) {
//			AreaServer as = new AreaServer();
//			String adCdAllNodes = as.getAllArea(wrAdBDao, request.getSession().getAttribute("adCdOfDivision").toString());
//			request.getSession().setAttribute("adCdAllNodes", adCdAllNodes);
//		}

		Object viewObj = (Map) request.getSession().getAttribute("view");
		if (viewObj != null) {
			return viewObj;
		}
		String roleId = (String) request.getSession().getAttribute("roleId");
		if (roleId == null)
			return null;
		if (roleId.isEmpty())
			return null;

		HwView view = viewDao.searchOne(null, userRoleFlag, null, null, roleId,
				null);
		if (view != null) {
			String json = view.getJson();
			JsonString2Map j2map = new JsonString2Map();
			viewObj = j2map.json2Map(json);
		}
		if (viewObj == null)
			viewObj = new HashMap();
		request.getSession().setAttribute("view", viewObj);
		return viewObj;
	}

	public Object getModelObj(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
