package daiyun;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring Boot 应用启动类
 *
 * @author godaiyun
 * @date 2018-02-24 11:05.
 */
@SpringBootApplication
public class Application {
  private static Logger log = Logger.getLogger(Application.class);

  public static ConfigurableApplicationContext applicationContext;

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(Application.class);
    applicationContext = application.run(args);

    log.info("web started!");

  }

}
