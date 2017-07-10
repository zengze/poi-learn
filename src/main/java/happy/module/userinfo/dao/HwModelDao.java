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
* 映射接口类 HwModelDao
* happy-generator 1.0.0 生成于 2014-05-06 15:47:04
*/

@MyBatisRepository
public interface HwModelDao {

	public List<HwModel> queryList();
	public List<HwModel> queryListFully();
	public PageMyBatis<HwModel> queryListByPageFully(PagingCriteria pagingCriteria);
	public HwModel searchOne(@Param("json") String json,@Param("name") String name,@Param("nt") String nt,@Param("token") String token);
	public List<HwModel> searchList(@Param("json") String json,@Param("name") String name,@Param("nt") String nt,@Param("token") String token);


	public int getCount();

	
			public HwModel getObjByJson(String key);
			public HwModel getObjByJsonFully(String key);

			public HwModel getObjByName(String key);
			public HwModel getObjByNameFully(String key);

			public HwModel getObjByNt(String key);
			public HwModel getObjByNtFully(String key);

			public HwModel getObjByToken(String key);
			public HwModel getObjByTokenFully(String key);
			public HwModel getObj(@Param(value="token") String token);
			public HwModel getObjFully(@Param(value="token") String token);
			public Object[] keyString2Array(String value);
			public String keyArray2String(Object[] array);



	public long insert(HwModel HwModel);
	public int delete(@Param(value="token") String token);
	public int update(HwModel HwModel);
}
