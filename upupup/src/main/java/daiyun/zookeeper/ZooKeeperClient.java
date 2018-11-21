package daiyun.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZooKeeperClient {

  public static void main(String[] args) {
    ZooKeeper zooKeeper = null;
    try {

      final CountDownLatch countDownLatch = new CountDownLatch(1);
      // 原生的客户端在连接成果后的第一个状态是CONNECTING，需要状态变成CONNECTED后才能进行相应的节点操作
      zooKeeper = new ZooKeeper("172.27.52.60:2181," +
          "172.27.52.61:2181," +
          "172.27.52.62:2181," +
          "172.27.52.63:2181," +
          "172.27.52.64:2181," +
          "172.27.52.65:2181,", 4000, new Watcher() {
        public void process(WatchedEvent event) {
          System.out.println(event.toString());
          if (Event.KeeperState.SyncConnected == event.getState()) {
            countDownLatch.countDown();
          }
        }
      });

      countDownLatch.await();
      System.out.println(zooKeeper.getState());
/*
      // 添加一个节点(当父节点不存在的情况下将会创建失败)
      // 节点K,节点V,权限,类型
      zooKeeper.create("/zoo/zk-test-0", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

      Thread.sleep(1000);

      Stat stat = new Stat();

      // 获取一个节点的值，同时获取一个节点的属性值（属性值中的版本号用于修改删除等操作，避免并发操作错误）
      byte[] res = zooKeeper.getData("/zoo/zk-test-0", null, stat);

      System.out.println(new String(res));

      // 更新一个节点的值，更新之前需要先拿到节点属性的version值
      zooKeeper.setData("/zoo/zk-test-0", "1".getBytes(), stat.getVersion());

      byte[] res2 = zooKeeper.getData("/zoo/zk-test-0", null, stat);

      System.out.println(new String(res2));

      // 删除一个节点的值,删除之前需要拿到节点值得版本信息 如果节点下存在子节点 将会删除失败
      zooKeeper.delete("/zoo/zk-test-0", stat.getVersion());
*/


      // 原始的事件通知是单事件通知，完成一次事件通知后需要重新进行事件绑定
      // exists 绑定事件将会触发对应节点的创建、删除、修改的事件通知，对节点的子节点的事件操作将不会发送事件通知
      /*zooKeeper.exists("/zoo/zk-test-1", new Watcher() {
        public void process(WatchedEvent event) {
          System.out.println(event.getType() + "==" + event.getPath());
        }
      });
*/
/*      Stat state = new Stat();

      //绑定事件将会触发对应节点的删除、修改的事件通知(绑定的节点必须存在)
      zooKeeper.getData("/zoo/zk-test-1", new Watcher() {
        public void process(WatchedEvent event) {
          System.out.println(event.getType() + "==" + event.getPath());
        }
      }, state);*/

      //绑定事件将会触发对应节点(绑定的节点必须存在)子节点创建、删除
      Stat stat = new Stat();
      zooKeeper.getChildren("/zoo/zk-test-1", new Watcher() {
        public void process(WatchedEvent event) {
          System.out.println(event.getType() + "==" + event.getPath());
        }
      }, stat);

      System.in.read();


    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (KeeperException e) {
      e.printStackTrace();
    } finally {
      if (zooKeeper != null) {

        try {
          zooKeeper.close();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
