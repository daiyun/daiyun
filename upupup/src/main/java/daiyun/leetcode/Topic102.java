package daiyun.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class Topic102 {

    public static void main(String[] args) {

        Topic102 topic1 = new Topic102();

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
        public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> res = new ArrayList<>();

            List<TreeNode> curLebel = new ArrayList<>();

            if (root == null) {
                return res;
            }

            curLebel.add(root);

            while (curLebel.size() > 0) {
                List<TreeNode> nextLevel = new ArrayList<>();
                List<Integer> currentVal = new ArrayList<>();

                for (TreeNode node : curLebel) {
                    currentVal.add(node.val);
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                }
                res.add(currentVal);
                curLebel = nextLevel;
            }

            return res;
        }
    }

}
