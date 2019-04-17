package daiyun.tree;

import java.util.LinkedList;

public class TreeTraversing {

    public static void main(String[] args) {

    }

    /**
     * 先序遍历
     */
    public static void preTravesing(TreeNode root) {
        // 递归方式
        /*if (root != null) {
            System.out.println(root.element);
            preTravesing(root.left);
            preTravesing(root.right);
        }*/

        // 使用栈替换递归
        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.push(root);

        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            System.out.println(node.element);
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void midTravesing(TreeNode root) {
        /**
         * 递归遍历
         */
        /*if (root != null) {
            midTravesing(root.left);
            System.out.println(root.element);
            midTravesing(root.right);
        }*/

       /* LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (stack.size() > 0) {
            TreeNode node = stack.peek();
//            if(node.right != null){
//                stack.push(node.right);
//            }
            if (node.left != null) {
                stack.push(node.left);
                node.left = null;
            } else {
                TreeNode pNode = stack.pop();
                System.out.println(pNode.element);

                if (pNode.right != null) {
                    stack.push(pNode.right);
                }
            }

        }*/

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;

        while (p != null || stack.size() > 0) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            if (stack.size() > 0) {
                TreeNode node = stack.pop();
                System.out.println(node.element);
                p = node.right;
            }

        }
    }

    public static void lastTraversing(TreeNode root) {
//        if(root != null){
//            lastTraversing(root.left);
//            lastTraversing(root.right);
//            System.out.println(root.element);
//        }

        LinkedList<TreeNode> stack = new LinkedList<>();


        TreeNode p = root;

        while (p != null || stack.size() > 0) {
            while (p != null) {
                stack.push(p);
                if (p.left != null) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }

            if (stack.size() > 0) {
                p = stack.pop();
                System.out.println(p.element);
            }

            while (stack.size() > 0 && stack.peek().right == p) {
                p = stack.pop();
                System.out.println(p.element);
            }

            if (stack.size() > 0) {
                p = stack.peek().right;
            } else {
                p = null;
            }

        }

    }

    public static void levelTraversing(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (queue.size() > 0) {
            LinkedList<TreeNode> nextLevel = new LinkedList<>();

            for (TreeNode node : queue) {
                System.out.println(node.element);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            queue.clear();
            queue.addAll(nextLevel);
        }
    }
}
