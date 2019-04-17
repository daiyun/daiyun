package daiyun.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockNotice {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {

    }

    class MyThreadA extends Thread {

        @Override
        public void run() {
            super.run();

            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "== in lock");
                condition.wait();
                System.out.println(Thread.currentThread().getName() + "after notice");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class MyThreadB extends Thread {

        @Override
        public void run() {
            super.run();

            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "== in lock");
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "after notice");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
