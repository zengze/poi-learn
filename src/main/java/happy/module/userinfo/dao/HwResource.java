package happy.module.userinfo.dao;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.io.Serializable;
import happy.base.utility.TypeConvert;


/**
* 实体类 HwResource
* happy-generator 1.0.0 生成于 2014-05-06 16:18:30
*/
public class HwResource implements Serializable{

	
				private String caption;
				private String name;
				private String nt;
				private String oprt;
				private String nameOfParent;
				
				private String parentDesp;
				private Timestamp ts;
				private String type;
				private String url;
				private String parentCd;
	
					public void setCaption(String caption)
					{
						this.caption = caption;
					};	
					public String getCaption()
					{
						return this.caption;
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
					public void setOprt(String oprt)
					{
						this.oprt = oprt;
					};	
					public String getOprt()
					{
						return this.oprt;
					};
				public String getParent()
				{
				Object[] keys = {nameOfParent};				
				return HwResource.keyArray2String(keys);

				};
				
					public void setNameOfParent(String nameOfParent)
					{
						this.nameOfParent = nameOfParent;
					};	
					public String getNameOfParent()
					{
						return this.nameOfParent;
					};
					
					public void setParentDesp(String parentDesp)
					{
						this.parentDesp = parentDesp;
					};	
					public String getParentDesp()
					{
						return this.parentDesp;
					};
					
					public void setTs(Timestamp ts)
					{
						this.ts = ts;
					};	
					public Timestamp getTs()
					{
						return this.ts;
					};
					public void setType(String type)
					{
						this.type = type;
					};	
					public String getType()
					{
						return this.type;
					};
					public void setUrl(String url)
					{
						this.url = url;
					};	
					public String getUrl()
					{
						return this.url;
					};
					public String getParentCd() {
						return parentCd;
					}
					public void setParentCd(String parentCd) {
						this.parentCd = parentCd;
					}
	public String getId()
	{
		Object[] ret = {name};
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
