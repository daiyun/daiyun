package daiyun.service;

import org.springframework.stereotype.Service;

@Service
public class BasicServiceImpl implements IBasicService {
  @Override
  public String hello(String world) {
    System.out.println(world);
    return "hello " + world;
  }
}
