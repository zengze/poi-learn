package happy.module.userinfo.dao;
import happy.base.utility.TypeConvert;

import java.io.Serializable;
import java.sql.Date;


/**
* 实体类 HwPerson
* happy-generator 1.0.0 生成于 2014-06-14 17:24:00
*/
public class HwPerson implements Serializable{

	
				private Date birthdate;
				private String duty;
				private String email;
				private String icd;
				private String mobile;
				private String name;
				private String orgCdOfOrganize;
				
				private String organizeDesp;
				private int sex;
				private String token;
	
					public void setBirthdate(Date birthdate)
					{
						this.birthdate = birthdate;
					};	
					public Date getBirthdate()
					{
						return this.birthdate;
					};
					public void setDuty(String duty)
					{
						this.duty = duty;
					};	
					public String getDuty()
					{
						return this.duty;
					};
					public void setEmail(String email)
					{
						this.email = email;
					};	
					public String getEmail()
					{
						return this.email;
					};
					public void setIcd(String icd)
					{
						this.icd = icd;
					};	
					public String getIcd()
					{
						return this.icd;
					};
					public void setMobile(String mobile)
					{
						this.mobile = mobile;
					};	
					public String getMobile()
					{
						return this.mobile;
					};
					public void setName(String name)
					{
						this.name = name;
					};	
					public String getName()
					{
						return this.name;
					};
				public String getOrganize()
				{
				Object[] keys = {orgCdOfOrganize};				
				return WrAdmaB.keyArray2String(keys);

				};
				
					public void setOrgCdOfOrganize(String orgCdOfOrganize)
					{
						this.orgCdOfOrganize = orgCdOfOrganize;
					};	
					public String getOrgCdOfOrganize()
					{
						return this.orgCdOfOrganize;
					};
					
					public void setOrganizeDesp(String organizeDesp)
					{
						this.organizeDesp = organizeDesp;
					};	
					public String getOrganizeDesp()
					{
						return this.organizeDesp;
					};
					
					public void setSex(int sex)
					{
						this.sex = sex;
					};	
					public int getSex()
					{
						return this.sex;
					};
					public void setToken(String token)
					{
						this.token = token;
					};	
					public String getToken()
					{
						return this.token;
					};
	public String getId()
	{
		Object[] ret = {token};
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
