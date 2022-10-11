package daiyun.leetcode.lcci;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * <p>
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * <p>
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 * <p>
 * 示例：
 * <p>
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 */
public class Question0205 {

    public static void main(String[] args) {
        Question0205 question = new Question0205();

        Question0205.Solution solution = question.new Solution();

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode res = new ListNode(0);
            ListNode p = res;

            int pre = 0;
            while (l1 != null || l2 != null) {

                int a = 0;
                if (l1 != null) {
                    a = l1.val;
                    l1 = l1.next;
                }

                int b = 0;
                if (l2 != null) {
                    b = l2.val;
                    l2 = l2.next;
                }

                int addRes = a + b + pre;

                pre = addRes / 10;
                p.next = new ListNode(addRes % 10);
                p = p.next;
            }
            if (pre > 0) {
                p.next = new ListNode(pre);
            }

            return res.next;
        }
    }
}
