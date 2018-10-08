package daiyun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author godaiyun
 * @date 2018-09-28 14:32.
 */
@Controller
public class IndexController {

  @RequestMapping("/index")
  @ResponseBody
  public String index() {
    return "index";
  }
}
