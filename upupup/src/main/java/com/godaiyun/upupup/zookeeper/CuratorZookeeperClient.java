package com.godaiyun.upupup.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

public class CuratorZookeeperClient {

  public static void main(String[] args) throws Exception {
    CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().connectString("172.27.52.60:2181," +
        "172.27.52.61:2181," +
        "172.27.52.62:2181," +
        "172.27.52.63:2181," +
        "172.27.52.64:2181," +
        "172.27.52.65:2181,").
        sessionTimeoutMs(4000).
        retryPolicy(new ExponentialBackoffRetry(1000, 3)).
        namespace("zoo1").build();//需要制定操作的根节点（不要添加"/"）,所有的操作都在该根节点下完成，所有的节点路径都是相对于此根节点

    curatorFramework.start();

    // 能够自动创建父节点
   /* curatorFramework.create().
        creatingParentContainersIfNeeded().
        withMode(CreateMode.PERSISTENT).
        forPath("/zoo/zk-test-12", "12".getBytes());

    // 删除制定的节（这里自动删除其子节点）
    curatorFramework.delete().deletingChildrenIfNeeded().forPath("/zoo/zk-test-12");*/

    Stat stat = new Stat();
    curatorFramework.getData().storingStatIn(stat).forPath("/zoo/zk-test-12");

    curatorFramework.setData().withVersion(stat.getVersion()).forPath("/zoo/zk-test-12", "14".getBytes());

  }


}
