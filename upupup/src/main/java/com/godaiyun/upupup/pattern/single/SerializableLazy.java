package com.godaiyun.upupup.pattern.single;

import java.util.HashMap;
import java.util.Map;

public class SerializableLazy {

  private static final Map<String, SerializableLazy> MAP = new HashMap<String, SerializableLazy>();

  private SerializableLazy(){

  }

  public static SerializableLazy getInstance(String name){
    if(name == null){
      name = SerializableLazy.class.getName();
    }

    if(MAP.get(name) == null){
      MAP.put(name, new SerializableLazy());
    }
    return MAP.get(name);
  }

}
