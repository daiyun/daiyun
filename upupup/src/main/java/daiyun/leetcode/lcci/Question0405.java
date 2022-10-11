package daiyun.leetcode.lcci;

/**
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * <p>
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class Question0405 {

    public static void main(String[] args) {
        Question0405 question = new Question0405();

        Question0405.Solution solution = question.new Solution();


    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            if (!isValidBST(root.left) || !isValidBST(root.right)) {
                return false;
            }

            TreeNode leftMax = getMax(root.left);
            TreeNode rightMin = getMin(root.right);

            if (leftMax != null && leftMax.val >= root.val) {
                return false;
            }

            if (rightMin != null && rightMin.val <= root.val) {
                return false;
            }

            return true;
        }

        private TreeNode getMin(TreeNode node) {
            TreeNode min = null;
            while (node != null) {
                min = node;
                node = node.left;
            }
            return min;
        }


        private TreeNode getMax(TreeNode node) {
            TreeNode max = null;
            while (node != null) {
                max = node;
                node = node.right;
            }
            return max;
        }

    }

}
