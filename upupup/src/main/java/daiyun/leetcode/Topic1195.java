package daiyun.leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 *
 */
public class Topic1195 {

    public static void main(String[] args) {
        Topic1195.FizzBuzz p = new Topic1195.FizzBuzz(20);
        new Thread() {
            public void run() {
                try {
                    p.fizz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Fizz");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    p.buzz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Buzz");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    p.fizzbuzz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("fizzbuzz");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    p.number(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

       /* try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    static class FizzBuzz {
        private int n;

        Semaphore semaphoreFizz = new Semaphore(0);
        Semaphore semaphoreBuzz = new Semaphore(0);
        Semaphore semaphoreBuzzFizz = new Semaphore(0);

        Semaphore semaphoreNum = new Semaphore(1);

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 3; i <= n; i = i + 3) {
                if (i % 5 != 0) {
                    semaphoreFizz.acquire();
                    printFizz.run();
                    semaphoreNum.release();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 5; i <= n; i = i + 5) {
                if (i % 3 != 0) {
                    semaphoreBuzz.acquire();
                    printBuzz.run();
                    semaphoreNum.release();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 15; i <= n; i = i + 15) {
                semaphoreBuzzFizz.acquire();
                printFizzBuzz.run();
                semaphoreNum.release();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                semaphoreNum.acquire();
                int a = i % 3;
                int b = i % 5;
                if (a == 0 && b == 0) {
                    semaphoreBuzzFizz.release(1);
                } else if (a == 0) {
                    semaphoreFizz.release(1);
                } else if (b == 0) {
                    semaphoreBuzz.release(1);
                } else {
                    printNumber.accept(i);
                    semaphoreNum.release();
                }
            }
        }
    }


}
