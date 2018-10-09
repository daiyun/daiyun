package daiyun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

  @RequestMapping("/index")
  public String index() {
    return "hello world 3!";
  }

  @Autowired
  private LoadBalancerClient loadBalancer;
  @Autowired
  private DiscoveryClient discovery;

  @RequestMapping("/discovery")
  public Object discovery() {
    return loadBalancer.choose("spring-cloud-zookeeper-producer");
  }

  @RequestMapping("/all")
  public Object all() {
    return discovery.getServices();
  }


}
