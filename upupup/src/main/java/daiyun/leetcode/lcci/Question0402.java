package daiyun.leetcode.lcci;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Question0402 {

    public static void main(String[] args) {
        Question0402 question = new Question0402();

        Question0402.Solution solution = question.new Solution();


    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            if (tree == null) {
                return null;
            }

            List<ListNode> res = new ArrayList<>();

            List<TreeNode> currentLevel = new ArrayList<>();
            currentLevel.add(tree);

            while (currentLevel.size() > 0) {
                List<TreeNode> nextLevel = new ArrayList<>();
                ListNode listNode = new ListNode(0);
                ListNode p = listNode;
                for (TreeNode node : currentLevel) {
                    p.next = new ListNode(node.val);
                    p = p.next;
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                }

                res.add(listNode.next);
                currentLevel = nextLevel;
            }

            return res.toArray(new ListNode[0]);
        }
    }

}
