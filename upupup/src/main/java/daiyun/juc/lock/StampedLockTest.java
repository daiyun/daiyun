package daiyun.juc.lock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {

    public static void main(String[] args) {

    }

    public static class ReadWriteTool {
        private int res = 0;

        private StampedLock stampedLock = new StampedLock();

        public String read() {
            long stamp = stampedLock.tryOptimisticRead();
            int currentX = res;
            if (!stampedLock.validate(stamp)) {
                stamp = stampedLock.readLock();
                try {
                    currentX = res;
                } finally {
                    stampedLock.unlockRead(stamp);
                }
            }
            return currentX + "";
        }


        public String read2() {

            long stamp = stampedLock.readLock();
            try {
                while (res == 0) {
                    long ws = stampedLock.tryConvertToWriteLock(stamp);
                    if (ws != 0L) {
                        stamp = ws;
                        res = res + 2;
                        break;
                    } else {
                        stampedLock.unlockRead(stamp);
                        stamp = stampedLock.writeLock();
                    }
                }
            } finally {
                stampedLock.unlock(stamp);
            }

            return "";
        }


        public void write() {
            long stamp = stampedLock.writeLock();
            try {
                res++;
            } finally {
                stampedLock.unlockWrite(stamp);
            }
        }
    }


}
