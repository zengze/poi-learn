package happy.module.userinfo.dao;

import java.io.Serializable;

/**
 * 用户信息
 */
public class HappyUserInfo implements Serializable {

  private String loginName;
  private String userName;
  private String adCd;

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getAdCd() {
    return adCd;
  }

  public void setAdCd(String adCd) {
    this.adCd = adCd;
  }
}
