package daiyun.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 */
public class Topic94 {

    public static void main(String[] args) {

        Topic94 topic1 = new Topic94();

        SolutionA solution = topic1.new SolutionA();

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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            res.addAll(inorderTraversal(root.left));

            res.add(root.val);

            res.addAll(inorderTraversal(root.right));

            return res;

        }
    }

    class SolutionA {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();


            LinkedList<TreeNode> stack = new LinkedList<>();

            TreeNode p = root;

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

            return res;
        }
    }

}
