package happy.module.userinfo.dao;
import happy.base.utility.TypeConvert;

import java.io.Serializable;
import java.sql.Timestamp;


/**
* 实体类 WrAdmaB
* happy-generator 1.0.0 生成于 2014-06-14 18:47:42
*/
public class WrAdmaB implements Serializable{

	
				private String addr;
				private String adCdOfDistrict;
				
				private String districtDesp;
				private String email;
				private String fax;
				private String fulldomain;
				private String lrNm;
				private String menb;
				private String nt;
				private String orgCd;
				private String orgNm;
				private String orgScal;
				private String orgShnm;
				private String orgTp;
				private String orgCdOfParent;
				
				private String parentDesp;
				private String partdomain;
				private String tel;
				private Timestamp ts;
				private String web;
				private String zip;
				
				private String orgTp4view;
				public String getOrgTp4view() {
					if("1".equals(orgTp)) return "国家机关（行政主管部门）";
					if("2".equals(orgTp)) return "事业单位";
					if("3".equals(orgTp)) return "企业";
					if("4".equals(orgTp)) return "社会团体";
					if("5".equals(orgTp)) return "乡镇水利管理单位";
					if("9".equals(orgTp)) return "其他";
					return orgTp4view;
				}
				
				private OrgScal orgScal4View;
				public OrgScal getOrgScal4View() {
					if(orgScal!=null)return OrgScal.valueOf("E" + orgScal);
					return orgScal4View;
				}
				public enum OrgScal
				{
					E1("正部（省）级"), 
					E2("副部（省）级"), 
					E3("正厅级"),
					E4("副厅级"), 
					E5("正处级"), 
					E6("副处级"), 
					E7("正科级"), 
					E8("副科级"), 
					E9("其他"), 
					;
					
					private String value;

					private OrgScal(String value)
					{
						this.value = value;
					}

					public String getValue()
					{
						return value;
					}
				}

				
				public void setAddr(String addr)
					{
						this.addr = addr;
					};	
					public String getAddr()
					{
						return this.addr;
					};
				public String getDistrict()
				{
				Object[] keys = {adCdOfDistrict};				
				return WrAdB.keyArray2String(keys);

				};
				
					public void setAdCdOfDistrict(String adCdOfDistrict)
					{
						this.adCdOfDistrict = adCdOfDistrict;
					};	
					public String getAdCdOfDistrict()
					{
						return this.adCdOfDistrict;
					};
					
					public void setDistrictDesp(String districtDesp)
					{
						this.districtDesp = districtDesp;
					};	
					public String getDistrictDesp()
					{
						return this.districtDesp;
					};
					
					public void setEmail(String email)
					{
						this.email = email;
					};	
					public String getEmail()
					{
						return this.email;
					};
					public void setFax(String fax)
					{
						this.fax = fax;
					};	
					public String getFax()
					{
						return this.fax;
					};
					public void setFulldomain(String fulldomain)
					{
						this.fulldomain = fulldomain;
					};	
					public String getFulldomain()
					{
						return this.fulldomain;
					};
					public void setLrNm(String lrNm)
					{
						this.lrNm = lrNm;
					};	
					public String getLrNm()
					{
						return this.lrNm;
					};
					public void setMenb(String menb)
					{
						this.menb = menb;
					};	
					public String getMenb()
					{
						return this.menb;
					};
					public void setNt(String nt)
					{
						this.nt = nt;
					};	
					public String getNt()
					{
						return this.nt;
					};
					public void setOrgCd(String orgCd)
					{
						this.orgCd = orgCd;
					};	
					public String getOrgCd()
					{
						return this.orgCd;
					};
					public void setOrgNm(String orgNm)
					{
						this.orgNm = orgNm;
					};	
					public String getOrgNm()
					{
						return this.orgNm;
					};
					public void setOrgScal(String orgScal)
					{
						this.orgScal = orgScal;
					};	
					public String getOrgScal()
					{
						return this.orgScal;
					};
					public void setOrgShnm(String orgShnm)
					{
						this.orgShnm = orgShnm;
					};	
					public String getOrgShnm()
					{
						return this.orgShnm;
					};
					public void setOrgTp(String orgTp)
					{
						this.orgTp = orgTp;
					};	
					public String getOrgTp()
					{
						return this.orgTp;
					};
				public String getParent()
				{
				Object[] keys = {orgCdOfParent};				
				return WrAdmaB.keyArray2String(keys);

				};
				
					public void setOrgCdOfParent(String orgCdOfParent)
					{
						this.orgCdOfParent = orgCdOfParent;
					};	
					public String getOrgCdOfParent()
					{
						return this.orgCdOfParent;
					};
					
					public void setParentDesp(String parentDesp)
					{
						this.parentDesp = parentDesp;
					};	
					public String getParentDesp()
					{
						return this.parentDesp;
					};
					
					public void setPartdomain(String partdomain)
					{
						this.partdomain = partdomain;
					};	
					public String getPartdomain()
					{
						return this.partdomain;
					};
					public void setTel(String tel)
					{
						this.tel = tel;
					};	
					public String getTel()
					{
						return this.tel;
					};
					public void setTs(Timestamp ts)
					{
						this.ts = ts;
					};	
					public Timestamp getTs()
					{
						return this.ts;
					};
					public void setWeb(String web)
					{
						this.web = web;
					};	
					public String getWeb()
					{
						return this.web;
					};
					public void setZip(String zip)
					{
						this.zip = zip;
					};	
					public String getZip()
					{
						return this.zip;
					};
	public String getId()
	{
		Object[] ret = {orgCd};
		return keyArray2String(ret);
	}
	static public Object[] keyString2Array(String value)
	{
		String[] keys = value.split("\\^");
		Object[] rets = {TypeConvert.String2String(keys[0])};
		return rets;
	}
	static public Object getItemInKeyString(String value,int index)
	{
		String[] keys = value.split("\\^");
		Object[] rets = {TypeConvert.String2String(keys[0])};
		return rets[index];
	}

	static public String keyArray2String(Object[] array)
	{
		StringBuffer ret = new StringBuffer();
		for(int i = 0 ; i < array.length;i++)
		{
			if(i != 0) ret.append("^");
			ret.append(array[i].toString());
		}
		return ret.toString();
	}
}
