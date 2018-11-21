package daiyun.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.io.IOException;

/**
 * @author godaiyun
 * @date 2018-11-15 16:13.
 */
public class CuratorTest {
  public static void main(String[] args) throws Exception {
    RetryPolicy retryPolicy = new ExponentialBackoffRetry(10000, 3);

//    CuratorFramework zookeeper = CuratorFrameworkFactory.
//        newClient("0.0.0.0:2181", 5000, 3000, retryPolicy);


    CuratorFramework zookeeper = CuratorFrameworkFactory
        .builder()
        .connectString("0.0.0.0:2181")
        .sessionTimeoutMs(5000)
        .retryPolicy(retryPolicy)
        .namespace("curator")
        .build();

    zookeeper.start();

    zookeeper.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/test01");


    try {
      System.in.read();
    } catch (IOException e) {
      e.printStackTrace();
    }

    zookeeper.close();


  }

}
