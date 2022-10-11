package daiyun.leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 *
 */
public class Topic1226 {

    public static void main(String[] args) {


       /* try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    class DiningPhilosophers {

        Semaphore semaphoreAll = new Semaphore(2);

        Semaphore[] semaphore = new Semaphore[5];


        public DiningPhilosophers() {
            semaphore[0] = new Semaphore(1);
            semaphore[1] = new Semaphore(1);
            semaphore[2] = new Semaphore(1);
            semaphore[3] = new Semaphore(1);
            semaphore[4] = new Semaphore(1);
        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {

            semaphoreAll.acquire();

            semaphore[philosopher].acquire();
            pickLeftFork.run();

            int right = philosopher - 1;
            if (right < 0) {
                right = 4;
            }
            semaphore[right].acquire();
            pickRightFork.run();

            eat.run();

            putLeftFork.run();
            semaphore[philosopher].release();

            putRightFork.run();
            semaphore[right].release();

            semaphoreAll.release();
        }
    }


}
