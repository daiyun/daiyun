package daiyun.reflect;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxy implements MethodInterceptor {


  private Object oldObj;

  public Object getProxy(Object o) {
    this.oldObj = o;
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(o.getClass());
    enhancer.setCallback(this);
    return enhancer.create();
  }

  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {


    System.out.println("befor hander");
    methodProxy.invokeSuper(o, objects);
    System.out.println("after hander");

    return null;
  }

}
