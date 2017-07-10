package happy.base.controller;

import java.util.Map;
import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSON;

public  class Map2JsonString {
    public final static Logger log = Logger.getLogger(Map2JsonString.class);
	public static String map2String(Map map)
	{
		try
		{
			String jsonString = JSON.toJSON(map).toString();
			return jsonString;
		}
		catch(Exception e)
		{
			log.warn(e);
		}
		return null;
	}
}
