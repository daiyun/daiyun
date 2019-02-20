package daiyun.controller;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements StoreClient {
    @Override
    public String name(String name) {
        return "sorry " + name;
    }
}
