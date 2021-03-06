package daiyun.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

  private Son person;

  public Object getInstance(Son person) {
    this.person = person;

    Class<?> obj = person.getClass();

    return Proxy.newProxyInstance(obj.getClassLoader(), obj.getInterfaces(), this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    System.out.println("我是代理，我要帮你做事，已经拿到了你的需求");
    System.out.println("准备做事");

    method.invoke(this.person, args);

    System.out.println("开始做事");

    return null;
  }
}
