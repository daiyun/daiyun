package daiyun.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic257 {

    public static void main(String[] args) {

        Topic257 topic1 = new Topic257();

        Solution solution = topic1.new Solution();



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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            if (root.left == null && root.right == null) {
                res.add(root.val + "");
                return res;
            }

            if (root.left != null) {
                List<String> left = binaryTreePaths(root.left);
                for (String child : left) {
                    res.add(root.val + "->" + child);
                }
            }

            if (root.right != null) {
                List<String> right = binaryTreePaths(root.right);
                for (String child : right) {
                    res.add(root.val + "->" + child);
                }
            }

            return res;
        }
    }

}
