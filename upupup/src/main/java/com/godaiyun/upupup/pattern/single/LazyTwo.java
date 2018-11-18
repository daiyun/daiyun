package com.godaiyun.upupup.pattern.single;

public class LazyTwo {


  private static LazyTwo lazy;

  private LazyTwo(){

  }

  public static synchronized LazyTwo getInstance(){
    if(lazy == null){
      lazy = new LazyTwo();
    }
    return lazy;
  }
}
