package daiyun.tree;

import java.util.ArrayList;
import java.util.List;

public class BinTreeTraversing {

  public static void prefix(BinTree tree) {
    if (tree != null) {
      System.out.print(tree.value);
      prefix(tree.left);
      prefix(tree.right);
    }
  }

  public static void infix(BinTree tree) {
    if (tree != null) {
      infix(tree.left);
      System.out.print(tree.value);
      infix(tree.right);
    }
  }

  public static void postfix(BinTree tree) {
    if (tree != null) {
      postfix(tree.left);
      postfix(tree.right);
      System.out.print(tree.value);
    }
  }

  public static void level(BinTree tree) {

    List<BinTree> traversingList = new ArrayList();
    List<BinTree> nextLevelNode = new ArrayList<>();
    traversingList.add(tree);

    while (true) {
      System.out.println();
      for (BinTree tree1 : traversingList) {
        System.out.print(tree1.value);
        if (tree1.left != null) {
          nextLevelNode.add(tree1.left);
        }

        if (tree1.right != null) {
          nextLevelNode.add(tree1.right);
        }
      }

      if (nextLevelNode.size() == 0) {
        break;
      } else {
        traversingList.clear();
        traversingList.addAll(nextLevelNode);
        nextLevelNode.clear();
      }
    }

  }

}
