package daiyun.tree;

import java.util.Stack;

public class AVLTreeOptions {

    public static void main(String[] args) {

    }

    public static Node insert(Node root, Node node) {
        if (root == null) {
            return node;
        }
        if (root.value.compareTo(node.value) > 0) {
            root.left = insert(node.left, node);
        } else if (root.value.compareTo(node.value) < 0) {
            root.right = insert(node.right, node);
        }

        return blance(root);
    }


    public static Node delete(Node root, Node node) {
        if (root == null) {
            return null;
        }
        if (root.value.compareTo(node.value) == 0) {
            if (root.right != null) {
                root.value = findMin(node.right).value;
                root.right = delete(root.right, root);
            } else if (root.left != null) {
                root.value = findMax(root.left).value;
                root.left = delete(root.left, root);
            } else {
                return null;
            }
        } else if (root.value.compareTo(node.value) > 0) {
            root.left = delete(root.left, node);
        } else if (root.value.compareTo(node.value) < 0) {
            root.right = delete(root.right, node);
        }

        return blance(root);
    }

    public static Node findMax(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }


    public static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node blance(Node root) {
        if (root == null) {
            return null;
        }

        if (nodeHeight(root.left) - nodeHeight(root.right) > 1) {
            if (nodeHeight(root.left.left) >= nodeHeight(root.left.right)) {
                root = leftRoute(root);
            } else {
                root = leftDoubleRoute(root);
            }
        } else if (nodeHeight(root.left) - nodeHeight(root.right) < -1) {
            if (nodeHeight(root.right.right) > nodeHeight(root.right.left)) {
                root = rightToute(root);
            } else {
                root = rightDoubleRoute(root);
            }
        }

        root.height = (root.left.height > root.right.height ? root.left.height : root.right.height) + 1;
        return root;
    }

    public static Node leftRoute(Node node) {
        Node p = node.left;
        node.left = p.right;
        p.right = node;

        node.height = (nodeHeight(node.left) > nodeHeight(node.right) ? nodeHeight(node.left) : nodeHeight(node.right)) + 1;
        p.height = (nodeHeight(p.left) > nodeHeight(p.right) ? nodeHeight(p.left) : nodeHeight(p.right)) + 1;
        return p;
    }

    public static Node rightToute(Node node) {
        Node p = node.right;
        node.right = p.left;
        p.left = node;

        node.height = (nodeHeight(node.left) > nodeHeight(node.right) ? nodeHeight(node.left) : nodeHeight(node.right)) + 1;
        p.height = (nodeHeight(p.left) > nodeHeight(p.right) ? nodeHeight(p.left) : nodeHeight(p.right)) + 1;
        return p;
    }

    public static Node leftDoubleRoute(Node node) {
        node.left = rightToute(node.left);
        return leftRoute(node);
    }

    public static Node rightDoubleRoute(Node node) {
        node.right = leftRoute(node.right);
        return rightToute(node);
    }

    public static int nodeHeight(Node node) {
        return node == null ? -1 : node.height;
    }


    public static Node search(Node root, Node node) {

        if (root == null || node == null) {
            return null;
        }
        if (root.value.compareTo(node.value) == 0) {
            return root;
        } else if (root.value.compareTo(node.value) > 0) {
            return search(node.left, node);
        } else if (root.value.compareTo(node.value) < 0) {
            return search(node.right, node);
        }

        return null;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

      /*  System.out.println(root.right);
        preOrder(root.left);
        preOrder(root.right);*/

        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (stack.size() > 0) {
            Node p = stack.pop();
            System.out.println(p.value);

            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
        }


    }

    public static void midOrder(Node root) {
        if (root == null) {
            return;
        }

        /*midOrder(root.left);
        System.out.println(root.value);
        midOrder(root.right);*/


        Stack<Node> stack = new Stack<>();

        Node p = root;
        while (p != null || stack.size() > 0) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            if (stack.size() > 0) {
                Node outP = stack.pop();
                System.out.println(outP);
                p = outP.right;
            }

        }

    }

    public static void lastOrder(Node root) {
        if (root == null) {
            return;
        }

        /*lastOrder(root.left);
        lastOrder(root.right);
        System.out.println(root.value);*/

        Stack<Node> stack = new Stack<>();

        Node p = root;
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
                System.out.println(p.value);
            }

            while (stack.size()>0&& stack.peek().right == p){
                p = stack.pop();
                System.out.println(p.value);
            }

            if (stack.size() > 0) {
                p = stack.peek().right;
            }
        }

    }

    public class Node<T extends Comparable> {
        Node<T> left;
        Node<T> right;

        int height;
        T value;

        public Node() {
        }

        public Node(int height, T value) {
            this.height = height;
            this.value = value;
        }
    }

}
