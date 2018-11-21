package daiyun;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author godaiyun
 * @date 2018-11-15 14:31.
 */
public class ZookeeperConnectionTest implements Watcher {


  private static CountDownLatch countDownLatch = new CountDownLatch(1);
  private static ZooKeeper zooKeeper = null;


  public static void main(String[] args) {

    try {
      zooKeeper = new ZooKeeper("0.0.0.0:2181", 5000, new ZookeeperConnectionTest());
      start();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void start() {
    try {

      countDownLatch.await();
      System.out.println("zookeeper statu:" + zooKeeper.getState());

      //ZooDefs.Ids.OPEN_ACL_UNSAFE
      //CreateMode
     /* zooKeeper.create("/zk/test03", "0".getBytes(),
          ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL,
          new CreateEvenHander(), new String("create success!")
      );*/


      List<String> kyes = zooKeeper.getChildren("/zk", true);
//
      for (String s : kyes) {
        System.out.println(s);
      }


      Stat stat = new Stat();

      String getDate = new String(zooKeeper.getData("/zk", true, stat));

      System.out.println("get node data:" + getDate);
      System.out.println(stat.toString());

      zooKeeper.setData("/zk", "123".getBytes(), stat.getVersion());

      zooKeeper.exists("/zk/check", true);

      System.in.read();


      zooKeeper.close();

    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (KeeperException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void process(WatchedEvent watchedEvent) {
    if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
      System.out.println("event Type:" + watchedEvent.getType());

      if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
        countDownLatch.countDown();
        System.out.println("connected");
      } else if (Event.EventType.NodeCreated == watchedEvent.getType()) {
        try {
          zooKeeper.exists(watchedEvent.getPath(), true);
        } catch (KeeperException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      } else if (Event.EventType.NodeDeleted == watchedEvent.getType()) {
        try {
          zooKeeper.exists(watchedEvent.getPath(), true);
        } catch (KeeperException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      } else if (Event.EventType.NodeChildrenChanged == watchedEvent.getType()) {
        System.out.println("event type: node children change!");
        try {
          zooKeeper.getChildren(watchedEvent.getPath(), true);
        } catch (KeeperException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

}
