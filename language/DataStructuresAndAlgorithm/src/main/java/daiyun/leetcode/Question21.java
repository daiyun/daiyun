package daiyun.leetcode;

public class Question21 {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  class SolutionB {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode node = new ListNode(0);

      ListNode preNode = node;

      while (l1 != null || l2 != null) {
        if(l1 == null){
          preNode.next = l2;
          break;
        }
        if(l2 == null){
          preNode.next = l1;
          break;
        }

        if(l1.val < l2.val){
          preNode.next = l1;
          l1 = l1.next;
        }else{
          preNode.next = l2;
          l2 = l2.next;
        }
        preNode = preNode.next;
      }

      return node.next;
    }
  }

  class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

      ListNode node = new ListNode(0);

      ListNode preNode = node;
      while (l1 != null || l2 != null) {
        Integer p1 = (l1 != null ? l1.val : null);
        Integer p2 = (l2 != null ? l2.val : null);

        if (p1 != null && p2 != null) {
          if (p1 < p2) {
            ListNode nextNode = new ListNode(p1);
            preNode.next = nextNode;
            preNode = nextNode;
            l1 = l1.next;
          } else {
            ListNode nextNode = new ListNode(p2);
            preNode.next = nextNode;
            preNode = nextNode;
            l2 = l2.next;
          }
        } else if (l1 == null) {
          ListNode nextNode = new ListNode(p2);
          preNode.next = nextNode;
          preNode = nextNode;
          l2 = l2.next;
        } else if (l2 == null) {
          ListNode nextNode = new ListNode(p1);
          preNode.next = nextNode;
          preNode = nextNode;
          l1 = l1.next;
        }
      }

      return node.next;

    }
  }
}
