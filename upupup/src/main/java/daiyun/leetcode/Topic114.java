package daiyun.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 *  
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class Topic114 {

    public static void main(String[] args) {

        Topic114 topic1 = new Topic114();


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
        public void flatten(TreeNode root) {

            Stack<TreeNode> stack = new Stack<>();

            TreeNode p = root;
            TreeNode p1 = new TreeNode(0);
            TreeNode p0 = p1;
            while (p != null || stack.size() > 0) {
                while (p != null) {

                    p1.right = p;
                    p1 = p1.right;

                    if (p.right != null) {
                        stack.push(p.right);
                    }
                    TreeNode temp = p.left;
                    p.left = null;

                    p = temp;
                }

                if (stack.size() > 0) {
                    p = stack.pop();
                }
            }

            root = p0.right;
        }
    }
}
