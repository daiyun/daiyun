package daiyun.tree;

public class AVLTree {

  public static void main(String[] args) {

  }

  public static BinTree insert(Comparable o, BinTree tree) {

    if (tree == null || tree.value == null) {
      BinTree node = new BinTree();
      node.value = o;
      return node;
    }

    int compareRes = o.compareTo(tree.value);

    if (compareRes > 0) {

      tree.right = insert(o, tree.right);
    } else if (compareRes < 0) {

      tree.left = insert(o, tree.left);
    } else {

    }

    return balance(tree);
  }

  private static BinTree balance(BinTree tree) {

    if (tree == null || tree.value == null) {
      return tree;
    }

    if (height(tree.left) - height(tree.right) > 1) {
      if (height(tree.left.left) >= height(tree.left.right)) {
        tree = rotateWithLeftChild(tree);
      } else {
        tree = doubleRoutateWithLeftChild(tree);
      }
    } else if (height(tree.right) - height(tree.left) > 1) {

      if (height(tree.right.right) >= height(tree.right.left)) {
        tree = rotateWithRightChild(tree);
      } else {
        tree = doubleRoutateWithRightChild(tree);
      }
    }

    tree.height = Math.max(height(tree.left), height(tree.right)) + 1;

    return tree;
  }

  private static BinTree doubleRoutateWithRightChild(BinTree tree) {

    tree.right = rotateWithLeftChild(tree.right);

    return rotateWithRightChild(tree);
  }

  private static BinTree doubleRoutateWithLeftChild(BinTree tree) {

    tree.right = rotateWithRightChild(tree.right);

    return rotateWithLeftChild(tree);
  }

  private static BinTree rotateWithRightChild(BinTree tree) {
    BinTree treeRight = tree.right;
    tree.right = treeRight.left;
    treeRight.left = tree;

    tree.height = Math.max(height(tree.left), height(tree.right)) + 1;

    treeRight.height = Math.max(height(treeRight.left), height(treeRight.right)) + 1;

    return treeRight;
  }

  private static BinTree rotateWithLeftChild(BinTree tree) {

    BinTree treeLeft = tree.left;
    tree.left = treeLeft.right;
    treeLeft.right = tree;

    tree.height = Math.max(height(tree.left), height(tree.right)) + 1;

    treeLeft.height = Math.max(height(treeLeft.right), height(treeLeft.left)) + 1;

    return treeLeft;
  }

  public static int height(BinTree tree) {
    return tree == null ? -1 : tree.height;
  }
}
