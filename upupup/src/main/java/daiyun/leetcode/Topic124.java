package daiyun.leetcode;


/**
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 */
public class Topic124 {

    public static void main(String[] args) {

        Topic124 topic1 = new Topic124();

        Solution solution = topic1.new Solution();

        long start = System.currentTimeMillis();

        int res = solution.maxPathSum(null);

        System.out.println(res);

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

        public Integer maxRes = null;

        public int maxPathSum(TreeNode root) {
            maxChildPathSum(root);
            return maxRes;
        }

        public Integer maxChildPathSum(TreeNode root) {

            if (root == null) {
                return 0;
            }
            if (maxRes == null || root.val > maxRes) {
                maxRes = root.val;
            }

            Integer leftMaxPath = maxChildPathSum(root.left);
            Integer rightMaxPath = maxChildPathSum(root.right);

            if (leftMaxPath > 0 && rightMaxPath > 0) {
                if (leftMaxPath + rightMaxPath + root.val > maxRes) {
                    maxRes = leftMaxPath + rightMaxPath + root.val;
                }
                int curMax = leftMaxPath > rightMaxPath ? leftMaxPath : rightMaxPath;
                if (curMax + root.val > root.val) {
                    return curMax + root.val;
                } else {
                    return root.val;
                }
            } else if (leftMaxPath > 0) {
                if (leftMaxPath + root.val > maxRes) {
                    maxRes = leftMaxPath + root.val;
                }
                if (leftMaxPath + root.val > root.val) {
                    return leftMaxPath + root.val;
                } else {
                    return root.val;
                }
            } else if (rightMaxPath > 0) {
                if (rightMaxPath + root.val > maxRes) {
                    maxRes = rightMaxPath + root.val;
                }
                if (rightMaxPath + root.val > root.val) {
                    return rightMaxPath + root.val;
                } else {
                    return root.val;
                }
            }
            return root.val;

        }
    }
}
