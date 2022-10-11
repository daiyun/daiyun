package daiyun.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author godai
 * @date 2021/11/26 7:41
 * @description
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor)Executors.newFixedThreadPool(4);


        executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {


            }
        });

        /*CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
        }, executorService);

        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.allOf(voidCompletableFuture);

        try {
            voidCompletableFuture1.get(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }*/

        Collection<Callable<String>> task = new ArrayList<>();

        task.add(new Sleep100MILLSTask());
        task.add(new Sleep200MILLSTask());
        task.add(new SleepErrorMILLSTask());

        try {


            System.out.println("任务提交开始 " + System.currentTimeMillis());

            List<Future<String>> futures = executorService.invokeAll(task, 3000, TimeUnit.MILLISECONDS);

            System.out.println("任务提交结束 " + System.currentTimeMillis());

            for (int i = 0; i < futures.size(); i++) {
                System.out.println(System.currentTimeMillis() + " " + futures.get(i).get());
            }


            System.out.println(TimeUnit.MILLISECONDS.toNanos(1));
/*


            long completedTaskCount = ((ThreadPoolExecutor) executorService).getCompletedTaskCount();
            System.out.println(completedTaskCount);

            TimeUnit.SECONDS.sleep(2);

            completedTaskCount = ((ThreadPoolExecutor) executorService).getCompletedTaskCount();
            System.out.println(completedTaskCount);
*/


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class Sleep100MILLSTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("100-s");
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("100-e");
            return "100";
        }
    }

    static class Sleep200MILLSTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("2000-s");
            TimeUnit.MILLISECONDS.sleep(2000);
            System.out.println("2000-e");
            return "2000";
        }
    }

    static class SleepErrorMILLSTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            throw new Exception("error task");
//            return "error";
        }
    }
}
