package daiyun.controller;

import daiyun.service.IBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author godaiyun
 * @date 2018-09-28 10:49.
 */

@Controller
public class IndexController {

  @Autowired
  private IBasicService iBasicService;

  @RequestMapping("/index")
  @ResponseBody
  public String index() {
    long time = System.currentTimeMillis();
    String world = iBasicService.hello(time + "");
//    String world = "index";
    System.out.println(world);

    return world;
  }
}
