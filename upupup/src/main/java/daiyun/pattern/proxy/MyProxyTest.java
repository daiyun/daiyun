package daiyun.pattern.proxy;

public class MyProxyTest {

  public static void main(String[] args) {

    Person person = (Person) new MyMeipo().getInstance(new Son());


    System.out.println(person.getClass());
    person.findLove2();
  }
}
