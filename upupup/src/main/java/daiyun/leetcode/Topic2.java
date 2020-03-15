package daiyun.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头
 */
public class Topic2 {

    public static void main(String[] args) {

        Topic2 topic1 = new Topic2();

        Solution solution = topic1.new Solution();

    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(0);
            ListNode pNode = res;

            int p = 0;
            while (l1 != null || l2 != null) {
                if (l1 != null && l2 != null) {
                    int a = l1.val;
                    int b = l2.val;
                    int c = a + b + p;
                    if (c > 9) {
                        pNode.next = new ListNode(c % 10);
                        p = c / 10;
                    } else {
                        pNode.next = new ListNode(c);
                        p = 0;
                    }
                    l1 = l1.next;
                    l2 = l2.next;
                } else if (l1 != null) {
                    int c = p + l1.val;
                    if (c > 9) {
                        pNode.next = new ListNode(c % 10);
                        p = c / 10;
                    } else {
                        pNode.next = new ListNode(c);
                        p = 0;
                    }
                    l1 = l1.next;
                } else if (l2 != null) {
                    int c = p + l2.val;
                    if (c > 9) {
                        pNode.next = new ListNode(c % 10);
                        p = c / 10;
                    } else {
                        pNode.next = new ListNode(c);
                        p = 0;
                    }
                    l2 = l2.next;
                }
            }
            return res.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
