package daiyun.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author godaiyun
 * @date 2018-09-29 16:31.
 */
@Api("Index")
@RestController
@RequestMapping("/")
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Value("${server.port}")
    String port;

    @Value("${spring.application.name:no name}")
    String appName;

    @RequestMapping("/")
    public String home() {
        return "Hello world :" + appName;
    }

    @ApiOperation(value = "hi")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "path", required = true)
    })
    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        LOGGER.info("get request...");
        return "hi " + name + " ,i am from port:" + port;
    }

    @RequestMapping("/noParams")
    public String noParams() {
        return "Hello world " + System.currentTimeMillis();
    }

}
