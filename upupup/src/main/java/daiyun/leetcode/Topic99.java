package daiyun.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,null,null,2]
 * <p>
 *    1
 *   /
 *  3
 *   \
 *    2
 * <p>
 * 输出: [3,1,null,null,2]
 * <p>
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 * <p>
 * 输入: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 *    /
 *   2
 * <p>
 * 输出: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 *    /
 *  3
 * 进阶:
 * <p>
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic99 {

    public static void main(String[] args) {

        Topic99 topic1 = new Topic99();

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
        public void recoverTree(TreeNode root) {
            if (root == null) {
                return;
            }

            TreeNode p = root;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            TreeNode temp = null;
            TreeNode tempNext = null;

            while (p != null || stack.size() > 0) {
                while (p != null) {
                    stack.add(p);
                    p = p.left;
                }
                TreeNode out = stack.pop();
                if (pre != null) {
                    if (out.val < pre.val) {
                        if (temp == null) {
                            temp = pre;
                            tempNext = out;
                        } else {
                            int a = temp.val;
                            temp.val = out.val;
                            out.val = a;
                            return;
                        }
                    } else {
                        if (temp != null) {
                            if (out.val > temp.val && out.val > tempNext.val) {
                                int a = temp.val;
                                temp.val = tempNext.val;
                                tempNext.val = a;
                                return;
                            }
                        }
                    }
                }
                pre = out;
                p = out.right;
            }

            if (temp != null) {
                int a = temp.val;
                temp.val = tempNext.val;
                tempNext.val = a;
            }
        }
    }

}
