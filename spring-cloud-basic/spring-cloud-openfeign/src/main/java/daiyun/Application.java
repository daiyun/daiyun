package daiyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author godaiyun
 * @date 2018-10-08 09:58.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Application {

  public static void main(String[] args) {

    SpringApplication.run(Application.class, args);
  }
}
