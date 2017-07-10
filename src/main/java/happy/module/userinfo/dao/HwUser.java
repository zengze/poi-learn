package happy.module.userinfo.dao;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.io.Serializable;
import happy.base.utility.TypeConvert;


/**
* 实体类 HwUser
* happy-generator 1.0.0 生成于 2014-06-14 18:00:34
*/
public class HwUser implements Serializable{

	
				private String name;
				private String nt;
				private String password;
				private String tokenOfPerson;
				
				private String personDesp;
				private String tokenOfRole;
				
				private String roleDesp;
				private Integer state;
				private String token;
				private Timestamp ts;
	
					public void setName(String name)
					{
						this.name = name;
					};	
					public String getName()
					{
						return this.name;
					};
					public void setNt(String nt)
					{
						this.nt = nt;
					};	
					public String getNt()
					{
						return this.nt;
					};
					public void setPassword(String password)
					{
						this.password = password;
					};	
					public String getPassword()
					{
						return this.password;
					};
				public String getPerson()
				{
				Object[] keys = {tokenOfPerson};				
				return HwPerson.keyArray2String(keys);

				};
				
					public void setTokenOfPerson(String tokenOfPerson)
					{
						this.tokenOfPerson = tokenOfPerson;
					};	
					public String getTokenOfPerson()
					{
						return this.tokenOfPerson;
					};
					
					public void setPersonDesp(String personDesp)
					{
						this.personDesp = personDesp;
					};	
					public String getPersonDesp()
					{
						return this.personDesp;
					};
					
				public String getRole()
				{
				Object[] keys = {tokenOfRole};				
				return HwRole.keyArray2String(keys);

				};
				
					public void setTokenOfRole(String tokenOfRole)
					{
						this.tokenOfRole = tokenOfRole;
					};	
					public String getTokenOfRole()
					{
						return this.tokenOfRole;
					};
					
					public void setRoleDesp(String roleDesp)
					{
						this.roleDesp = roleDesp;
					};	
					public String getRoleDesp()
					{
						return this.roleDesp;
					};
					
					public void setState(Integer state)
					{
						this.state = state;
					};	
					public Integer getState()
					{
						return this.state;
					};
					public void setToken(String token)
					{
						this.token = token;
					};	
					public String getToken()
					{
						return this.token;
					};
					public void setTs(Timestamp ts)
					{
						this.ts = ts;
					};	
					public Timestamp getTs()
					{
						return this.ts;
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
