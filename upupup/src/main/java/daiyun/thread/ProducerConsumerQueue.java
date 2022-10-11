package daiyun.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author godai
 * @date 2021/8/4 21:01
 * @description
 */
public class ProducerConsumerQueue {

    private String[] queueArr;
    private int input;
    private int out;
    private int size;

    public ProducerConsumerQueue(int size) {
        this.queueArr = new String[size];
        input = 0;
        out = 0;
    }

    public synchronized String get() {
        System.out.println(Thread.currentThread() + "获得锁");
        if (size == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return get();
        } else {
            String s = queueArr[out++];
            size--;
            if (out == queueArr.length) {
                out = 0;
            }
            notify();
            return s;
        }
    }

    public synchronized void put(String mes) {
        if (size == queueArr.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            put(mes);
        } else {
            queueArr[input++] = mes;
            size++;
            if (input == queueArr.length) {
                input = 0;
            }
            notify();
        }
    }

    static class Consumer implements Runnable {

        private ProducerConsumerQueue queue;

        public Consumer(ProducerConsumerQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread() + "消费-》" + queue.get());
            }
        }
    }

    static class Producer implements Runnable {

        private ProducerConsumerQueue queue;
        private int size;

        public Producer(ProducerConsumerQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                String msg = "msg:" + (++size);
                queue.put(msg);
                System.out.println(Thread.currentThread() + "生成--》" + msg);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerQueue queue = new ProducerConsumerQueue(10);

        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();

        new Thread(new Producer(queue)).start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);

    }
}
