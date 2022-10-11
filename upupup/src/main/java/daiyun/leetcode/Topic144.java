package daiyun.leetcode;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class Topic144 {

    public static void main(String[] args) {

        Topic144 topic1 = new Topic144();

        Solution solution = topic1.new Solution();


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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }

            res.add(root.val);
            res.addAll(preorderTraversal(root.left));
            res.addAll(preorderTraversal(root.right));

            return res;
        }
    }

    class SolutionA {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }

            Stack<TreeNode> stackList = new Stack<>();
            stackList.add(root);

            while (!stackList.empty()) {
                TreeNode pop = stackList.pop();
                res.add(pop.val);

                if (pop.right != null) {
                    stackList.push(pop.right);
                }

                if (pop.left != null) {
                    stackList.push(pop.left);
                }
            }

            return res;
        }
    }

    class SolutionB {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }

            TreeNode p1 = root;
            TreeNode p2 = null;

            while (p1 != null) {
                p2 = p1.left;
                if (p2 != null) {
                    while (p2.right != null && p2.right != p1) {
                        p2 = p2.right;
                    }

                    if (p2.right == null) {
                        res.add(p1.val);
                        p2.right = p1;
                        p1 = p1.left;
                        continue;
                    } else {
                        p2.right = null;
                    }
                } else {
                    res.add(p1.val);
                }

                p1 = p1.right;
            }


            return res;
        }
    }
}
