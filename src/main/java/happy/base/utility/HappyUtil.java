package happy.base.utility;

import java.util.concurrent.CountDownLatch;


import org.apache.log4j.Logger;

/**
 * HappyUtil
 */
public class HappyUtil {

  private static final Logger log = Logger.getLogger(HappyUtil.class);

  public static void wait(CountDownLatch waitOn) {
    try {
      waitOn.await();
    } catch(InterruptedException e) {
      log.error("Interrupted waiting on CountDownLatch", e);
      throw new RuntimeException("Interrupted waiting");
    }
  }

}
