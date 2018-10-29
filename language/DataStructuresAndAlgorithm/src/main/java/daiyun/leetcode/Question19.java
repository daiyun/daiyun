package daiyun.leetcode;

import java.util.LinkedList;

public class Question19 {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {

    LinkedList<ListNode> stack = new LinkedList<>();
    ListNode p = head;
    while (p != null) {
      stack.push(p);
      p = p.next;
    }

    ListNode delNode = null;
    ListNode preNode = null;
    for (int i = 0; i <= n; i++) {
      ListNode pp = stack.poll();
      if (i == n - 1) {
        delNode = pp;
      }
      if (i == n) {
        preNode = pp;
      }
    }
    if (preNode != null) {
      preNode.next = delNode.next;
    }

    return head;
  }
}
