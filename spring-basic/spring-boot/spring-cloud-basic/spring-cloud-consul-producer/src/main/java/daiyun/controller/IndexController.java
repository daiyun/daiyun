package daiyun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author godaiyun
 * @date 2018-10-09 14:31.
 */
@RestController
public class IndexController {

  @RequestMapping("index")
  public String index() {
    return "Hello world!";
  }
}
