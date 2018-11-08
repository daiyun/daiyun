package daiyun.controller;

import daiyun.service.NameService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author godaiyun
 * @date 2018-11-08 14:36.
 */
@Controller
public class IndexController {

  @Autowired
  private NameService nameService;

  @RequestMapping("/index")
  @ResponseBody
  public String index(@Param("name") String name) {
    System.out.println("select " + name);

    int res = nameService.selectByName(name);

    System.out.println("res:" + res);

    return res + "";
  }


}
