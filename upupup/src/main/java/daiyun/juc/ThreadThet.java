package daiyun.juc;

import java.util.concurrent.TimeUnit;

public class ThreadThet {

  private static ThreadLocal<Integer> num = new ThreadLocal<Integer>() {
    @Override
    protected Integer initialValue() {
      return 0;
    }
  };

  public static void main(String[] args) throws InterruptedException {

    for (int i = 0; i < 5; i++) {
      new Thread(() -> {
        int old = num.get();
        num.set(old + 5);
        System.out.println(old);
      }, "thread-" + i).start();

    }


    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("123");
      }
    });

    thread1.start();
    thread1.join();
    System.out.println("345");


    ThreadNum1 testThread = new ThreadNum1();
    System.out.println("before");
    testThread.run();

    System.out.println("after");

  }


  static class ThreadNum1 {

    String lock = "";

    public void run() {
      synchronized (lock) {
        try {
          lock.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
