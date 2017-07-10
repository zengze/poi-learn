package happy.module.userinfo.dao;
import java.io.Serializable;

/**
* 实体类 WrAdB
* happy-generator 1.0.0 生成于 2014-04-22 11:44:13
*/
public class WrAdB4Geo implements Serializable{

	
				private double adA;
				private String adCd;
				private String adNm;
				private String geom;
	
					public String getGeom() {
					return geom;
				}
				public void setGeom(String geom) {
					this.geom = geom;
				}
					public void setAdA(double adA)
					{
						this.adA = adA;
					};	
					public double getAdA()
					{
						return this.adA;
					};
					public void setAdCd(String adCd)
					{
						this.adCd = adCd;
					};	
					public String getAdCd()
					{
						return this.adCd;
					};
					public void setAdNm(String adNm)
					{
						this.adNm = adNm;
					};	
					public String getAdNm()
					{
						return this.adNm;
					};

}
