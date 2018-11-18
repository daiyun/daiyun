package com.godaiyun.upupup.pattern.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class JdkProxyTest {

  public static void main(String[] args) {


    Person person = null;
    try {
      person = (Person) new JdkProxy().getInstance(new Son());
    } catch (Exception e) {
      e.printStackTrace();
    }

//    person.findLove();
//    System.out.println(person.getClass());

    try {
      byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
      FileOutputStream fileOutputStream = new FileOutputStream("$Proxy0.class");

      System.out.println(bytes);
      fileOutputStream.write(bytes);
      fileOutputStream.close();


    } catch (Exception e) {
      e.printStackTrace();
    }


  }
}
