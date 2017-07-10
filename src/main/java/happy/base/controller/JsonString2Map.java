package happy.base.controller;

import java.util.Map;


import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;




public class JsonString2Map{
    public final static Logger log = Logger.getLogger(JsonString2Map.class);
	public static Object json2Map(String json)
	{
		try
		{
			Object jsonObj = JSON.parse(json);
			if(jsonObj != null)
			{
				return jsonObj;
			}
		}
		catch(Exception e)
		{
			log.warn(e);
		}
		return null;
	}
}
