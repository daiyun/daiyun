package daiyun.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author godaiyun
 * @date 2018-09-26 14:32.
 */
@Controller
@RequestMapping("/")
public class IndexController {

  @RequestMapping("index")
  @ResponseBody
  public String index(HttpServletRequest request,
                      HttpServletResponse response) {
    System.out.println(request.getRequestURI());
    return "welcome!";
  }
}
