package happy.module.userinfo.dao;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.io.Serializable;
import happy.base.utility.TypeConvert;
import happy.module.userinfo.dao.HwResource;
import happy.module.userinfo.dao.HwResource;

/**
 * 实体类 HwLog happy-generator 1.0.0 生成于 2014-05-06 15:32:50
 */
public class HwLog implements Serializable {

	private String descr;
	private String module;
	private String nt;
	private String operator;
	private String oprt;
	private String nameOfResource;

	private String resourceDesp;
	private String token;
	private Timestamp ts;

	public void setDescr(String descr) {
		this.descr = descr;
	};

	public String getDescr() {
		return this.descr;
	};

	public void setModule(String module) {
		this.module = module;
	};

	public String getModule() {
		return this.module;
	};

	public void setNt(String nt) {
		this.nt = nt;
	};

	public String getNt() {
		return this.nt;
	};

	public void setOperator(String operator) {
		this.operator = operator;
	};

	public String getOperator() {
		return this.operator;
	};

	public void setOprt(String oprt) {
		this.oprt = oprt;
	};

	public String getOprt() {
		return this.oprt;
	};

	public String getResource() {
		Object[] keys = { nameOfResource };
		return HwResource.keyArray2String(keys);

	};

	public void setNameOfResource(String nameOfResource) {
		this.nameOfResource = nameOfResource;
	};

	public String getNameOfResource() {
		return this.nameOfResource;
	};

	public void setResourceDesp(String resourceDesp) {
		this.resourceDesp = resourceDesp;
	};

	public String getResourceDesp() {
		return this.resourceDesp;
	};

	public void setToken(String token) {
		this.token = token;
	};

	public String getToken() {
		return this.token;
	};

	public void setTs(Timestamp ts) {
		this.ts = ts;
	};

	public Timestamp getTs() {
		return this.ts;
	};

	public String getId() {
		Object[] ret = { token };
		return keyArray2String(ret);
	}

	static public Object[] keyString2Array(String value) {
		String[] keys = value.split("\\^");
		Object[] rets = { TypeConvert.String2String(keys[0]) };
		return rets;
	}

	static public Object getItemInKeyString(String value, int index) {
		String[] keys = value.split("\\^");
		Object[] rets = { TypeConvert.String2String(keys[0]) };
		return rets[index];
	}

	static public String keyArray2String(Object[] array) {
		StringBuffer ret = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			if (i != 0)
				ret.append("^");
			ret.append(array[i].toString());
		}
		return ret.toString();
	}
}
