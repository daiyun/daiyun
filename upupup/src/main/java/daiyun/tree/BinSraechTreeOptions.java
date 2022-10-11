package daiyun.tree;



public class BinSraechTreeOptions {

    public TreeNode search(TreeNode root, TreeNode node) {
        if(root == null || node == null || node.element== null || root.element == null){
            return null;
        }

        int op = node.element.compareTo(root.element);
        if (op == 0) {
            return root;
        } else if (op < 0) {
            return search(root.left, node);
        } else {
            return search(root.right, node);
        }
    }

    public TreeNode insert(TreeNode root, TreeNode node) {

        if(root == null){
            return node;
        }

        int op = node.element.compareTo(root.element);

        if (op == 0) {
        } else if (op < 0) {
            root.left = insert(root.left, node);
        } else {
            root.right = insert(root.right,node);
        }

        return root;
    }

    public TreeNode remove(TreeNode root, TreeNode node) {
        if(root == null){
            return node;
        }

        int op = node.element.compareTo(root.element);
        if (op == 0) {
            if(root.left != null){
                TreeNode leftMax = findMax(root.left);
                root.left = remove(root.left,leftMax);
                root.element = leftMax.element;

            }else if(root.right != null){
                TreeNode rightMin = findMin(root.right);
                root.right = remove(root.right,rightMin);
                root.element = rightMin.element;
            }else{
                return null;
            }
        } else if (op < 0) {
            root.left = remove(root.left, node);
        } else {
            root.right = remove(root.right,node);
        }
        return root;
    }

    public TreeNode findMax(TreeNode root){
        TreeNode p = root;
        while (p.right!= null){
            p = p.right;
        }
        return p;
    }

    public TreeNode findMin(TreeNode root){
        TreeNode p = root;
        while (p.left!=null){
            p = p.left;
        }
        return p;
    }
}
