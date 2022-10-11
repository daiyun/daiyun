package daiyun.leetcode.lcci;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */
public class Question0208 {

    public static void main(String[] args) {
        Question0208 question = new Question0208();

        Question0208.Solution solution = question.new Solution();

//        "sdfsdsdssdfs"
//        "dssdfs"
//        "sdfsds"
//        27

    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> nodes = new HashSet<>();
            while (head != null) {
                if (nodes.contains(head)) {
                    return head;
                }
                nodes.add(head);
                head = head.next;
            }
            return null;
        }
    }

    public class SolutionA {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }

            ListNode p1 = head;
            ListNode p2 = head;

            while (p2 != null && p2.next != null) {

                p1 = p1.next;
                p2 = p2.next.next;

                if (p1 == p2) {
                    break;
                }
            }

            if (p1 != p2) {
                return null;
            }

            p1 = head;
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }

            return p1;
        }
    }
}
