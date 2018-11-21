package daiyun.pattern.single;

import java.util.HashMap;
import java.util.Map;

public class RegisterLazy {

  private static final Map<String, RegisterLazy> MAP = new HashMap<String, RegisterLazy>();

  private RegisterLazy(){

  }

  public static RegisterLazy getInstance(String name){
    if(name == null){
      name = RegisterLazy.class.getName();
    }

    if(MAP.get(name) == null){
      MAP.put(name, new RegisterLazy());
    }
    return MAP.get(name);
  }


}
