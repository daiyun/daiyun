package daiyun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author godaiyun
 * @date 2018-10-08 09:58.
 */
@RestController
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private StoreClient storeClient;

    @RequestMapping("/hi")
    public String index(@RequestParam String name) {

        LOGGER.info("get request...");
        return storeClient.name(name);
//    return "index";
    }
}
