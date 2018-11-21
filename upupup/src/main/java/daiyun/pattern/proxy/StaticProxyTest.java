package daiyun.pattern.proxy;

public class StaticProxyTest {

  public static void main(String[] args) {

    // 静态代理
    Person person = new Son();

    Meipo meipo = new Meipo(person);

    meipo.findLove();
  }



}
