package daiyun.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class Topic19 {

    public static void main(String[] args) {

        Topic19 topic1 = new Topic19();

        SolutionB solution = topic1.new SolutionB();

        ListNode head = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);

        p4.next = p5;
        p3.next = p4;
        p2.next = p3;
        head.next = p2;
        solution.removeNthFromEnd(head, 3);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            LinkedList<ListNode> stack = new LinkedList<>();

            ListNode p = head;
            while (p != null) {
                stack.push(p);
                p = p.next;
            }

            int index = 1;
            while (stack.size() > 0) {
                if (index == n) {
                    ListNode next = stack.pop().next;
                    if (stack.size() == 0) {
                        head = next;
                    } else {
                        stack.pop().next = next;
                    }
                    break;
                }
                stack.pop();
                index++;
            }
            return head;
        }
    }

    class SolutionB {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            List<ListNode> arrayList = new ArrayList<>();

            int size = 0;
            ListNode p = head;
            while (p != null) {
                arrayList.add(p);
                size++;
                p = p.next;
            }

            int lastIndex = size - n;
            ListNode delNode = arrayList.get(lastIndex);

            if (lastIndex == 0) {
                head =  delNode.next;
            } else {
                arrayList.get(lastIndex - 1).next = delNode.next;
            }


            return head;
        }
    }

}
