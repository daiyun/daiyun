package daiyun.controller;

import daiyun.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloControler.class);

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {

        LOGGER.info("get eqquest...");
        return helloService.hiService(name);
    }

    @GetMapping(value = "/")
    public String index() {
        return helloService.index();
    }

}
