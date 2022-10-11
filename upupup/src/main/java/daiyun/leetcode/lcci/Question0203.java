package daiyun.leetcode.lcci;

/**
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 */
public class Question0203 {

    public static void main(String[] args) {
        Question0203 question = new Question0203();

        Question0203.Solution solution = question.new Solution();

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
        public void deleteNode(ListNode node) {
            if (node == null || node.next == null) {
                return;
            }

            ListNode p = node.next;
            node.val = p.val;
            node.next = p.next;
        }
    }
}
