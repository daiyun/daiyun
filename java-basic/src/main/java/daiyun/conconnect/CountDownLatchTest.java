package daiyun.conconnect;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

  public static void main(String[] args) {
    CountDownLatch c = new CountDownLatch(3);

    ThreadA threadA = new ThreadA(c);
    ThreadA threadB = new ThreadA(c);
    ThreadA threadC = new ThreadA(c);

    threadA.start();
    threadB.start();
    threadC.start();

    try {
      c.await();
      System.out.println("handler over");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static class ThreadA extends Thread {

    private CountDownLatch lock;

    public ThreadA(CountDownLatch lock) {
      this.lock = lock;
    }

    @Override
    public void run() {
      lock.countDown();
    }
  }

}
