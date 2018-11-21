package daiyun.pattern.proxy;

import java.lang.reflect.Method;

public interface MyInvokeHandler {

  Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
