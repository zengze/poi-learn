package happy.module.userinfo.dao;


import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.mybatis.pagination.dto.PageMyBatis;
import org.mybatis.pagination.dto.datatables.PagingCriteria;
import org.mybatis.pagination.extra.MyBatisRepository;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
* 映射接口类 HwViewDao
* happy-generator 1.0.0 生成于 2014-05-13 22:35:13
*/

@MyBatisRepository
public interface HwViewDao {

	public List<HwView> queryList();
	public List<HwView> queryListFully();
	public PageMyBatis<HwView> queryListByPageFully(PagingCriteria pagingCriteria);
	public HwView searchOne(@Param("json") String json,@Param("module") String module,@Param("name") String name,@Param("nt") String nt,@Param("tokenOfRole")String tokenOfRole,@Param("token") String token);
	public List<HwView> searchList(@Param("json") String json,@Param("module") String module,@Param("name") String name,@Param("nt") String nt,@Param("tokenOfRole")String tokenOfRole,@Param("token") String token);


	public int getCount();

	
			public HwView getObjByJson(String key);
			public HwView getObjByJsonFully(String key);

			public HwView getObjByModule(String key);
			public HwView getObjByModuleFully(String key);

			public HwView getObjByName(String key);
			public HwView getObjByNameFully(String key);

			public HwView getObjByNt(String key);
			public HwView getObjByNtFully(String key);

			public HwView getObjByToken(String key);
			public HwView getObjByTokenFully(String key);
			public HwView getObj(@Param(value="token") String token);
			public HwView getObjFully(@Param(value="token") String token);
			public Object[] keyString2Array(String value);
			public String keyArray2String(Object[] array);



	public long insert(HwView HwView);
	public int delete(@Param(value="token") String token);
	public int update(HwView HwView);
}
