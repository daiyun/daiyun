package daiyun.leetcode;


import java.util.Arrays;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Topic108 {

    public static void main(String[] args) {

        Topic108 topic1 = new Topic108();

        SolutionA solution = topic1.new SolutionA();

        long start = System.currentTimeMillis();

        TreeNode root = new TreeNode(5);

        TreeNode left = new TreeNode(1);

        TreeNode right = new TreeNode(4);

        root.left = left;
        root.right = right;

        TreeNode root1 = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});


        System.out.println(System.currentTimeMillis() - start);
    }


    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }

            int len = nums.length;
            int mid = len / 2;

            TreeNode root = new TreeNode(nums[mid]);

            if (mid > 0) {
                root.left = sortedArrayToBST(Arrays.copyOf(nums, mid));
            }


            if (mid < len - 1) {
                root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, len));
            }


            return root;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class SolutionA {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }

            int length = nums.length;

            int mid = length / 2;

            TreeNode node = new TreeNode(nums[mid]);

            if (mid > 0) {
                node.left = sortedArrayToBST(Arrays.copyOf(nums, mid));
            }

            if (mid < length - 1) {
                node.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, length));
            }

            return node;
        }
    }
}
