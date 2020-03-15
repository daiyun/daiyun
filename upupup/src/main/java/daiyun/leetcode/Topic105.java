package daiyun.leetcode;


/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Topic105 {

    public static void main(String[] args) {

        Topic105 topic1 = new Topic105();

        Solution solution = topic1.new Solution();

        long start = System.currentTimeMillis();

        TreeNode root = new TreeNode(5);

        TreeNode left = new TreeNode(1);

        TreeNode right = new TreeNode(4);

        root.left = left;
        root.right = right;

        solution.buildTree(new int[]{1,2}, new int[]{1,2});


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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null) {
                return null;
            }
            if (preorder.length == 0) {
                return null;
            }
            if (preorder.length != inorder.length) {
                return null;
            }

            int rootVal = preorder[0];
            int i = 0;
            while (i < inorder.length && inorder[i] != rootVal) {
                i++;
            }
            TreeNode root = new TreeNode(rootVal);

            if (i < inorder.length) {
                int[] leftPre = new int[i];
                int[] leftIn = new int[i];
                System.arraycopy(preorder, 1, leftPre, 0, i);
                System.arraycopy(inorder, 0, leftIn, 0, i);
                root.left = buildTree(leftPre, leftIn);

                int[] rightPre = new int[inorder.length - i - 1];
                int[] rightIn = new int[inorder.length - i - 1];
                System.arraycopy(preorder, i + 1, rightPre, 0, rightPre.length);
                System.arraycopy(inorder, i + 1, rightIn, 0, rightIn.length);
                root.right = buildTree(rightPre, rightIn);
            }

            return root;
        }
    }
}
