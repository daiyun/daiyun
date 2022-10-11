package daiyun.leetcode.lcci;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 * <p>
 * 如果不得使用临时缓冲区，该怎么解决？
 */
public class Question0201 {

    public static void main(String[] args) {
        Question0201 question = new Question0201();

        Question0201.Solution solution = question.new Solution();

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
        public ListNode removeDuplicateNodes(ListNode head) {
            Set<Integer> integers = new HashSet<>();

            ListNode p = head;
            ListNode preP = p;

            while (p != null) {
                if (integers.contains(p.val)) {
                    preP.next = p.next;
                    p = p.next;
                } else {
                    integers.add(p.val);
                    preP = p;
                    p = p.next;
                }
            }

            return head;
        }
    }
}
