package daiyun.clone;

import java.util.HashMap;

public class CloneTest {

  public static void main(String[] args) throws CloneNotSupportedException {
    User u1 = new User("huang");
    Email email = new Email(" 6点下班");

    u1.setEmail(email);

    User u2 = (User) u1.clone();
    u2.setName("li");
    u2.getEmail().setContent("7点下班");

    System.out.println(u1.name);
    System.out.println(u2.name);

    System.out.println(u1.getEmail().content);
    System.out.println(u2.getEmail().content);

    HashMap<String, String> map = new HashMap<String, String>(10);
    map.put("", "");
  }
}
