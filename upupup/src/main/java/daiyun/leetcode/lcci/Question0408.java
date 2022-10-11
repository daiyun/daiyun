package daiyun.leetcode.lcci;

/**
 * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。
 * 不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 * <p>
 * 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * 3
 * / \
 * 5   1
 * / \ / \
 * 6  2 0  8
 * / \
 * 7   4
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class Question0408 {

    public static void main(String[] args) {
        Question0408 question = new Question0408();

        Question0408.Solution solution = question.new Solution();


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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (root == null) {
                return root;
            }

            if (root.val == p.val || root.val == q.val) {
                if (root.val == p.val) {
                    if (isContainNode(root.left, q) || isContainNode(root.right, q)) {
                        return root;
                    }
                }
                if (root.val == q.val) {
                    if (isContainNode(root.left, p) || isContainNode(root.right, p)) {
                        return root;
                    }
                }
            } else {
                boolean leftP = isContainNode(root.left, p);
                boolean leftQ = false;
                if (!leftP) {
                    leftQ = isContainNode(root.left, q);
                }

                boolean rightQ = isContainNode(root.right, q);
                boolean rightP = false;
                if (!rightQ) {
                    rightP = isContainNode(root.right, p);
                }

                if ((leftP || rightP) && (rightQ || leftQ)) {
                    return root;
                }
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left == null) {
                left = lowestCommonAncestor(root.right, p, q);
            }
            return left;
        }

        public boolean isContainNode(TreeNode root, TreeNode p) {
            if (root == null) {
                return false;
            }
            if (root.val == p.val) {
                return true;
            }

            return isContainNode(root.left, p) || isContainNode(root.right, p);
        }
    }

}
