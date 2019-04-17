package daiyun.tree;

public class BinSearchTree {


    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<Integer>(1);
        for (int i = 2; i < 10; i++) {
            root = insert(root, new <Integer>TreeNode(i));
        }

        TreeRecursion.midRecuresion(root);
    }

    public static TreeNode insert(TreeNode root, TreeNode newNode) {

        if (root == null) {
            return newNode;
        }

        if (root.element.compareTo(newNode.element) < 0) {
            root.right = insert(root.right, newNode);
        } else if (root.element.compareTo(newNode.element) > 0) {
            root.left = insert(root.left, newNode);
        }
        return root;
    }

    public static TreeNode remove(TreeNode root, TreeNode node) {
        if (root == null) {
            return null;
        }

        int compare = root.element.compareTo(node.element);

        if (compare > 0) {
            root.left = remove(root.left, node);
        } else if (compare < 0) {
            root.right = remove(root.right, node);
        } else if (root.left != null && root.right != null) {
            root.element = findMax(root.left).element;
            root.left = remove(root.left, root);
        } else {
            root = root.left == null ? root.right : root.left;
        }
        return root;

    }

    private static TreeNode findMax(TreeNode left) {
        if (left == null) {
            return null;
        }
        while (left.right != null) {
            left = left.right;
        }
        return left;
    }


    public static TreeNode insertT(TreeNode root, TreeNode node) {

        if (root != null) {
            if (node != null) {
                if (root.element.compareTo(node.element) > 0) {
                    TreeNode left = insert(root.left, node);
                    root.left = left;
                } else if (root.element.compareTo(node.element) < 0) {
                    TreeNode right = insert(root.right, node);
                    root.right = right;
                }
            }

            return root;
        } else {
            return node;
        }
    }

    public static TreeNode find(TreeNode root, TreeNode node) {
        if (root == null) {
            return null;
        }
        if (root.element.compareTo(node.element) > 0) {
            return find(root.left, node);
        } else if (root.element.compareTo(node.element) < 0) {
            return find(root.right, node);
        } else {
            return root;
        }
    }

    public static TreeNode delete(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return null;
        }

        if (root.element.compareTo(node.element) == 0) {
            if (root.left != null && root.right != null) {
                TreeNode min = findMinT(root.right);
                root.element = min.element;
                delete(root.right, min);

            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                return null;
            }
        } else if (root.element.compareTo(node.element) > 0) {
            root.left = delete(root.left, node);
        } else {
            root.right = delete(root.right, node);
        }
        return root;

    }

    public static TreeNode findMinT(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                return root;
            }
            root = root.left;
        }
        return null;
    }


}
