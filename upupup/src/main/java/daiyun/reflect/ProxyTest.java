package daiyun.reflect;

public class ProxyTest {

  public static void main(String[] args) {
    /*DynamicProxy proxy = new DynamicProxy();

    Playment play = (Playment) proxy.getProxy(new ThirdPlayment());

    play.doPlay("huang");*/


    CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy();
    ThirdPlayment thirdPlayment = (ThirdPlayment) cglibDynamicProxy.getProxy(new ThirdPlayment());

    thirdPlayment.doPlay("huang");


  }
}
