package daiyun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexController {
  @Autowired
  private LoadBalancerClient loadBalancer;
  @Autowired
  private DiscoveryClient discoveryClient;

  /**
   * 获取所有服务
   */
  @RequestMapping("/services")
  public Object services() {
    return discoveryClient.getInstances("spring-cloud-consul-producer");
  }

  /**
   * 从所有服务中选择一个服务（轮询）
   */
  @RequestMapping("/discover")
  public Object discover() {

    ServiceInstance serviceInstance = loadBalancer.choose("spring-cloud-consul-producer");

    System.out.println("服务地址：" + serviceInstance.getUri());
    System.out.println("服务名称：" + serviceInstance.getServiceId());

    String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/index", String.class);
    System.out.println(callServiceResult);

    return callServiceResult;

  }

}
