package daiyun.pattern.proxy;

public class Son implements Person{
  @Override
  public void findLove() {
    System.out.println("大长腿");
  }

  @Override
  public void findLove2() {
    System.out.println("===========");
  }
}
