package daiyun.lock;

import java.util.concurrent.*;

public class DeadLock {
  public static Object resource1 = "1";
  public static Object resource2 = "2";

  public static void main(String[] args) throws InterruptedException {

    CountDownLatch countDownLatch = new CountDownLatch(2);
    CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
      @Override
      public void run() {
        System.out.println("start time:" + System.currentTimeMillis());
      }
    });

    ThreadOne threadOne = new ThreadOne(countDownLatch, cyclicBarrier);
    ThreadTwo threadTwo = new ThreadTwo(countDownLatch, cyclicBarrier);

    threadOne.start();
    threadTwo.start();

    /*countDownLatch.await();

    System.out.println("all thread exe");

    Executors.newCachedThreadPool();
    Executors.newSingleThreadExecutor();
    Executors.newFixedThreadPool(2);
    Executor executor = Executors.newScheduledThreadPool(2);*/
//    ((ScheduledExecutorService) executor).submit()

  }

  static class ThreadOne extends Thread {
    public Object resource1 = "1";
    public Object resource2 = "2";

    public ThreadOne(Object one, Object two) {
      this.resource1 = one;
      this.resource2 = two;
    }

    @Override
    public void run() {

      /*try {
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(ThreadOne.currentThread().getName() + "get start time:" + System.currentTimeMillis());
      try {
        ((CyclicBarrier) resource2).await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        e.printStackTrace();
      }

      System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName());

      try {
        TimeUnit.SECONDS.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }*/

      synchronized (resource1) {
        System.out.println(Thread.currentThread().getName() + " resource1 lock");

        try {
          TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        synchronized (resource2) {
          System.out.println(Thread.currentThread().getName() + " resource2 lock");
        }
      }
//      ((CountDownLatch) resource1).countDown();
    }
  }


  static class ThreadTwo extends Thread {
    public Object resource1 = "1";
    public Object resource2 = "2";

    public ThreadTwo(Object one, Object two) {
      this.resource1 = one;
      this.resource2 = two;
    }

    @Override
    public void run() {
      /*try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(ThreadOne.currentThread().getName() + "get start time:" + System.currentTimeMillis());
      try {
        ((CyclicBarrier) resource2).await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        e.printStackTrace();
      }

      System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName());

      try {
        TimeUnit.SECONDS.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }*/

      synchronized (resource2) {

        System.out.println(Thread.currentThread().getName() + " resource2 lock");

        try {
          TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        synchronized (resource1) {
          System.out.println(Thread.currentThread().getName() + " resource1 lock");
        }
      }

      ((CountDownLatch) resource1).countDown();
    }
  }
}
