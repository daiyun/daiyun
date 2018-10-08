package daiyun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author godaiyun
 * @date 2018-10-08 09:58.
 */
@RestController
public class IndexController {

  @Autowired
  private StoreClient storeClient;

  @RequestMapping("/index")
  public String index() {
    return storeClient.name("123");
//    return "index";
  }
}
