package daiyun.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Topic98 {

    public static void main(String[] args) {

        Topic98 topic1 = new Topic98();

        SolutionA solution = topic1.new SolutionA();

        long start = System.currentTimeMillis();

        TreeNode root = new TreeNode(5);

        TreeNode left = new TreeNode(1);

        TreeNode right = new TreeNode(4);

        root.left = left;
        root.right = right;

        solution.isValidBST(root);

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
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            if (root.left == null && root.right == null) {
                return true;
            }

            if (root.left == null && root.right.val > root.val) {
                return isValidBST(root.right);
            } else if (root.right == null && root.left.val < root.val) {
                return isValidBST(root.left);
            } else if (root.left != null && root.right != null &&
                    root.left.val < root.val && root.right.val > root.val) {

                return isValidBST(root.left) && isValidBST(root.right);
            }

            return false;
        }
    }

    class SolutionA {
        public boolean isValidBST(TreeNode root) {

            LinkedList<TreeNode> stack = new LinkedList<>();

            TreeNode p = root;

            List<Integer> res = new ArrayList<>();

            while (p != null || stack.size() > 0) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }

                if (stack.size() > 0) {
                    p = stack.pop();
                    res.add(p.val);
                    p = p.right;
                }
            }

            for (int i = 0; i < res.size() - 1; i++) {
                if (res.get(i) >= res.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }
    }

}
