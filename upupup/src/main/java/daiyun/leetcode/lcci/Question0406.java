package daiyun.leetcode.lcci;

import java.util.Stack;

/**
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3], p = 1
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * <p>
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * <p>
 * 输出: null
 */
public class Question0406 {

    public static void main(String[] args) {
        Question0406 question = new Question0406();

        Question0406.Solution solution = question.new Solution();


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
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null || p == null) {
                return null;
            }

            Stack<TreeNode> stack = new Stack<>();

            boolean findFlag = false;
            while (root != null || stack.size() > 0) {
                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }

                TreeNode outNode = stack.pop();

                if (findFlag) {
                    return outNode;
                }

                if (outNode.val == p.val) {
                    findFlag = true;
                }
                root = outNode.right;
            }

            return null;
        }
    }

}
