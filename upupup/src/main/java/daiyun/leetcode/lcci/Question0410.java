package daiyun.leetcode.lcci;

import java.util.Stack;

/**
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 * <p>
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 * <p>
 * 示例1:
 * <p>
 * 输入：t1 = [1, 2, 3], t2 = [2]
 * 输出：true
 * 示例2:
 * <p>
 * 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 * 输出：false
 * 提示：
 * <p>
 * 树的节点数目范围为[0, 20000]。
 */
public class Question0410 {

    public static void main(String[] args) {
        Question0410 question = new Question0410();

        Question0410.Solution solution = question.new Solution();


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

        boolean flag = solution.checkSubTree(root, new TreeNode(99));

        System.out.println(flag);

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
        public boolean checkSubTree(TreeNode t1, TreeNode t2) {
            if (t2 == null) {
                return true;
            }

            if (t1 == null) {
                return false;
            }

            Stack<TreeNode> t1Travering = new Stack<>();
            TreeNode p = t1;
            while (p != null || t1Travering.size() > 0) {
                while (p != null) {
                    t1Travering.add(p);
                    p = p.left;
                }

                TreeNode outNode = t1Travering.pop();
                if (outNode.val == t2.val) {
                    return doCheckSameTree(outNode, t2);
                }
                p = outNode.right;
            }

            return false;
        }

        public boolean doCheckSameTree(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return true;
            }

            if (t1 == null || t2 == null) {
                return false;
            }

            if (t1.val == t2.val) {
                return doCheckSameTree(t1.left, t2.left) && doCheckSameTree(t1.right, t2.right);
            } else {
                return false;
            }
        }
    }

}
