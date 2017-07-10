package happy.module.userinfo.dao;

import happy.utils.general.TypeConvert;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 * 行政区划
 * 
 * 实体类 WrAdB happy-generator 1.0.0 生成于 2014-04-22 11:44:13
 */
public class WrAdB implements Serializable {
	private static final long serialVersionUID = 6960916454651000672L;
	
	private Double adA;
	private String adCd;
	private String adNm;
	@NotEmpty(message = "简称不能为空")
	private String adShnm;
	private String nt;
	private String jb;
	private String adCdOfParent;
	private String parentDesp;
	private Timestamp ts;
	private double jysl;	//地下水用水量
	private double qysl;	//地表水用水量
	private double signLon;	//标志经度
	private double signLat;	//标志纬度
	
	public double getSignLon() {
		return signLon;
	}

	public void setSignLon(double signLon) {
		this.signLon = signLon;
	}

	public double getSignLat() {
		return signLat;
	}

	public void setSignLat(double signLat) {
		this.signLat = signLat;
	}

	public double getJysl() {
		return jysl;
	}

	public void setJysl(double jysl) {
		this.jysl = jysl;
	}

	public double getQysl() {
		return qysl;
	}

	public void setQysl(double qysl) {
		this.qysl = qysl;
	}

	public void setAdA(Double adA) {
		if (adA == null) {
			adA = 0.0;
		}
		this.adA = adA;
	};

	public String getJb() {
		return jb;
	}


	public void setJb(String jb) {
		this.jb = jb;
	}

	@Range(min = 5, message = "区划面积太小了")
	public Double getAdA() {
		return this.adA;
	};

	public void setAdCd(String adCd) {
		this.adCd = adCd;
	};

	public String getAdCd() {
		return this.adCd;
	};

	public void setAdNm(String adNm) {
		this.adNm = adNm;
	};

	public String getAdNm() {
		return this.adNm;
	};

	public void setAdShnm(String adShnm) {
		this.adShnm = adShnm;
	};

	public String getAdShnm() {
		return this.adShnm;
	};

	public void setNt(String nt) {
		this.nt = nt;
	};

	public String getNt() {
		return this.nt;
	};

	public String getParent() {
		Object[] keys = { adCdOfParent };
		return WrAdB.keyArray2String(keys);

	};

	public void setAdCdOfParent(String adCdOfParent) {
		this.adCdOfParent = adCdOfParent;
	};

	public String getAdCdOfParent() {
		return this.adCdOfParent;
	};

	public void setParentDesp(String parentDesp) {
		this.parentDesp = parentDesp;
	};

	public String getParentDesp() {
		return this.parentDesp;
	};

	public void setTs(Timestamp ts) {
		this.ts = ts;
	};

	public Timestamp getTs() {
		return this.ts;
	};

	public String getId() {
		Object[] ret = { adCd };
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
			if (array[0]!=null) ret.append(array[i].toString());
		}
		return ret.toString();
	}
}
