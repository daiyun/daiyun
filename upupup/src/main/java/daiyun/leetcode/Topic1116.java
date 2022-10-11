package daiyun.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class Topic1116 {


    static class ZeroEvenOddA {
        private int n;

        Semaphore A = new Semaphore(1);
        Semaphore B = new Semaphore(0);
        Semaphore C = new Semaphore(0);

        public ZeroEvenOddA(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                A.acquire();
                printNumber.accept(0);
                if (i % 2 == 0) {
                    C.release();
                } else {
                    B.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i = i + 2) {
                B.acquire();
                printNumber.accept(i);
                A.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i = i + 2) {
                C.acquire();
                printNumber.accept(i);
                A.release();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOddA a = new ZeroEvenOddA(200);
        IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        };

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    a.zero(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    a.even(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    a.odd(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

    }


    static class ZeroEvenOdd {
        private int n;

        Semaphore A = new Semaphore(1);

        private AtomicInteger value = new AtomicInteger(1);
        private AtomicBoolean zeroFlag = new AtomicBoolean(true);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                A.acquire();
                if (value.get() > n) {
                    A.release();
                    break;
                }
                if (zeroFlag.get()) {
                    printNumber.accept(0);
                    zeroFlag.set(false);
                }
                A.release();
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                A.acquire();
                if (value.get() > n) {
                    A.release();
                    break;
                }
                if (!zeroFlag.get() && value.get() % 2 == 0) {
                    printNumber.accept(value.get());
                    value.incrementAndGet();
                    zeroFlag.set(true);
                }
                A.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                A.acquire();
                if (value.get() > n) {
                    A.release();
                    break;
                }
                if (!zeroFlag.get() && value.get() % 2 == 1) {
                    printNumber.accept(value.get());
                    value.incrementAndGet();
                    zeroFlag.set(true);
                }
                A.release();
            }
        }
    }
}
