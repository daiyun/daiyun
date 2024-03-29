package daiyun.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * <p>
 * 输入: [3,4,5,1,3,null,1]
 * <p>
 *      3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic337 {

    public static void main(String[] args) {

        Topic337 topic1 = new Topic337();

        Solution solution = topic1.new Solution();

        TreeNode root = new TreeNode(1);
        TreeNode one = new TreeNode(2);

        root.left = one;

        solution.rob(root);

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
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                return root.val;
            }

            int childRob = rob(root.left) + rob(root.right);

            int rootRob = root.val;
            if (root.left != null) {
                rootRob += rob(root.left.left);
                rootRob += rob(root.left.right);
            }

            if (root.right != null) {
                rootRob += rob(root.right.left);
                rootRob += rob(root.right.right);
            }

            return Math.max(childRob, rootRob);
        }
    }

    class SolutionA {
        public int rob(TreeNode root) {
            int[] res = robAll(root);
            return Math.max(res[0], res[1]);
        }

        public int[] robAll(TreeNode root) {
            if (root == null) {
                return new int[2];
            }

            int[] res = new int[2];

            int[] resLeft = robAll(root.left);
            int[] resRight = robAll(root.right);

            res[0] = root.val + resLeft[1] + resRight[1];
            res[1] = Math.max(resLeft[0], resLeft[1]) + Math.max(resRight[0], resRight[1]);

            return res;
        }
    }
}
