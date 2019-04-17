package daiyun.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnditionTest {

    public static void main(String[] args) {

        ConnditionTestTool connditionTestTool = new ConnditionTestTool();

        for (int i = 0; i < 500; i++) {
            RunnableA job = new RunnableA(connditionTestTool);
            Thread thread = new Thread(job, "--thread" + i);
            thread.start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        connditionTestTool.signal();


    }

    public static class RunnableA implements Runnable {
        private ConnditionTestTool connditionTestTool;

        public RunnableA(ConnditionTestTool connditionTestTool) {
            this.connditionTestTool = connditionTestTool;
        }

        @Override
        public void run() {
            connditionTestTool.awaitA();
        }
    }

    public static class ConnditionTestTool {
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void awaitA() {
            try {
                lock.lock();
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread() + " A get lock and await...");
                condition.await();
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread() + " A get single to weakup");
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void awaitB() {
            try {
                lock.lock();
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread() + " B get lock and await...");
                condition.await();
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread() + " B get single to weakup");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }


        public void signal() {
            try {
                lock.lock();
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread() + " do signal");
                // weakup one the condition first waiter
                condition.signal();
            } finally {
                lock.unlock();
            }
        }

        public void signalAll() {
            try {
                lock.lock();
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread() + " do signalAll");
                condition.signalAll();
            } finally {

                lock.unlock();
            }
        }
    }

}
