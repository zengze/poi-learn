package happy.module.userinfo.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.pagination.dto.PageMyBatis;
import org.mybatis.pagination.dto.datatables.PagingCriteria;
import org.mybatis.pagination.extra.MyBatisRepository;

/**
 * 行政区划的dao
 * 
 * 映射接口类 WrAdBDao happy-generator 1.0.0 生成于 2014-04-22 11:44:17
 */

@MyBatisRepository
public interface WrAdBDao {
	
	/**
	 * 添加
	 * @param WrAdB
	 * @return
	 */
	public long insert(WrAdB WrAdB);
	
	/**
	 * 查询list集合+分页
	 * @param pagingCriteria
	 * @return
	 */
	public PageMyBatis<WrAdB> queryListByPageFully(@Param("parent") String parent,PagingCriteria pagingCriteria);
	
	/**
	 * 查询list集合+分页+级别
	 * @param pagingCriteria
	 * @return
	 */
	public PageMyBatis<WrAdB> queryListByPageFullyByJB(PagingCriteria pagingCriteria,@Param("adReg") String adReg);
	
	/**
	 * 查询区县list集合+分页
	 * 
	 * @param pagingCriteria
	 * @return
	 */
	public PageMyBatis<WrAdB> queryListByPageFullyByXian(PagingCriteria pagingCriteria);
	
	/**
	 * 删除
	 * @param adCd
	 * @return
	 */
	public int delete(@Param(value = "adCd") String adCd);
	
	/**
	 * 根据主键查询
	 * @param adCd
	 * @return
	 */
	public WrAdB getObj(@Param(value = "adCd") String adCd);
	
	/**
	 * 修改
	 * @param WrAdB
	 * @return
	 */
	public int update(WrAdB WrAdB);
	
	/**
	 * 根据行政区划代码查询数值
	 * @param key
	 * @return
	 */
	public WrAdB4Geo getObj4GeoByAdCd(String key);
	
	
	
	
	/**
	 * 根据树值查询行政区划
	 * @param key
	 * @return
	 */
	public List<WrAdB> getAreaByParent(String key);

	/**
	 * 行政区划list查询
	 * @return
	 */
	public List<WrAdB> queryList();
	
	/**
	 * 
	 * @param parent
	 * @param jb
	 * @return
	 */
	public List<WrAdB> getAllAreas(@Param("parent") String parent,@Param("jb") String jb);
	
	/** 得到自己和子区划 */
	public List<WrAdB> getByParent(@Param("adCd") String adCd);
	
	public List<Map<String,Object>> getAllXian(@Param("parentAdCd") String parentAdCd,
			@Param(value = "xianAdNm") String xianAdNm);
	
}
