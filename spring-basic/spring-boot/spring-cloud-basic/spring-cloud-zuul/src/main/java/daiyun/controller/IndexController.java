package daiyun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author godaiyun
 * @date 2018-09-29 16:31.
 */
@RestController
public class IndexController {

  private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

  @RequestMapping("/")
  public String home() {
    return "Hello world 1";
  }

  @Value("${server.port}")
  String port;

  @RequestMapping("/hi")
  public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
    LOGGER.info("get request...");
    return "hi " + name + " ,i am from port:" + port;
  }


}
