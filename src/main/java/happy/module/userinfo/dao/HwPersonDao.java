package happy.module.userinfo.dao;


import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.pagination.dto.PageMyBatis;
import org.mybatis.pagination.dto.datatables.PagingCriteria;
import org.mybatis.pagination.extra.MyBatisRepository;

/**
* 映射接口类 HwPersonDao
* happy-generator 1.0.0 生成于 2014-06-14 17:24:04
*/

@MyBatisRepository
public interface HwPersonDao {

	public List<HwPerson> queryList();
	public List<HwPerson> queryListFully();
	public PageMyBatis<HwPerson> queryListByPageFully(PagingCriteria pagingCriteria);
	public HwPerson searchOne(@Param("birthdate") Date birthdate,@Param("duty") String duty,@Param("email") String email,@Param("icd") String icd,@Param("mobile") String mobile,@Param("name") String name,@Param("orgCdOfOrganize")String orgCdOfOrganize,@Param("sex") int sex,@Param("token") String token);
	public List<HwPerson> searchList(@Param("birthdate") Date birthdate,@Param("duty") String duty,@Param("email") String email,@Param("icd") String icd,@Param("mobile") String mobile,@Param("name") String name,@Param("orgCdOfOrganize")String orgCdOfOrganize,@Param("sex") int sex,@Param("token") String token);


	public int getCount();

	
			public HwPerson getObjByBirthdate(String key);
			public HwPerson getObjByBirthdateFully(String key);

			public HwPerson getObjByDuty(String key);
			public HwPerson getObjByDutyFully(String key);

			public HwPerson getObjByEmail(String key);
			public HwPerson getObjByEmailFully(String key);

			public HwPerson getObjByIcd(String key);
			public HwPerson getObjByIcdFully(String key);

			public HwPerson getObjByMobile(String key);
			public HwPerson getObjByMobileFully(String key);

			public HwPerson getObjByName(String key);
			public HwPerson getObjByNameFully(String key);

			public HwPerson getObjBySex(String key);
			public HwPerson getObjBySexFully(String key);

			public HwPerson getObjByToken(String key);
			public HwPerson getObjByTokenFully(String key);
			public HwPerson getObj(@Param(value="id") String id);
			public HwPerson getObjFully(@Param(value="token") String token);
			public Object[] keyString2Array(String value);
			public String keyArray2String(Object[] array);



	public long insert(HwPerson HwPerson);
	public int delete(@Param(value="token") String token);
	public int update(HwPerson HwPerson);
}
