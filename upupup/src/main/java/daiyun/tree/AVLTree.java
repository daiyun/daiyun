package daiyun.tree;

public class AVLTree {

    public static void main(String[] args) {

    }

    public TreeNode insert(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (root.element.compareTo(node.element) > 0) {
            root.left = insert(root.left, node);
        } else if (root.element.compareTo(node.element) < 0) {
            root.right = insert(root.right, node);
        } else {

        }

        return balance(root);
    }

    public TreeNode delete(TreeNode root, TreeNode node) {
        if (root == null) {
            return null;
        }

        if (root.element.compareTo(node.element) == 0) {
            root.element = findMax(root.left).element;
            root.left = delete(root.left, root);
        } else if (root.element.compareTo(node.element) > 0) {
            root.left = delete(root.left, node);
        } else if (root.element.compareTo(node.element) < 0) {
            root.right = delete(root.right, node);
        }

        return balance(root);
    }

    public TreeNode findMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public TreeNode balance(TreeNode root) {
        if (root == null) {
            return null;
        }

        if ((hegiht(root.left) - hegiht(root.right)) > 1) {
            if (hegiht(root.left.left) >= hegiht(root.left.right)) {
                root = leftRotate(root);
            } else {
                root = leftDoubleRoate(root);
            }
        } else if ((hegiht(root.right) - hegiht(root.left)) > 1) {
            if (hegiht(root.right.right) > hegiht(root.right.left)) {
                root = rightRotate(root);
            } else {
                root = rightDoubleRotate(root);
            }
        }

        int maxHegiht = hegiht(root.left) > hegiht(root.right) ? hegiht(root.left) : hegiht(root.right);
        root.height = maxHegiht + 1;
        return root;
    }

    private int hegiht(TreeNode node) {
        return node == null ? -1 : node.height;
    }

    private TreeNode rightRotate(TreeNode right) {

        TreeNode rightNode = right.right;
        right.right = rightNode.left;
        rightNode.left = right;

        right.height = hegiht(right.left) > hegiht(right.right) ? hegiht(right.left) : hegiht(right.right) + 1;
        rightNode.height = hegiht(rightNode.left) > hegiht(rightNode.right) ? hegiht(rightNode.left) : hegiht(rightNode.right) + 1;

        return rightNode;
    }

    private TreeNode leftRotate(TreeNode left) {

        TreeNode leftNode = left.left;
        left.left = leftNode.right;
        leftNode.right = left;

        left.height = hegiht(left.left) > hegiht(left.right) ? hegiht(left.left) : hegiht(left.right) + 1;
        leftNode.height = hegiht(leftNode.left) > hegiht(leftNode.right) ? hegiht(leftNode.left) : hegiht(leftNode.right) + 1;
        return leftNode;
    }

    private TreeNode rightDoubleRotate(TreeNode root) {
        root.right = leftRotate(root.right);
        root = rightRotate(root);
        return root;
    }

    private TreeNode leftDoubleRoate(TreeNode node) {
        node.left = rightRotate(node.left);
        node = leftRotate(node);
        return node;
    }

}
