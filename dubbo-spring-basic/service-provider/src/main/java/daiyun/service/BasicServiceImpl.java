package daiyun.service;

public class BasicServiceImpl implements IBasicService {
  public String hello(String world) {
    System.out.println(world);
    return "hello " + world;
  }
}
