package daiyun.leetcode.lcci;

/**
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 * 提示：
 * <p>
 * 节点总数 <= 10000
 */
public class Question0412 {

    public static void main(String[] args) {
        Question0412 question = new Question0412();

        Question0412.Solution solution = question.new Solution();


        TreeNode root12 = new TreeNode(12);
        TreeNode root9 = new TreeNode(9);
        TreeNode root3 = new TreeNode(3);
        TreeNode root2 = new TreeNode(2);


        TreeNode root4 = new TreeNode(4);
        root4.left = root2;
        root4.right = root3;

        TreeNode root11 = new TreeNode(11);
        root11.left = root9;
        root11.right = root12;

        TreeNode root = new TreeNode(8);
        root.left = root4;
        root.right = root11;



    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    class Solution {
        public int pathSum(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }

            int res = rootPathSum(root, sum);

            res += pathSum(root.left, sum);
            res += pathSum(root.right, sum);

            return res;
        }

        public int rootPathSum(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }

            int res = 0;
            if (root.val == sum) {
                res =  1;
            }

            int need = sum - root.val;

            res += rootPathSum(root.left, need);
            res += rootPathSum(root.right, need);

            return res;
        }
    }

}
