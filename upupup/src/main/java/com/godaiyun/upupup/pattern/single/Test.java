package com.godaiyun.upupup.pattern.single;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

  public static void main(String[] args) {

    try {

      Hungry s1 = null;
      Hungry s2 = Hungry.getInstance();

      FileOutputStream out = new FileOutputStream("serializable.obj");
      ObjectOutputStream outStram = new ObjectOutputStream(out);
      outStram.writeObject(s2);
      outStram.flush();
      outStram.close();

      FileInputStream input = new FileInputStream("serializable.obj");
      ObjectInputStream inputStream = new ObjectInputStream(input);
      s1 = (Hungry) inputStream.readObject();
      inputStream.close();

      System.out.println(s1);
      System.out.println(s2);
      System.out.println(s1);


     /* int threadCount = 200;


      final CountDownLatch latch = new CountDownLatch(threadCount);

      long startTime = System.currentTimeMillis();
      for (int i = 0; i < threadCount; i++) {
        new Thread() {
          @Override
          public void run() {

            try {
              latch.await();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

            System.out.println(System.currentTimeMillis() + " " + Lazy.getInstance());
          }
        }.start();
        latch.countDown();
      }


      long endTime = System.currentTimeMillis();

      System.out.println("耗时:" + (endTime - startTime));

*/
    } catch (Exception e) {
      e.printStackTrace();
    }


  }
}
