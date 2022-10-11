package daiyun.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic107 {

    public static void main(String[] args) {

        Topic107 topic1 = new Topic107();


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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if(root == null){
                return new ArrayList<>();
            }

            LinkedList<List<Integer>> res = new LinkedList<>();

            List<TreeNode> pre = new ArrayList<>();
            pre.add(root);

            while(pre.size() > 0){
                List<Integer> current = new ArrayList<>();
                List<TreeNode> next = new ArrayList<>();
                for (TreeNode node : pre) {
                    current.add(node.val);
                    if(node.left != null){
                        next.add(node.left);
                    }
                    if(node.right != null){
                        next.add(node.right);
                    }
                }
                pre = next;
                res.push(current);
            }

            return res;
        }
    }
}
