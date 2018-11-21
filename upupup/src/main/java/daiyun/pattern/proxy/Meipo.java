package daiyun.pattern.proxy;

public class Meipo {

  private Person person;

  public Meipo(Person person) {
    this.person = person;
  }

  public void findLove() {
    person.findLove();
  }
}
