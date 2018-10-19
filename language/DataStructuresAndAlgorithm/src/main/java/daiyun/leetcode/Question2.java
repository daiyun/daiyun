package daiyun.leetcode;

public class Question2 {


  /**
   * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
   * <p>
   * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
   * <p>
   * 示例：
   * <p>
   * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
   * 输出：7 -> 0 -> 8
   * 原因：342 + 465 = 807
   */

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode res = new ListNode(0);

    ListNode pNode = res;
    int p = 0;

    while (l1 != null || l2 != null) {
      int a = 0;
      int b = 0;

      if (l1 != null) {
        a = l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        b = l2.val;
        l2 = l2.next;
      }

      int c = a + b + p;
      p = 0;

      if (c > 9) {
        c = c - 10;
        p = 1;
      }

      ListNode addNode = new ListNode(c);

      pNode.next = addNode;

      pNode = addNode;
    }

    if (p == 1) {
      ListNode addNode = new ListNode(1);
      pNode.next = addNode;
    }

    return res.next;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
