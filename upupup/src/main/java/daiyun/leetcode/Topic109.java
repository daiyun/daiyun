package daiyun.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic109 {

    public static void main(String[] args) {

        Topic109 topic1 = new Topic109();

        Solution solution = topic1.new Solution();


        System.out.println(System.currentTimeMillis());
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode sortedListToBST(ListNode head) {

            if (head == null) {
                return null;
            }

            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }

            return listToBST(list);
        }

        public TreeNode listToBST(List<Integer> listNodes) {
            if (listNodes == null || listNodes.size() == 0) {
                return null;
            }

            int size = listNodes.size();
            TreeNode root = new TreeNode(listNodes.get(size / 2));

            root.left = listToBST(listNodes.subList(0, size / 2));
            if (size / 2 + 1 < size) {
                root.right = listToBST(listNodes.subList(size / 2 + 1, size));
            }

            return root;
        }
    }
}
