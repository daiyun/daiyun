package com.godaiyun.upupup.pattern.proxy;

public class CglibTest {

  public static void main(String[] args) {


    try {
      Son son = (Son) new CglibProxy().getInstance(Son.class);
      son.findLove();
      System.out.println(son.getClass());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
