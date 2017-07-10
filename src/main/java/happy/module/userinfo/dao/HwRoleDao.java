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
* 映射接口类 HwRoleDao
* happy-generator 1.0.0 生成于 2014-05-13 15:58:36
*/

@MyBatisRepository
public interface HwRoleDao {

	public List<HwRole> queryList();
	public List<HwRole> queryListFully();
	public PageMyBatis<HwRole> queryListByPageFully(PagingCriteria pagingCriteria);
	public HwRole searchOne(@Param("tokenOfModel")String tokenOfModel,@Param("name") String name,@Param("nt") String nt,@Param("token") String token,@Param("ts") Timestamp ts,@Param("type") String type);
	public List<HwRole> searchList(@Param("tokenOfModel")String tokenOfModel,@Param("name") String name,@Param("nt") String nt,@Param("token") String token,@Param("ts") Timestamp ts,@Param("type") String type);


	public int getCount();

	
			public HwRole getObjByName(String key);
			public HwRole getObjByNameFully(String key);

			public HwRole getObjByNt(String key);
			public HwRole getObjByNtFully(String key);

			public HwRole getObjByToken(String key);
			public HwRole getObjByTokenFully(String key);

			public HwRole getObjByTs(String key);
			public HwRole getObjByTsFully(String key);

			public HwRole getObjByType(String key);
			public HwRole getObjByTypeFully(String key);
			public HwRole getObj(@Param(value="token") String token);
			public HwRole getObjFully(@Param(value="token") String token);
			public Object[] keyString2Array(String value);
			public String keyArray2String(Object[] array);



	public long insert(HwRole HwRole);
	public int delete(@Param(value="token") String token);
	public int update(HwRole HwRole);
}
