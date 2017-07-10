package happy.module.userinfo.dao;


import org.apache.ibatis.annotations.Param;
import org.mybatis.pagination.dto.PageMyBatis;
import org.mybatis.pagination.dto.datatables.PagingCriteria;
import org.mybatis.pagination.extra.MyBatisRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * 映射接口类 HwUserDao
 * happy-generator 1.0.0 生成于 2014-06-14 18:00:38
 */

@MyBatisRepository
public interface HwUserDao {

	public List<HwUser> queryList();
	public List<HwUser> queryListFully();
	public PageMyBatis<HwUser> queryListByPageFully(PagingCriteria pagingCriteria);
	public HwUser searchOne(@Param("name") String name,@Param("nt") String nt,@Param("password") String password,@Param("tokenOfPerson")String tokenOfPerson,@Param("tokenOfRole")String tokenOfRole,@Param("state") Integer state,@Param("token") String token,@Param("ts") Timestamp ts);
	public List<HwUser> searchList(@Param("name") String name,@Param("nt") String nt,@Param("password") String password,@Param("tokenOfPerson")String tokenOfPerson,@Param("tokenOfRole")String tokenOfRole,@Param("state") Integer state,@Param("token") String token,@Param("ts") Timestamp ts);


	public int getCount();


	public HwUser getObjByName(String key);
	public HwUser getObjByNameFully(String key);
	public HwUser getObjByPerson(String key);


	public HwUser getObjByNt(String key);
	public HwUser getObjByNtFully(String key);

	public HwUser getObjByPassword(String key);
	public HwUser getObjByPasswordFully(String key);

	public HwUser getObjByState(String key);
	public HwUser getObjByStateFully(String key);

	public HwUser getObjByToken(String key);
	public HwUser getObjByTokenFully(String key);

	public HwUser getObjByTs(String key);
	public HwUser getObjByTsFully(String key);
	public HwUser getObj(@Param(value="token") String token);
	public HwUser getObjFully(@Param(value="token") String token);
	public Object[] keyString2Array(String value);
	public String keyArray2String(Object[] array);



	public long insert(HwUser HwUser);
	public int delete(@Param(value="token") String token);
	public int update(HwUser HwUser);
}
