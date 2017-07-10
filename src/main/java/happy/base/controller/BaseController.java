package happy.base.controller;

import com.alibaba.fastjson.JSONObject;
import happy.module.userinfo.dao.HwLog;
import happy.module.userinfo.dao.HwLogDao;
import happy.plugin.security.userlogin.AuthorizeHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import org.mybatis.pagination.dto.datatables.PagingCriteria;
import org.mybatis.pagination.dto.datatables.SearchField;
import org.mybatis.pagination.dto.datatables.SortField;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;



public abstract class BaseController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ResourceBundleMessageSource _res;

    @Autowired
    private AuthorizeHandle authorizeHandle;

    @Autowired
    private HwLogDao hwLogDao;

    /**
     * ????
     * @param module ??
     * @param resource ??
     * @param oprt ??
     * @param descr ??
     * @param session ????
     */
    protected void insertLog(String module,String resource,String oprt,String descr,HttpSession session) {
        HwLog hwLog = new HwLog();
        hwLog.setToken(UUID.randomUUID().toString());
        hwLog.setTs(new java.sql.Timestamp(System.currentTimeMillis()));
        hwLog.setOperator((String) session.getAttribute("userName"));
        hwLog.setModule(module);
        hwLog.setNameOfResource(resource);
        hwLog.setOprt(oprt);
        hwLog.setDescr(descr);
        hwLogDao.insert(hwLog);
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(java.sql.Time.class, new TimeEditor());
        binder.registerCustomEditor(java.sql.Date.class,new DateEditor());
        binder.registerCustomEditor(java.sql.Timestamp.class, new DateTimeEditor());
    }

    //????????????view???,????????????????
    @ModelAttribute("view")
    public Object getViewObj() {
        return authorizeHandle.getViewObj(this.request);
    }

    public JSONObject gJ(JSONObject jobj,String jstr) {
        if(jobj==null) return null;
        return jobj.getJSONObject(jstr);
    }

    public Object gJ2(JSONObject jobj,String jstr) {
        if(jobj==null) return null;
        return jobj.get(jstr);
    }


    /** 简化查询方法的代码 */
    protected PagingCriteria fillPagingCriteria(
            String pageNum,String numPerPage,
            String field, String keywords,
            String orderField, String orderDirection) {
        int intPage = Integer.parseInt(pageNum);
        int intPageSize = Integer.parseInt(numPerPage);
        int start = (intPage - 1) * intPageSize;

        List<SortField> sortFields = new ArrayList<SortField>();
        if (StringUtils.hasText(orderField))
            sortFields.add(new SortField(orderField,orderDirection));

        List<SearchField> searchFields = new ArrayList<SearchField>();
        if (StringUtils.hasText(field) && StringUtils.hasText(keywords))
            searchFields.add(new SearchField(field, false,false, keywords));

        PagingCriteria pc = PagingCriteria.createCriteriaWithAllParamter(
                start,intPageSize, intPage - 1, sortFields, searchFields);
        return pc;
    }

    /** for多列条件、多列排序。*/
    protected PagingCriteria fillPagingCriteria(
            String pageNum,String numPerPage) {
        int intPage = Integer.parseInt(pageNum);
        int intPageSize = Integer.parseInt(numPerPage);
        int start = (intPage - 1) * intPageSize;

        PagingCriteria pc = PagingCriteria.createCriteria(
                start,intPageSize, intPage - 1);
        return pc;
    }

    /** for多列条件、动态单列排序。*/
    protected PagingCriteria fillPagingCriteria(
            String pageNum,String numPerPage,
            String orderField, String orderDirection) {
        int intPage = Integer.parseInt(pageNum);
        int intPageSize = Integer.parseInt(numPerPage);
        int start = (intPage - 1) * intPageSize;

        List<SortField> sortFields = new ArrayList<SortField>();
        if (StringUtils.hasText(orderField))
            sortFields.add(new SortField(orderField,orderDirection));

        PagingCriteria pc = PagingCriteria.createCriteriaWithSort(
                start,intPageSize, intPage - 1,sortFields);
        return pc;
    }

    protected ModelAndView ajaxDone(int statusCode, String message, String forwardUrl) {
        ModelAndView mav = new ModelAndView("ajaxDone");
        mav.addObject("statusCode", statusCode);
        mav.addObject("message", message);
        mav.addObject("forwardUrl", forwardUrl);
        return mav;
    }

    protected Map<String, Object> ajaxDone(int statusCode, String message) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("statusCode", statusCode);
        modelMap.put("message", message);
        return modelMap;
    }




    protected ModelAndView ajaxDoneSuccess(String message) {
        return ajaxDone(200, message, "");
    }
    protected ModelAndView ajaxDoneError(String message) {
        return ajaxDone(300, message, "");
    }
    protected ModelAndView ajaxDoneInfo(String message) {
        return ajaxDone(100, message, "");//?
    }
    protected ModelAndView ajaxDoneError(DataAccessException e) {
        if(e instanceof DuplicateKeyException){
            return ajaxDone(300, getMessage("msg.db.duplicate"), "");
        }else{
            return ajaxDone(300, e.getMessage(), "");
        }

    }
    protected String getMessage(String code) {
        return this.getMessage(code, new Object[] {});
    }

    protected String getMessage(String code, Object arg0) {
        return getMessage(code, new Object[] { arg0 });
    }

    protected String getMessage(String code, Object arg0, Object arg1) {
        return getMessage(code, new Object[] { arg0, arg1 });
    }

    protected String getMessage(String code, Object arg0, Object arg1,
                                Object arg2) {
        return getMessage(code, new Object[] { arg0, arg1, arg2 });
    }

    protected String getMessage(String code, Object arg0, Object arg1,
                                Object arg2, Object arg3) {
        return getMessage(code, new Object[] { arg0, arg1, arg2, arg3 });
    }

    protected String getMessage(String code, Object[] args) {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        Locale locale = localeResolver.resolveLocale(request);
        return _res.getMessage(code, args, locale);
    }

    static public String camelNameSqlName(String camelName)
    {
        StringBuffer sqlName = new StringBuffer();
        char curChar;
        for(int i= 0 ; i < camelName.length();i++)
        {
            curChar = camelName.charAt(i);
            if(isUpperCase(curChar) && (i != 0))
            {
                sqlName.append('_');
            }
            sqlName.append(curChar);
        }
        return sqlName.toString().toUpperCase();
    }
    public static boolean isUpperCase(char curChar) {
        if(curChar >= 'A' && curChar <= 'Z') return true;
        return false;
    }
    public static boolean isLowerCase(char curChar) {
        if(curChar >= 'a' && curChar <= 'z') return true;
        return false;
    }

    static public String FormatSqlFieldName(String field) {
        String[] secs = field.split("-");
        StringBuffer sqlFieldName = new StringBuffer();
        for(int i = 0 ; i < secs.length;i++)
        {
            if(i != 0)
                sqlFieldName.append('.');
            sqlFieldName.append(camelNameSqlName(secs[i]));


        }
        return sqlFieldName.toString();
    }

    static public String FormatSqlFieldNameWithoutCamel(String field) {
        String[] secs = field.split("-");
        StringBuffer sqlFieldName = new StringBuffer();
        for(int i = 0 ; i < secs.length;i++)
        {
            if(i != 0)
                sqlFieldName.append('.');
            sqlFieldName.append(secs[i]);

        }
        return sqlFieldName.toString();

    }

    @SuppressWarnings("unchecked")
    public String getNm(String userNm,HttpSession session){
        Map<String, String> map = (Map<String, String>)session.getAttribute("persons");
        String nNm = map.get(userNm);
        return nNm;
    }
}
