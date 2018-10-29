package daiyun.leetcode;

import java.util.LinkedList;

public class Question25 {

  public static void main(String[] args) {
    Question25 question25 = new Question25();

    Question25.Solution solution = question25.new Solution();

//    [1,2,3,4,5]
    ListNode node = question25.new ListNode(1);
    ListNode node1 = question25.new ListNode(2);
    ListNode node2 = question25.new ListNode(3);
    ListNode node3 = question25.new ListNode(4);
    ListNode node4 = question25.new ListNode(5);

    node.next = node1;

    solution.reverseKGroup(node, 2);
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

      ListNode cur = new ListNode(0);

      ListNode pNode = cur;
      LinkedList<ListNode> stack = new LinkedList<>();

      while (head != null) {

        ListNode temp = head.next;

        head.next = null;
        stack.push(head);

        head = temp;

        if (stack.size() == k) {
          while (stack.size() > 0) {
            pNode.next = stack.poll();
            pNode = pNode.next;
          }
        }

      }

      while (stack.size() > 0) {
        pNode.next = stack.pollLast();
        pNode = pNode.next;
      }

      return cur.next;
    }
  }

  class SolutionB {
    public ListNode reverseKGroup(ListNode head, int k) {
      int j = 0;
      ListNode curre = head;
      while(j<k){
        if(curre== null)
          return head;
        else{
          curre = curre.next;
          j++;
        }
      }
      curre = reverseKGroup(curre,k);
      //ListNode pre= null;
      //ListNode cur= head;
      while(j>0){
        ListNode las = head.next;
        head.next = curre;
        curre=head;
        head = las;
        j--;
      }
      //head = curre;
      return curre;
    }
  }
}
