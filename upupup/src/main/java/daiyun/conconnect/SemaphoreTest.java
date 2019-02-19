package daiyun.conconnect;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

  public static void main(String[] args) {
    Semaphore c = new Semaphore(1);

    ThreadA threadA = new ThreadA(c);
    ThreadA threadB = new ThreadA(c);
    ThreadA threadC = new ThreadA(c);

    threadA.start();
    threadB.start();
    threadC.start();


  }

  public static class ThreadA extends Thread {

    private Semaphore lock;

    public ThreadA(Semaphore lock) {
      this.lock = lock;
    }

    @Override
    public void run() {
      try {
        lock.acquire();

        System.out.println(Thread.currentThread() + " ...");
        TimeUnit.SECONDS.sleep(5);

        lock.release();

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
