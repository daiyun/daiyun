package daiyun.leetcode.lcci;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 */
public class Question0202 {

    public static void main(String[] args) {
        Question0202 question = new Question0202();

        Question0202.Solution solution = question.new Solution();

//        "sdfsdsdssdfs"
//        "dssdfs"
//        "sdfsds"
//        27
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int kthToLast(ListNode head, int k) {
            List<Integer> integers = new ArrayList<>();

            while (head != null) {
                integers.add(head.val);
                head = head.next;
            }

            return integers.get(integers.size() - k - 1);
        }
    }
}
