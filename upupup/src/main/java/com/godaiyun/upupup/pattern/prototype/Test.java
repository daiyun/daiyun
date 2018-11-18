package com.godaiyun.upupup.pattern.prototype;

public class Test {

  public static void main(String[] args) {



    try {
      SimplePrototype simplePrototype = new SimplePrototype();


      Name name = new Name();
      name.name = "123";

      simplePrototype.name = name;


      SimplePrototype simplePrototype1 = (SimplePrototype) simplePrototype.clone();



      System.out.println(simplePrototype1);
      System.out.println(simplePrototype);

      System.out.println(simplePrototype1.name);
      System.out.println(simplePrototype.name);


    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }
}
