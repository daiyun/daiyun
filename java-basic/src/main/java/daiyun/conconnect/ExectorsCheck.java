package daiyun.conconnect;

import java.util.concurrent.*;

public class ExectorsCheck extends ThreadPoolExecutor {

  public ExectorsCheck(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
  }

  public ExectorsCheck(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
  }

  public ExectorsCheck(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
  }

  public ExectorsCheck(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
  }


  public static void main(String[] args) {


    ExectorsCheck exectorsCheck = new ExectorsCheck(2,2,5,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(100));

    for(int i = 0;i< 100;i++){
      exectorsCheck.getStatus();

      exectorsCheck.submit(new Runnable() {
        public void run() {
          try {
            TimeUnit.MILLISECONDS.sleep(500);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      });

    }
    exectorsCheck.shutdown();


  }


  public void getStatus() {
    System.out.println("competed task size:" + getCompletedTaskCount());
    System.out.println("all task size:" + getTaskCount());
    System.out.println("queue size:" + getQueue().size());
    System.out.println("core thread size:"+getCorePoolSize());
    System.out.println("max thread size:"+getMaximumPoolSize());
  }

  @Override
  protected void beforeExecute(Thread t, Runnable r) {
    System.out.println("start");
    super.beforeExecute(t, r);
  }

  @Override
  protected void afterExecute(Runnable r, Throwable t) {
    System.out.println("after");
    super.afterExecute(r, t);
  }
}
