package daiyun.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author godaiyun
 * @date 2018-10-08 10:01.
 */
@FeignClient(name = "eureka-consumer2-dev")
public interface StoreClient {
  @RequestMapping(value = "/hi")
  String name(@RequestParam("name") String name);
}
