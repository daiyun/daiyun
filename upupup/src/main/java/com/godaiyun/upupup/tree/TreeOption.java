package com.godaiyun.upupup.tree;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.LinkedList;
import java.util.Stack;

public class TreeOption {

  public static void main(String[] args) {

    TreeNode<String> treeRoot = new TreeNode(new Integer(1));

    for (int i = 2; i <= 9; i++) {
      TreeNode newNode = new TreeNode(new Integer(i));
      treeRoot = insert(treeRoot, newNode);
    }

    System.out.println("============顺序遍历============");
    heightOrderRecursion(treeRoot);
  }

  public static void printNode(TreeNode node) {
    System.out.println("element= [" + node.element + "], height=" + node.height);
  }

  public static void preOrderRecursion(TreeNode root) {
    /*
    // 递归方法
    if (root == null) {
      return;
    }

    // 打印节点数据
    printNode(root);

    // 处理左子树
    preOrderRecursion(root.left);

    // 处理右子树
    preOrderRecursion(root.right);*/

    // 非递归方法
    TreeNode p = root;
    Stack s = new StringStack();
    while (p != null) {

      while (p != null) {
        printNode(p);
        if (p.right != null) {
          s.push(p.right);
        }
        p = p.left;
      }

      if (!s.isEmpty()) {
        p = (TreeNode) s.pop();
      }
    }
  }

  public static void midOrderRecursion(TreeNode root) {

    /*// 递归遍历
    if(root == null){
      return;
    }

    midOrderRecursion(root.left);

    printNode(root);

    midOrderRecursion(root.right);*/

    // 非递归遍历
    TreeNode p = root;
    Stack s = new StringStack();

    while (p != null || !s.isEmpty()) {
      while (p != null) {
        s.push(p);
        p = p.left;
      }

      if (!s.isEmpty()) {
        p = (TreeNode) s.pop();
        printNode(p);
        p = p.right;
      }
    }

  }

  public static void lastOrderRecursion(TreeNode root) {
  /*
    // 递归遍历
    if (root == null) {
      return;
    }


    lastOrderRecursion(root.left);

    lastOrderRecursion(root.right);

    printNode(root);*/

    TreeNode p = root;

    Stack s = new StringStack();

    while (p != null || !s.isEmpty()) {
      while (p != null) {
        s.push(p);
        if (p.left != null) {
          p = p.left;
        } else {
          p = p.right;
        }
      }

      if (!s.isEmpty()) {
        p = (TreeNode) s.pop();
        printNode(p);
      }

      while (!s.isEmpty() && ((TreeNode) s.peek()).right == p) {
        p = (TreeNode) s.pop();
        printNode(p);
      }

      if (!s.isEmpty()) {
        p = (TreeNode) s.peek();
        p = p.right;
      } else {
        p = null;
      }
    }
  }

  public static void heightOrderRecursion(TreeNode root) {
    LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
    LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
    currentLevel.add(root);
    while (currentLevel.size() > 0) {
      while (currentLevel.size() > 0) {
        TreeNode p = currentLevel.pop();
        printNode(p);
        if (p.left != null) {
          nextLevel.add(p.left);
        }
        if (p.right != null) {
          nextLevel.add(p.right);
        }
      }
      currentLevel = nextLevel;
    }
  }

  public static TreeNode insert(TreeNode root, TreeNode newNode) {

    if (root == null) {
      return newNode;
    }

    if (compare(root, newNode) > 0) {
      root.left = insert(root.left, newNode);
    } else if (compare(root, newNode) < 0) {
      root.right = insert(root.right, newNode);
    } else {

    }
    return blance(root);
  }

  public static TreeNode blance(TreeNode root) {

    if (root == null) {
      return root;
    }

    if (height(root.right) - height(root.left) > 1) {
      if (height(root.right.right) > height(root.right.left)) {
        root = rightSingleRoute(root);
      } else {
        root = rightDoubleRoute(root);
      }
    } else if (height(root.left) - height(root.right) > 1) {
      if (height(root.left.left) > height(root.left.right)) {
        root = leftSingleRoute(root);
      } else {
        root = leftDoubleRoute(root);
      }
    } else {

    }
    root.height = Math.max(height(root.left), height(root.right)) + 1;

    return root;
  }

  public static TreeNode rightSingleRoute(TreeNode treeNode) {

    TreeNode re = treeNode.right;
    treeNode.right = re.left;
    re.left = treeNode;

    treeNode.height = Math.max(height(treeNode.left), height(treeNode.right)) + 1;
    re.height = Math.max(height(re.left), height(re.right)) + 1;
    return re;
  }


  public static TreeNode leftSingleRoute(TreeNode treeNode) {

    TreeNode re = treeNode.left;
    treeNode.left = re.right;
    re.right = treeNode;

    treeNode.height = Math.max(height(treeNode.left), height(treeNode.right)) + 1;
    re.height = Math.max(height(re.left), height(re.right)) + 1;
    return re;
  }


  public static TreeNode rightDoubleRoute(TreeNode treeNode) {

    treeNode.right = leftSingleRoute(treeNode.right);

    return rightSingleRoute(treeNode);
  }

  public static TreeNode leftDoubleRoute(TreeNode treeNode) {

    treeNode.left = rightSingleRoute(treeNode.left);

    return leftSingleRoute(treeNode);
  }

  public static int compare(TreeNode var1, TreeNode var2) {

    if (var1.element instanceof Integer && var2.element instanceof Integer) {
      int var3 = Integer.parseInt(var1.element.toString());
      int var4 = Integer.parseInt(var2.element.toString());
      return var3 - var4;
    } else if (var1.element instanceof String && var2.element instanceof String) {
      int var3 = Integer.parseInt(var1.element.toString());
      int var4 = Integer.parseInt(var2.element.toString());
      return var3 - var4;
    }
    return 0;
  }

  public static int height(TreeNode node) {
    return node == null ? -1 : node.height;
  }
}
