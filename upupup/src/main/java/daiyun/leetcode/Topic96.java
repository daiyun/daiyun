package daiyun.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class Topic96 {

    public static void main(String[] args) {

        Topic96 topic1 = new Topic96();

        long start = System.currentTimeMillis();


        System.out.println(System.currentTimeMillis() - start);
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
        public int numTrees(int n) {
            return generateTrees(n).size();
        }

        public List<TreeNode> generateTrees(int n) {
            if (n < 1) {
                return new ArrayList<>();
            }

            List<TreeNode> res = new ArrayList<>();
            if (n == 1) {
                TreeNode currentNode = new TreeNode(n);
                res.add(currentNode);
                return res;
            }

            res = generateTrees(n - 1);

            List<TreeNode> list = new ArrayList<>();
            for (TreeNode root : res) {
                TreeNode currentNode = new TreeNode(n);
                currentNode.left = copyTree(root);
                list.add(currentNode);

                TreeNode p = root;
                int i = 0;
                while (p != null) {
                    if (p.right == null || p.right.val < n) {

                        TreeNode newTree = copyTree(root);

                        int k = i;
                        TreeNode temp = newTree;
                        while (k-- > 0) {
                            temp = temp.right;
                        }

                        TreeNode a = temp.right;
                        temp.right = new TreeNode(n);
                        temp.right.left = a;

                        list.add(newTree);
                    }
                    p = p.right;
                    i++;
                }
            }

            return list;
        }

        public TreeNode copyTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode newRoot = new TreeNode(root.val);

            if (root.left != null) {
                newRoot.left = copyTree(root.left);
            }

            if (root.right != null) {
                newRoot.right = copyTree(root.right);
            }

            return newRoot;
        }
    }

}
