package com.godaiyun.upupup.pattern.single;

public class Lazy {


  private static Lazy lazy;

  private Lazy() {

  }

  public static Lazy getInstance() {
    if (lazy == null) {
      lazy = new Lazy();
    }
    return lazy;
  }
}
