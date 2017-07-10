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
 * 映射接口类 HwLogDao happy-generator 1.0.0 生成于 2014-05-06 15:32:53
 */

@MyBatisRepository
public interface HwLogDao {

	public List<HwLog> queryList();

	public List<HwLog> queryListFully();

	public PageMyBatis<HwLog> queryListByPageFully(PagingCriteria pagingCriteria);

	public HwLog searchOne(@Param("descr") String descr,
			@Param("module") String module, @Param("nt") String nt,
			@Param("operator") String operator, @Param("oprt") String oprt,
			@Param("nameOfResource") String nameOfResource,
			@Param("token") String token, @Param("ts") Timestamp ts);

	public List<HwLog> searchList(@Param("descr") String descr,
			@Param("module") String module, @Param("nt") String nt,
			@Param("operator") String operator, @Param("oprt") String oprt,
			@Param("nameOfResource") String nameOfResource,
			@Param("token") String token, @Param("ts") Timestamp ts);

	public int getCount();

	public HwLog getObjByDescr(String key);

	public HwLog getObjByDescrFully(String key);

	public HwLog getObjByModule(String key);

	public HwLog getObjByModuleFully(String key);

	public HwLog getObjByNt(String key);

	public HwLog getObjByNtFully(String key);

	public HwLog getObjByOperator(String key);

	public HwLog getObjByOperatorFully(String key);

	public HwLog getObjByOprt(String key);

	public HwLog getObjByOprtFully(String key);

	public HwLog getObjByToken(String key);

	public HwLog getObjByTokenFully(String key);

	public HwLog getObjByTs(String key);

	public HwLog getObjByTsFully(String key);

	public HwLog getObj(@Param(value = "token") String token);

	public HwLog getObjFully(@Param(value = "token") String token);

	public Object[] keyString2Array(String value);

	public String keyArray2String(Object[] array);

	public long insert(HwLog HwLog);

	public int delete(@Param(value = "token") String token);

	public int update(HwLog HwLog);
}
