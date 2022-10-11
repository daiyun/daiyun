package daiyun.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Topic1114 {

    class ThreadA implements Runnable {

        private Foo foo;

        public ThreadA(Foo foo) {
            this.foo = foo;
        }

        @Override
        public void run() {
            try {
                foo.first(new PrintThreadA());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    class PrintThreadA implements Runnable{
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    class ThreadB implements Runnable {

        private Foo foo;

        public ThreadB(Foo foo) {
            this.foo = foo;
        }

        @Override
        public void run() {
            try {
                foo.first(new PrintThreadB());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    class PrintThreadB implements Runnable{
        @Override
        public void run() {
            System.out.println("B");
        }
    }

    class ThreadC implements Runnable {

        private Foo foo;

        public ThreadC(Foo foo) {
            this.foo = foo;
        }

        @Override
        public void run() {
            try {
                foo.first(new PrintThreadC());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    class PrintThreadC implements Runnable{
        @Override
        public void run() {
            System.out.println("C");
        }
    }

    class Foo {


        Lock lock = new ReentrantLock();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            try {
                lock.lock();

                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                condition2.signalAll();
            } finally {

                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            try {
                lock.lock();
                condition2.await();
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                condition3.signalAll();
            } finally {

                lock.unlock();
            }

        }

        public void third(Runnable printThird) throws InterruptedException {
            try {
                lock.lock();
                condition3.await();
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
            } finally {
                lock.unlock();
            }
        }
    }

    class FooA {
        Semaphore two = new Semaphore(0);
        Semaphore three = new Semaphore(0);

        public FooA() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            two.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            two.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            three.release();

        }

        public void third(Runnable printThird) throws InterruptedException {
            three.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
