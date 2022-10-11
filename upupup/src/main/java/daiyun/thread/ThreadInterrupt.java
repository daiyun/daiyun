package daiyun.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author godai
 * @date 2021/8/4 22:21
 * @description
 */
public class ThreadInterrupt {

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true){
//                    System.out.println(interrupted());
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(isInterrupted());
                }
            }
        };
        thread.start();
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main:"+thread.isInterrupted());
        System.exit(0);
    }
}
