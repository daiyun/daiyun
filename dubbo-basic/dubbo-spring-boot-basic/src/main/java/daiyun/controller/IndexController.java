package daiyun.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import daiyun.service.IBasicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author godaiyun
 * @date 2018-09-28 16:24.
 */
@Controller
public class IndexController {

  @Reference
  private IBasicService iBasicService;

  @RequestMapping("index")
  @ResponseBody
  public String index() {

    return "index" + iBasicService.hello("123");
  }
}
