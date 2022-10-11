package daiyun.thread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author godai
 * @date 2022/9/13 8:33
 * @description
 */
public class NotSafeThread {

    public Map<String, String> requestHandler(List<String> lists) {
        if (lists == null) {
            return null;
        }
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Map<String, String> res = new HashMap<>();
        for (String item : lists) {
            executorService.submit(() -> {
                res.put(item, item);
            });
        }


        return res;
    }
}
