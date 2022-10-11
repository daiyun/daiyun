package daiyun.leetcode;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 */
public class Topic111 {

    public static void main(String[] args) {

        Topic111 topic1 = new Topic111();

        Solution solution = topic1.new Solution();

        long start = System.currentTimeMillis();

        TreeNode root = new TreeNode(5);

        TreeNode left = new TreeNode(1);

        TreeNode right = new TreeNode(4);

        root.left = left;
        root.right = right;


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
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int height = 1;

            LinkedList<TreeNode> tree = new LinkedList<>();
            tree.add(root);

            while (tree.size() > 0) {

                LinkedList<TreeNode> nextLevel = new LinkedList<>();
                for (TreeNode node : tree) {
                    if (node.left == null && node.right == null) {
                        return height;
                    }
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                }

                tree = nextLevel;
                height++;
            }

            return height;
        }
    }
}
