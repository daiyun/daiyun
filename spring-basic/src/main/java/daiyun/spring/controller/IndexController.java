package daiyun.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author godaiyun
 * @date 2018-09-26 14:32.
 */
@Controller
@RequestMapping("/")
public class IndexController {

  @RequestMapping("index")
  @ResponseBody
  public String index() {
    System.out.println("index");
    return "welcome!";
  }
}
