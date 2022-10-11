package daiyun.leetcode;

import java.util.LinkedList;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Topic25 {

    public static void main(String[] args) {

        Topic25 topic1 = new Topic25();

        SolutionB solution = topic1.new SolutionB();


        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);

        ListNode node = solution.reverseKGroup(root);

        System.out.println();


    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode[] change = new ListNode[k];
            int i = 0;
            for (; i < k && head != null; i++) {
                change[k - i - 1] = head;
                head = head.next;
            }

            if (i == k) {
                ListNode next = change[0].next;
                for (int j = 0; j < i - 1; j++) {
                    change[j].next = change[j + 1];
                }
                change[k - 1].next = reverseKGroup(next, k);

                return change[0];
            } else {
                return head;
            }

        }
    }

    class SolutionA {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode ans = new ListNode(0);
            ans.next = head;

            ListNode pre = ans;
            LinkedList<ListNode> stack = new LinkedList<>();
            while (head != null) {

                stack.push(head);
                head = head.next;

                if (stack.size() == k) {
                    while (stack.size() > 0) {
                        ListNode item = stack.poll();
                        pre.next = item;
                        pre = item;
                    }
                }
            }

            while (stack.size() > 0) {
                ListNode item = stack.pollLast();
                pre.next = item;
                pre = item;
            }

            return ans.next;
        }
    }

    class SolutionB {
        public ListNode reverseKGroup(ListNode head) {
            ListNode ans = new ListNode(0);
            ListNode p = ans;

            while (head != null) {
                ListNode node1 = head;
                head = head.next;

                if (head != null) {
                    p.next = head;
                    head = head.next;
                    p = p.next;
                }

                p.next = node1;
                p = p.next;
            }

            return ans.next;
        }
    }

}
