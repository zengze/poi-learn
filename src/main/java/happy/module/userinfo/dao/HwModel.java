package happy.module.userinfo.dao;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.io.Serializable;
import happy.base.utility.TypeConvert;


/**
* 实体类 HwModel
* happy-generator 1.0.0 生成于 2014-05-06 15:47:02
*/
public class HwModel implements Serializable{

	
				private String json;
				private String name;
				private String nt;
				private String token;
	
					public void setJson(String json)
					{
						this.json = json;
					};	
					public String getJson()
					{
						return this.json;
					};
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
