package daiyun.thread;

public class ThreadLocalVar {

    public static ThreadLocal<Integer> t1 = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Integer get = t1.get();
                    System.out.println(Thread.currentThread().getName() + "==" + get);
                    t1.set(2);
                    get = t1.get();
                    System.out.println(Thread.currentThread().getName() + "==" + get);
                }
            }, "Thread--" + i);
            thread.start();
        }
    }
}
