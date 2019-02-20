package daiyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author godaiyun
 * @date 2018-09-29 17:15.
 */

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableDiscoveryClient
public class Application {

  public static void main(String[] args) {

    SpringApplication.run(Application.class, args);
  }
}
