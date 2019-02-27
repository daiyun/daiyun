package com.daiyun.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author godaiyun
 * @date 2019-02-27 10:40.
 */
@Service
public class IndexService {

    @Value("${daiyun.config.url}")
    private String configUrl;


    public String getConfigUrl() {
        return configUrl;
    }
}
