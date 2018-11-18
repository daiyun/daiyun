package com.godaiyun.upupup.pattern.single;

import java.io.Serializable;

public class Hungry implements Serializable {

  private static Hungry hungry = new Hungry();

  private Hungry(){

  }

  public static Hungry getInstance(){
    return hungry;
  }

  private Object readResolve(){
    return hungry;
  }


}
