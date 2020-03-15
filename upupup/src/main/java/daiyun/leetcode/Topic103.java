package daiyun.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Topic103 {

    public static void main(String[] args) {

        Topic103 topic1 = new Topic103();

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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();

            List<TreeNode> curLebel = new ArrayList<>();

            if (root == null) {
                return res;
            }

            curLebel.add(root);

            int flag = 1;
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

                if (flag == 1) {
                    res.add(currentVal);
                } else {
                    ArrayList temp = new ArrayList();
                    for (int i = currentVal.size() - 1; i >= 0; i--) {
                        temp.add(currentVal.get(i));
                    }
                    res.add(temp);
                }

                curLebel = nextLevel;
                flag = flag == 0 ? 1 : 0;
            }

            return res;
        }
    }

    class SolutionA {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();

            LinkedList<TreeNode> curLebel = new LinkedList<>();

            if (root == null) {
                return res;
            }

            curLebel.push(root);

            int flag = 1;
            while (curLebel.size() > 0) {
                LinkedList<TreeNode> nextLevel = new LinkedList<>();
                List<Integer> currentVal = new ArrayList<>();

                for (TreeNode node : curLebel) {
                    currentVal.add(node.val);

                    if (flag == 1) {
                        if (node.left != null) {
                            nextLevel.push(node.left);
                        }
                        if (node.right != null) {
                            nextLevel.push(node.right);
                        }
                    } else {
                        if (node.right != null) {
                            nextLevel.push(node.right);
                        }
                        if (node.left != null) {
                            nextLevel.push(node.left);
                        }
                    }
                }

                res.add(currentVal);
                curLebel = nextLevel;
                flag = flag == 0 ? 1 : 0;
            }

            return res;
        }
    }

}
