package daiyun.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

  private Object oldObj;

  public Object getProxy(Object oldObj) {
    this.oldObj = oldObj;
    return Proxy.newProxyInstance(
        oldObj.getClass().getClassLoader(),
        oldObj.getClass().getInterfaces(),
        this);
  }


  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


    System.out.println("befor hander");
    method.invoke(oldObj, args);
    System.out.println("after hander");

    return null;
  }
}
