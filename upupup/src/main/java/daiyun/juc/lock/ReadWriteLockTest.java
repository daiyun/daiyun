package daiyun.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    public static void main(String[] args) {

        ReadWriteTool readWriteTool = new ReadWriteTool();

        /**
         *
         */
        for (int i = 0; i < 5; i++) {
            RunnableRead runnableRead = new RunnableRead(readWriteTool);
            Thread read = new Thread(runnableRead, "read" + i);
            read.start();

            RunnableWrite runnableWrite = new RunnableWrite(readWriteTool);
            Thread write = new Thread(runnableWrite, "write" + i);
            write.start();
        }



    }

    public static class RunnableRead implements Runnable {

        private ReadWriteTool readWriteTool;


        public RunnableRead(ReadWriteTool readWriteTool) {
            this.readWriteTool = readWriteTool;
        }

        @Override
        public void run() {
            while (true) {
                readWriteTool.read();
            }
        }
    }

    public static class RunnableWrite implements Runnable {

        private ReadWriteTool readWriteTool;


        public RunnableWrite(ReadWriteTool readWriteTool) {
            this.readWriteTool = readWriteTool;
        }

        @Override
        public void run() {
            while (true) {
                readWriteTool.write();
            }
        }
    }


    public static class ReadWriteTool {
        private int a = 0;

        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public String read() {
            try {
                lock.readLock().lock();

                System.out.println("read hold count:" + lock.getReadHoldCount());
                System.out.println("read lock count:" + lock.getReadLockCount());
                System.out.println("write hold count:" + lock.getWriteHoldCount());
                System.out.println("queue " + lock.getQueueLength());

                for (int i = 0; i < 1; i++) {
                    System.out.println(Thread.currentThread() + " read " + a);

                    TimeUnit.SECONDS.sleep(1);
                }
                return a + "";
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("relase read lock " + System.nanoTime());
                lock.readLock().unlock();
            }
            return "";
        }

        public void write() {
            try {
                lock.writeLock().lock();
                lock.writeLock().tryLock();
                System.out.println("read hold count:" + lock.getReadHoldCount());
                System.out.println("read lock count:" + lock.getReadLockCount());
                System.out.println("write hold count:" + lock.getWriteHoldCount());
                System.out.println("queue " + lock.getQueueLength());
                for (int i = 0; i < 1; i++) {
                    a++;
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread() + " write lock " + a);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("relase write lock " + System.nanoTime());
                lock.writeLock().unlock();
            }
        }
    }
}
