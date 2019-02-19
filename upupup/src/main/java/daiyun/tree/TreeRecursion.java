package daiyun.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author godaiyun
 * @date 2018-11-21 09:55.
 */
public class TreeRecursion {

  public static void main(String[] args) {
    TreeNode<String> treeRoot = new TreeNode(1);

    treeRoot.left = new TreeNode(2);
    treeRoot.right = new TreeNode(3);

    treeRoot.left.left = new TreeNode(4);
    treeRoot.left.right = new TreeNode(5);

    treeRoot.right.left = new TreeNode(6);
    treeRoot.right.right = new TreeNode(7);

    lastRecuresion(treeRoot);
  }

  public static void printNode(TreeNode node) {
    System.out.println("element= [" + node.element + "], height=" + node.height);
  }

  public static void levelRecursion(TreeNode node) {
    List<TreeNode> lists = new ArrayList<>();
    lists.add(node);
    while (lists.size() > 0) {
      List<TreeNode> nextList = new ArrayList<>();
      for (TreeNode one : lists) {
        printNode(one);
        if (one.left != null) {
          nextList.add(one.left);
        }
        if (one.right != null) {
          nextList.add(one.right);
        }
      }
      lists.clear();
      lists.addAll(nextList);
    }
  }

  public static void preRecuresion(TreeNode node) {
    if (node == null) {
      return;
    }

    /*printNode(node);
    preRecuresion(node.left);
    preRecuresion(node.right);*/

    LinkedList<TreeNode> stack = new LinkedList<>();
    stack.push(node);
    while (stack.size() > 0) {
      TreeNode one = stack.pop();
      printNode(one);

      if (one.right != null) {
        stack.push(one.right);
      }

      if (one.left != null) {
        stack.push(one.left);
      }
    }


  }

  public static void midRecuresion(TreeNode node) {
    if (node == null) {
      return;
    }
    /*midRecuresion(node.left);
    printNode(node);
    midRecuresion(node.right);*/

    LinkedList<TreeNode> stack = new LinkedList<>();
    TreeNode p = node;

    while (p != null || stack.size() > 0) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      if (stack.size() > 0) {
        TreeNode p2 = stack.pop();
        printNode(p2);
        p = p2.right;
      }
    }
  }

  public static void lastRecuresion(TreeNode node) {
    if (node == null) {
      return;
    }
    /*lastRecuresion(node.left);
    lastRecuresion(node.right);
    printNode(node);*/


    TreeNode p = node;
    LinkedList<TreeNode> stack = new LinkedList<>();

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
        printNode(p);
      }

      while (stack.size() > 0 && stack.peek().right == p) {
        p = stack.pop();
        printNode(p);
      }

      if (stack.size() > 0) {
        p = stack.peek().right;
      } else {
        p = null;
      }

    }
  }

}
