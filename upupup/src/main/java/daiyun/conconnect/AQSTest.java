package daiyun.conconnect;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author godaiyun
 * @date 2018-11-14 16:24.
 */
public class AQSTest {

  public static void main(String[] args) {
    Lock lock = new ReentrantLock();
//    String lock = "lock";

    ThreadA threadA = new ThreadA(lock);
    ThreadB threadB = new ThreadB(lock);


    threadA.start();
    /*try {
      threadA.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }*/

    threadB.start();

    try {
      System.in.read();
    } catch (IOException e) {
      e.printStackTrace();
    }
    /*try {
      threadB.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }*/

  }

  public static class ThreadA extends Thread {
    private Lock lock;

    public ThreadA(Lock lock) {
      this.lock = lock;
    }

    @Override
    public void run() {
      System.out.println("ThreadA run...");

      lock.lock();
      System.out.println("ThreadA get lock...");
      try {
        System.out.println("ThreadA 阻塞");
        lock.wait(1000);
        System.out.println("ThreadA 唤醒");

        TimeUnit.SECONDS.sleep(2);
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  }


  public static class ThreadB extends Thread {
    private Lock lock;

    public ThreadB(Lock lock) {
      this.lock = lock;
    }

    @Override
    public void run() {

      System.out.println("ThreadB run...");
      lock.lock();
      System.out.println("ThreadB get lock...");
      try {
        TimeUnit.SECONDS.sleep(2);

        System.out.println("ThreadB notifyAll");

//        lock.notify();

      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  }


}
