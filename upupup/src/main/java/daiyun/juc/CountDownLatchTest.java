package daiyun.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch c = new CountDownLatch(3);

        ThreadA threadA = new ThreadA(c);
        ThreadA threadB = new ThreadA(c);
        ThreadA threadC = new ThreadA(c);

        try {
            threadA.start();
            threadA.join();
            threadB.start();
            threadB.join();
            threadC.start();
            threadC.join();
        } catch (Exception e) {
            e.printStackTrace();
        }


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
                System.out.println(Thread.currentThread());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.countDown();


        }
    }

}
