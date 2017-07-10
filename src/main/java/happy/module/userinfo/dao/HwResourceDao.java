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
* 映射接口类 HwResourceDao
* happy-generator 1.0.0 生成于 2014-05-06 16:18:34
*/

@MyBatisRepository
public interface HwResourceDao {

	public List<HwResource> queryList();
	public List<HwResource> queryListFully();
	public PageMyBatis<HwResource> queryListByPageFully(PagingCriteria pagingCriteria);
	public HwResource searchOne(@Param("caption") String caption,@Param("name") String name,@Param("nt") String nt,@Param("oprt") String oprt,@Param("nameOfParent")String nameOfParent,@Param("ts") Timestamp ts,@Param("type") String type,@Param("url") String url);
	public List<HwResource> searchList(@Param("caption") String caption,@Param("name") String name,@Param("nt") String nt,@Param("oprt") String oprt,@Param("nameOfParent")String nameOfParent,@Param("ts") Timestamp ts,@Param("type") String type,@Param("url") String url);


	public int getCount();

	
			public HwResource getObjByCaption(String key);
			public HwResource getObjByCaptionFully(String key);

			public HwResource getObjByName(String key);
			public HwResource getObjByNameFully(String key);

			public HwResource getObjByNt(String key);
			public HwResource getObjByNtFully(String key);

			public HwResource getObjByOprt(String key);
			public HwResource getObjByOprtFully(String key);

			public HwResource getObjByTs(String key);
			public HwResource getObjByTsFully(String key);

			public HwResource getObjByType(String key);
			public HwResource getObjByTypeFully(String key);

			public HwResource getObjByUrl(String key);
			public HwResource getObjByUrlFully(String key);
			public HwResource getObj(@Param(value="name") String name);
			public HwResource getObjFully(@Param(value="name") String name);
			public Object[] keyString2Array(String value);
			public String keyArray2String(Object[] array);
			public List<HwResource> getObjByParent(String key);



	public long insert(HwResource HwResource);
	public int delete(@Param(value="name") String name);
	public int update(HwResource HwResource);
}
