package daiyun.leetcode.lcci;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 */
public class Question0206 {

    public static void main(String[] args) {
        Question0206 question = new Question0206();

        Question0206.Solution solution = question.new Solution();

//        "sdfsdsdssdfs"
//        "dssdfs"
//        "sdfsds"
//        27


        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);

        node5.next = node6;
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        node.next = node1;

    }


    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }

            int s = 0;
            int end = list.size() - 1;
            while (s < end) {
                if (!list.get(s).equals(list.get(end))) {
                    return false;
                }
                s++;
                end--;
            }

            return true;
        }
    }
}
