package daiyun.leetcode;

public class Question23 {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0)
        return null;
      return mergeLists(0, lists.length - 1, lists);
    }

    private ListNode mergeLists(int low, int high, ListNode[] lists) {
      if (low >= high)
        return lists[low];
      int medium = (low + high) / 2;
      ListNode h = new ListNode(-1);
      ListNode cur = h;
      ListNode l1 = mergeLists(low, medium, lists);
      ListNode l2 = mergeLists(medium + 1, high, lists);
      while (l1 != null && l2 != null) {
        if (l1.val > l2.val) {
          h.next = l2;
          l2 = l2.next;
        } else {
          h.next = l1;
          l1 = l1.next;
        }
        h = h.next;
      }
      if (l1 != null)
        h.next = l1;
      if (l2 != null)
        h.next = l2;
      return cur.next;
    }
  }

  class SolutionB {
    public ListNode mergeKLists(ListNode[] lists) {

      if (lists == null) {
        return null;
      }

      if (lists.length == 1) {
        return lists[0];
      }

      ListNode head = new ListNode(0);
      ListNode preNode = head;
      while (true) {
        ListNode min = null;
        int index = 0;
        for (int i = 0; i < lists.length; i++) {
          if (lists[i] != null) {
            if (min == null || lists[i].val < min.val) {
              min = lists[i];
              index = i;
            }
          }
        }

        if (min == null) {
          break;
        } else {
          lists[index] = lists[index].next;

          preNode.next = min;
          preNode = min;

        }
      }

      return head.next;

    }
  }
}
