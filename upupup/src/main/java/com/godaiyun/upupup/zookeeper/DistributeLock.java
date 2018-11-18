package com.godaiyun.upupup.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class DistributeLock implements Lock, Watcher {

  private ZooKeeper zk;

  private String ROOK_NODE = "/lock-1";
  private String CURRENT_NODE;
  private String WAIT_LOCK;

  private CountDownLatch countDownLatch;

  public DistributeLock() {
    try {
      zk = new ZooKeeper("172.27.52.60:2181", 4000, this);

      Stat stat = zk.exists(ROOK_NODE, false);
      if (stat == null) {
        zk.create(ROOK_NODE, "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
      }

    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (KeeperException e) {
      e.printStackTrace();
    }
  }

  public void lock() {
    if (this.tryLock()) {

      System.out.println(Thread.currentThread().getName() + "获得锁成功:" + CURRENT_NODE);
      return;
    }

    try {
      waitForLock(WAIT_LOCK);
    } catch (KeeperException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  private boolean waitForLock(String prev) throws KeeperException, InterruptedException {
    Stat stat=zk.exists(prev,true);//监听当前节点的上一个节点
    if(stat!=null){
      System.out.println(Thread.currentThread().getName()+"->等待锁"+ROOK_NODE+"/"+prev+"释放");
      countDownLatch=new CountDownLatch(1);
      countDownLatch.await();
      //TODO  watcher触发以后，还需要再次判断当前等待的节点是不是最小的
      System.out.println(Thread.currentThread().getName()+"->获得锁成功");
    }
    return true;
  }

  public void lockInterruptibly() throws InterruptedException {

  }

  public boolean tryLock() {

    try {
      CURRENT_NODE = zk.create(ROOK_NODE + "/", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

      System.out.println(Thread.currentThread().getName() + "=>" + CURRENT_NODE + " 尝试获取锁");

      List<String> children = zk.getChildren(ROOK_NODE, false);

      SortedSet<String> sortedSet = new TreeSet<String>();

      for (String node : children) {
        sortedSet.add(ROOK_NODE + "/" + node);
      }

      String firstNode = sortedSet.first();

      SortedSet<String> lessThenMe = ((TreeSet<String>) sortedSet).headSet(CURRENT_NODE);

      if (firstNode.equals(CURRENT_NODE)) {
        return true;
      }

      if (lessThenMe.size() > 0) {
        WAIT_LOCK = lessThenMe.last();
      }

    } catch (KeeperException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return false;
  }

  public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
    return false;
  }

  public void unlock() {
    System.out.println(Thread.currentThread().getName()+"->释放锁"+CURRENT_NODE);
    try {
      zk.delete(CURRENT_NODE,-1);
      CURRENT_NODE=null;
      zk.close();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (KeeperException e) {
      e.printStackTrace();
    }
  }

  public Condition newCondition() {
    return null;
  }

  public void process(WatchedEvent event) {
    if(this.countDownLatch!=null){
      this.countDownLatch.countDown();
    }
  }
}
