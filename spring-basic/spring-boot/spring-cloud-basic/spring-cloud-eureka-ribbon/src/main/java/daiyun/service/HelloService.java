package daiyun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://EUREKA-CONSUMER-DEV/hi?name=" + name, String.class);
    }


    public String index() {
        return restTemplate.getForObject("http://EUREKA-CONSUMER-DEV/", String.class);
    }

}
