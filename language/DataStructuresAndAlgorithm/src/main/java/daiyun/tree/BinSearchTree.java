package daiyun.tree;

public class BinSearchTree {


  public static void main(String[] args) {

    BinTree<Integer> tree = new BinTree<>();

    tree = insert(1, tree);
    tree = insert(4, tree);
    tree = insert(2, tree);
    tree = insert(9, tree);
    tree = insert(6, tree);
    tree = insert(7, tree);

    BinTreeTraversing.infix(tree);

    System.out.println();
    tree =remove(6, tree);

    BinTreeTraversing.infix(tree);

  }

  public static BinTree insert(Comparable o, BinTree tree) {
    if (tree == null || tree.value == null) {
      BinTree node = new BinTree();
      node.value = o;
      return node;
    }

    int compareRes = o.compareTo(tree.value);

    if (compareRes < 0) {
      tree.left = insert(o, tree.left);
    } else if (compareRes > 0) {
      tree.right = insert(o, tree.right);
    }
    return tree;
  }

  public static boolean contains(Comparable o, BinTree tree) {
    if (tree == null || tree.value == null) {
      return false;
    }

    int compareRes = o.compareTo(tree.value);

    if (compareRes > 0) {
      return contains(o, tree.right);
    } else if (compareRes < 0) {
      return contains(o, tree.left);
    } else {
      return true;
    }

  }

  public static BinTree remove(Comparable o, BinTree tree) {

    if (tree == null || tree.value == null) {
      return null;
    }

    int compareRes = o.compareTo(tree.value);

    if (compareRes < 0) {
     tree.left =  remove(o, tree.left);
    } else if (compareRes > 0) {
      tree.right = remove(o, tree.right);
    } else {

      if (tree.left != null && tree.right != null) {

        tree.value = findMix(tree.right).value;

        tree.right = remove(tree.value, tree.right);

      } else {
        tree = (tree.left != null) ? tree.left : tree.right;
      }
    }

    return tree;
  }

  public static BinTree findMix(BinTree tree) {

    if (tree == null || tree.value == null) {
      return null;
    }

    if (tree.left == null) {
      return tree;
    }

    return findMix(tree.left);

  }

  public static BinTree finxMax(BinTree tree) {
    while (tree.right != null) {
      tree = tree.right;
    }
    return tree;
  }
}
