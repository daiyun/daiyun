package com.godaiyun.upupup.pattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

  public Object getInstance(Class<?> clazz) throws Exception {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(clazz);
    enhancer.setCallback(this);

    return enhancer.create();
  }

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

    System.out.println("接受需求");
    methodProxy.invokeSuper(o, objects);
    System.out.println("需求完成");
    return null;
  }
}
