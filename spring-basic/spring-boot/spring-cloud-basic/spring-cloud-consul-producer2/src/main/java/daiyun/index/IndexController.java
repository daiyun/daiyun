package daiyun.index;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author godaiyun
 * @date 2018-10-09 17:15.
 */
@RestController
public class IndexController {

  @RequestMapping("index")
  public String index() {
    return "Hello world 2!";
  }
}
