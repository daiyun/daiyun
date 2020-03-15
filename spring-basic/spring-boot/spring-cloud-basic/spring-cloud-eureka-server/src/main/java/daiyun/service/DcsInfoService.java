package daiyun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author godaiyun
 * @date 2019-03-11 17:58.
 */
@Service
@ComponentScan
public class DcsInfoService {

    @Autowired
    private RestTemplate restTemplate;

    public Integer rpcPort(String addr, Integer port) {
        return 0;
    }
}
