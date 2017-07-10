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
* 映射接口类 WrAdmaBDao
* happy-generator 1.0.0 生成于 2014-06-14 18:47:46
*/

@MyBatisRepository
public interface WrAdmaBDao {

	public List<WrAdmaB> queryList();
	public List<WrAdmaB> queryListFully();
	public PageMyBatis<WrAdmaB> queryListByPageFully(PagingCriteria pagingCriteria);
	public WrAdmaB searchOne(@Param("addr") String addr,@Param("adCdOfDistrict")String adCdOfDistrict,@Param("email") String email,@Param("fax") String fax,@Param("fulldomain") String fulldomain,@Param("lrNm") String lrNm,@Param("menb") String menb,@Param("nt") String nt,@Param("orgCd") String orgCd,@Param("orgNm") String orgNm,@Param("orgScal") String orgScal,@Param("orgShnm") String orgShnm,@Param("orgTp") String orgTp,@Param("orgCdOfParent")String orgCdOfParent,@Param("partdomain") String partdomain,@Param("tel") String tel,@Param("ts") Timestamp ts,@Param("web") String web,@Param("zip") String zip);
	public List<WrAdmaB> searchList(@Param("addr") String addr,@Param("adCdOfDistrict")String adCdOfDistrict,@Param("email") String email,@Param("fax") String fax,@Param("fulldomain") String fulldomain,@Param("lrNm") String lrNm,@Param("menb") String menb,@Param("nt") String nt,@Param("orgCd") String orgCd,@Param("orgNm") String orgNm,@Param("orgScal") String orgScal,@Param("orgShnm") String orgShnm,@Param("orgTp") String orgTp,@Param("orgCdOfParent")String orgCdOfParent,@Param("partdomain") String partdomain,@Param("tel") String tel,@Param("ts") Timestamp ts,@Param("web") String web,@Param("zip") String zip);


	public int getCount();

	
			public WrAdmaB getObjByAddr(String key);
			public WrAdmaB getObjByAddrFully(String key);

			public WrAdmaB getObjByEmail(String key);
			public WrAdmaB getObjByEmailFully(String key);

			public WrAdmaB getObjByFax(String key);
			public WrAdmaB getObjByFaxFully(String key);

			public WrAdmaB getObjByFulldomain(String key);
			public WrAdmaB getObjByFulldomainFully(String key);

			public WrAdmaB getObjByLrNm(String key);
			public WrAdmaB getObjByLrNmFully(String key);

			public WrAdmaB getObjByMenb(String key);
			public WrAdmaB getObjByMenbFully(String key);

			public WrAdmaB getObjByNt(String key);
			public WrAdmaB getObjByNtFully(String key);

			public WrAdmaB getObjByOrgCd(String key);
			public WrAdmaB getObjByOrgCdFully(String key);

			public WrAdmaB getObjByOrgNm(String key);
			public WrAdmaB getObjByOrgNmFully(String key);

			public WrAdmaB getObjByOrgScal(String key);
			public WrAdmaB getObjByOrgScalFully(String key);

			public WrAdmaB getObjByOrgShnm(String key);
			public WrAdmaB getObjByOrgShnmFully(String key);

			public WrAdmaB getObjByOrgTp(String key);
			public WrAdmaB getObjByOrgTpFully(String key);

			public WrAdmaB getObjByPartdomain(String key);
			public WrAdmaB getObjByPartdomainFully(String key);

			public WrAdmaB getObjByTel(String key);
			public WrAdmaB getObjByTelFully(String key);

			public WrAdmaB getObjByTs(String key);
			public WrAdmaB getObjByTsFully(String key);

			public WrAdmaB getObjByWeb(String key);
			public WrAdmaB getObjByWebFully(String key);

			public WrAdmaB getObjByZip(String key);
			public WrAdmaB getObjByZipFully(String key);
			public WrAdmaB getObj(@Param(value="orgCd") String orgCd);
			public WrAdmaB getObjFully(@Param(value="orgCd") String orgCd);
			public Object[] keyString2Array(String value);
			public String keyArray2String(Object[] array);



	public long insert(WrAdmaB WrAdmaB);
	public int delete(@Param(value="orgCd") String orgCd);
	public int update(WrAdmaB WrAdmaB);
}
