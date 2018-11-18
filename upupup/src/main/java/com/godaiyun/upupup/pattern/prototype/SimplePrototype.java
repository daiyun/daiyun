package com.godaiyun.upupup.pattern.prototype;

import java.io.*;

public class SimplePrototype implements Cloneable, Serializable {

  public Name name;

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return deepClone();
  }

  protected Object deepClone() {
    try {
      ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream);
      objectOutputStream.writeObject(this);


      ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
      ObjectInputStream objectInputStream = new ObjectInputStream(arrayInputStream);
      SimplePrototype simplePrototype = (SimplePrototype) objectInputStream.readObject();
      return simplePrototype;

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    return null;
  }

}
