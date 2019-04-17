package daiyun.thread;

public class ThreadInteruptA extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            if(this.interrupted()){
                break;
            }


            System.out.println(this.getName() + "=" + i);


        }
    }
}
