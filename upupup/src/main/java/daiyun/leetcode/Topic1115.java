package daiyun.leetcode;

import java.util.concurrent.Semaphore;

public class Topic1115 {

    public static void main(String[] args) {
        FooBar p = new FooBar(2);
        new Thread() {
            public void run() {
                try {
                    p.foo(new Print_Foo());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    p.bar(new Print_Bar());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    static class Print_Bar implements Runnable {

        @Override
        public void run() {
            System.out.print("Bar");
        }
    }

    static class Print_Foo implements Runnable {

        @Override
        public void run() {
            System.out.print("foo");
        }
    }


    static class FooBar {
        private int n;

        Semaphore one = new Semaphore(1);
        Semaphore two = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                one.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                two.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                two.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                one.release();
            }
        }
    }
}
