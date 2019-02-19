package daiyun.middleware.zookeeper;

import java.util.concurrent.CountDownLatch;

public class LockMain {

  public static void main(String[] args) {
    CountDownLatch countDownLatch = new CountDownLatch(10);

    for (int i = 0; i < 10; i++) {
      new Thread(() -> {
        try {
          countDownLatch.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        DistributeLock distributeLock = new DistributeLock();
        distributeLock.lock();

      }, "thread=" + i).start();
      countDownLatch.countDown();
    }

  }
}
