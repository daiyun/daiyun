package daiyun.leetcode;


import java.util.LinkedList;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class Topic101 {

    public static void main(String[] args) {

        Topic101 topic1 = new Topic101();

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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return false;
            }

            if (root.left == null && root.right == null) {
                return true;
            } else if (root.left != null && root.right != null) {

                LinkedList<TreeNode> left = new LinkedList<>();
                left.push(root.left);

                LinkedList<TreeNode> right = new LinkedList<>();
                right.push(root.right);

                while (left.size() > 0 || right.size() > 0) {
                    TreeNode pLeft = left.pop();
                    TreeNode pRight = right.pop();

                    if (pLeft != null && pRight != null) {
                        if (pLeft.val != pRight.val) {
                            return false;
                        }

                        left.push(pLeft.left);
                        left.push(pLeft.right);

                        right.push(pRight.right);
                        right.push(pRight.left);
                    } else if (pLeft == null && pRight == null) {

                    } else {
                        return false;
                    }
                }
                return true;


            }
            return false;
        }
    }

    class SolutionA {
        public boolean isSymmetric(TreeNode root) {

            if (root == null) {
                return false;
            }

            return doSymmetricCheck(root.left, root.right);
        }

        public boolean doSymmetricCheck(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            } else if (left != null && right != null && left.val == right.val) {
                return doSymmetricCheck(left.left, right.right) && doSymmetricCheck(left.right, right.left);
            }
            return false;
        }
    }

}
