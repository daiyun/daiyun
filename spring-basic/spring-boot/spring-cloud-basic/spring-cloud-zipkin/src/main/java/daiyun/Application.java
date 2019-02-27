package daiyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author godaiyun
 * @date 2018-09-29 17:15.
 */

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class Application {

  public static void main(String[] args) {

    SpringApplication.run(Application.class, args);
  }
}
