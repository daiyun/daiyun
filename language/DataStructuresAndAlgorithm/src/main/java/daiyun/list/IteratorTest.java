package daiyun.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest {

  public static void main(String[] args) {

    IteratorTest test = new IteratorTest();

//    test.iteratorFor();


    List<Integer> L = new ArrayList<Integer>();
    L.add(1);
    L.add(2);
    L.add(3);
    L.add(4);
    L.add(5);
    L.add(6);

    List<Integer> P = new LinkedList<Integer>();
    P.add(2);
    P.add(3);
    P.add(5);
/*
    List R = test.listAnd(P, L);

    for (Object o : R) {
      System.out.println(o);
    }*/

    /*for (Integer i : test.josephus(5, 5)) {
      System.out.println(i);
    }*/

    test.singleLinkled();


  }

  public void singleLinkled(){
    SingleList<Integer> singleList = new IteratorTest.SingleList<Integer>();

    singleList.add(12);
    singleList.add(17);
    singleList.add(11);
    singleList.add(19);
    singleList.add(1);

    singleList.printStr();

    System.out.println("size:"+singleList.length());
    singleList.del(1);
    singleList.printStr();
    System.out.println("size:"+singleList.length());
    singleList.printStr();
    System.out.println("size:"+singleList.length());
  }

  public void iteratorFor() {
    List<String> list = new LinkedList<String>();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");


    Iterator<String> iter = list.iterator();

    list.add("5");

    while (iter.hasNext()) {
      iter.remove();
    }


    int i = 0;
    for (String s : list) {
      if (i == 0) {
        list.add("6");
      }
      i++;
      System.out.println(s);
    }

  }

  public void printLots(List<Integer> L, List<Integer> P) {
    Iterator<Integer> iteratorP = P.iterator();
    while (iteratorP.hasNext()) {
      Integer index = iteratorP.next();
      System.out.println(L.get(index));
    }
  }

  public List listAnd(List L1, List L2) {


    List res = new LinkedList();
    int index = 0;
    for (Object o : L1) {
      int searchIndex = sortedLiskContain(L2, index, o);
      if (searchIndex > -1) {
        res.add(o);
        index = searchIndex;
      }
    }

    return res;
  }

  public List listOr(List L1, List L2) {
    List res = new LinkedList();

    int index = 0;
    for (Object o : L1) {
      int search = sortedLiskContain(L2, index, o);
      if (search > -1) {
        index = search;
      } else {
        res.add(o);
      }
    }
    L2.addAll(res);

    return L2;
  }

  public int sortedLiskContain(List L, int index, Object o) {
    int res = -1;
    for (int i = index; i < L.size(); i++) {
      if (L.get(i).equals(o)) {
        res = i;
        break;
      }
    }
    return res;
  }

  public Integer[] josephus(int N, int M) {
    Integer[] list = new Integer[N];

    for (int i = 0; i < N; i++) {
      list[i] = (i + 1);
    }

    int end = N - 1;

    int p = 0;
    while (end > 0) {
      int delIndex = p + M;
      while (delIndex > end) {
        delIndex = delIndex - end - 1;
      }
      Integer delV = list[delIndex];
      int i = delIndex;
      for (; i < end; i++) {
        list[i] = list[i + 1];
      }
      list[i] = delV;
      end--;
      p = delIndex;
    }

    return list;
  }

  public class SingleList<T> {
    private Node<T> firstNode;
    private int currentSize = 0;

    public void add(T o) {
      Node node = new Node<T>();
      node.value = o;

      if (firstNode != null) {
        Node currentNode = firstNode;
        while (currentNode.next != null) {
          currentNode = currentNode.next;
        }
        currentNode.next = node;
      } else {
        firstNode = node;
      }
      currentSize++;
    }

    public int length() {
      return currentSize;
    }

    public void printStr() {
      Node node = firstNode;
      while (node != null) {
        System.out.println(node.value);
        node = node.next;
      }
    }

    public boolean contains(T o) {
      boolean flag = false;
      Node node = firstNode;
      while (node != null) {
        if (node.value.equals(o)) {
          flag = true;
          break;
        }
        node = node.next;
      }

      return flag;
    }

    public Object del(T o) {
      Node delNode = null;
      if (firstNode.value.equals(o)) {
        firstNode = firstNode.next;
        currentSize--;
        delNode = firstNode;
      }

      Node node = firstNode;

      while (node != null) {
        if(node.next != null){
          if (node.next.value.equals(o)) {

            delNode = node.next;
            currentSize--;
            node.next = node.next.next;
          }
          node = node.next;
        }

      }

      return delNode.value;
    }
  }

  public class Node<T> {
    public Node next;
    public T value;
  }


}
