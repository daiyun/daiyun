package daiyun.leetcode;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Topic23 {

    public static void main(String[] args) {

        Topic23 topic1 = new Topic23();

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
        public ListNode mergeKLists(ListNode[] lists) {

            if (lists == null) {
                return null;
            }

            if (lists.length == 1) {
                return lists[0];
            }

            ListNode head = new ListNode(0);

            ListNode p = head;

            while (true) {
                Integer index = null;
                for (int i = 0; i < lists.length; i++) {
                    if (lists[i] == null) {
                        continue;
                    }
                    if (index == null || lists[i].val < lists[index].val) {
                        index = i;
                    }
                }

                if (index == null) {
                    break;
                }

                p.next = lists[index];
                lists[index] = lists[index].next;
                p = p.next;
            }


            return head.next;

        }
    }

}
