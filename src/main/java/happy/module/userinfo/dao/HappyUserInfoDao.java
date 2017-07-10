package happy.module.userinfo.dao;

import org.mybatis.pagination.extra.MyBatisRepository;

import java.util.List;

/**
 * 用户信息Dao
 */
@MyBatisRepository
public interface HappyUserInfoDao {

  /**
   * 取得用户信息列表
   *
   * @return
   */
  List<HappyUserInfo> getUserInfoList();
}
