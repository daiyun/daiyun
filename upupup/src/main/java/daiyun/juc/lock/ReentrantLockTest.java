package daiyun.juc.lock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author godaiyun
 * @date 2018-11-14 16:24.
 */
public class ReentrantLockTest {

    public static void main(String[] args) {


        ShareQueue shareQueue = new ShareQueue();

        RunnableA runnableA = new RunnableA(shareQueue);
        RunnableB runnableB = new RunnableB(shareQueue);

        for (int i = 0; i < 5; i++) {
            Thread a = new Thread(runnableA, "runnableA-" + i);
            a.start();
        }
        for (int i = 0; i < 10; i++) {
            Thread b = new Thread(runnableB, "runnableB-" + i);
            b.start();
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static class RunnableA implements Runnable {

        private ShareQueue shareQueue;

        public RunnableA(ShareQueue runnableProduct) {
            this.shareQueue = runnableProduct;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    shareQueue.product();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static class RunnableB implements Runnable {

        private ShareQueue shareQueue;

        public RunnableB(ShareQueue runnableProduct) {
            this.shareQueue = runnableProduct;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    shareQueue.consumer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static class ShareQueue {

        private List<String> lists = new ArrayList<>();

        private Lock lock = new ReentrantLock(true);

        /**
         * 读写分开的唤醒条件能增加线程控制的灵活性，也能避免操作不当产生的假死
         */
        private Condition conditionP = lock.newCondition();
        private Condition conditionC = lock.newCondition();

        public ShareQueue() {
        }


        public void product() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread() + " P get lock " + lists.size() + " " + System.nanoTime());

                if (lists.size() > 0) {
                    System.out.println(Thread.currentThread() + " P wait " + lists.size() + " " + System.nanoTime());
                    conditionP.await();
                } else {
                    lists.add("1");
                    System.out.println(Thread.currentThread() + " P put " + lists.size() + " " + System.nanoTime());

                    System.out.println(Thread.currentThread() + " P signal C " + lists.size() + " " + System.nanoTime());
                    conditionC.signal();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void consumer() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread() + " C get lock " + lists.size() + " " + System.nanoTime());

                if (lists.size() == 0) {
                    System.out.println(Thread.currentThread() + " C wait " + lists.size() + " " + System.nanoTime());
                    conditionC.await();
                } else {
                    lists.remove(0);
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread() + " C clean " + lists.size() + " " + System.nanoTime());

                    System.out.println(Thread.currentThread() + " C signal P " + lists.size() + " " + System.nanoTime());
                    conditionP.signal();
                }


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


}
