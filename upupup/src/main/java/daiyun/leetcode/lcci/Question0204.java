package daiyun.leetcode.lcci;

/**
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 */
public class Question0204 {

    public static void main(String[] args) {
        Question0204 question = new Question0204();

        Question0204.Solution solution = question.new Solution();

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

        solution.partition(node, 5);
    }


    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null) {
                return head;
            }

            ListNode leftP = new ListNode(0);
            leftP.next = head;
            ListNode res = leftP;

            ListNode p = head;
            ListNode preP = head;

            while (p != null) {
                if (p != head && p.val < x) {
                    ListNode temp = p;

                    preP.next = temp.next;
                    p = temp.next;

                    ListNode ltemp = leftP.next;
                    leftP.next = temp;
                    temp.next = ltemp;

                    leftP = temp;
                } else {
                    preP = p;
                    p = p.next;
                }
            }

            return res.next;
        }
    }
}
