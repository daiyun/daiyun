package daiyun.leetcode.lcci;

/**
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <p>
 * 示例 3：
 * <p>
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null 。
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class Question0207 {

    public static void main(String[] args) {
        Question0207 question = new Question0207();

        Question0207.Solution solution = question.new Solution();

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

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            if (headA == null || headB == null) {
                return null;
            }

            while (headA != null) {
                ListNode p = headB;
                while (p != null) {
                    if (headA == p) {
                        return headA;
                    }
                    p = p.next;
                }
                headA = headA.next;
            }

            return null;
        }
    }

    public class SolutionA {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            if (headA == null || headB == null) {
                return null;
            }

            ListNode a = headA;
            ListNode b = headB;

            while (a != b) {
                if (a == null) {
                    a = headB;
                } else {
                    a = a.next;
                }
                if (b == null) {
                    b = headA;
                } else {
                    b = b.next;
                }
            }

            return a;
        }
    }
}
