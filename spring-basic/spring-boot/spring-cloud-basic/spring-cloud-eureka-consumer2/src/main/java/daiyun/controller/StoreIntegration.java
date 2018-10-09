package daiyun.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author godaiyun
 * @date 2018-10-09 11:31.
 */
@Component
public class StoreIntegration {

  @HystrixCommand(fallbackMethod = "defaultStores")
  public Object getStores(Map<String, Object> parameters) {
    //do stuff that might fail
    //
    return null;
  }

  public Object defaultStores(Map<String, Object> parameters) {
    return null;
  }
}
