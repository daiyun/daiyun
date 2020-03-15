package daiyun.leetcode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Topic24 {

    public static void main(String[] args) {

        Topic24 topic1 = new Topic24();

        Solution solution = topic1.new Solution();


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    class Solution {
        public ListNode swapPairs(ListNode head) {

            if (head == null) {
                return null;
            }

            if (head.next == null) {
                return head;
            }

            ListNode ans = null;
            ans = head.next;

            head.next = swapPairs(ans.next);
            ans.next = head;

            return ans;
        }
    }

    class SolutionA {
        public ListNode swapPairs(ListNode head) {
            ListNode ans = new ListNode(0);
            ans.next = head;

            ListNode temp = ans;
            while (temp.next != null && temp.next.next != null) {

                ListNode next = temp.next;
                ListNode nextnext = temp.next.next;

                temp.next = nextnext;
                next.next = nextnext.next;
                nextnext.next = next;

                temp = next;
            }


            return ans.next;
        }
    }

}
