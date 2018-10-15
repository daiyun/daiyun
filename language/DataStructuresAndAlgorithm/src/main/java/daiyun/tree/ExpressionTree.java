package daiyun.tree;

import java.util.LinkedList;

public class ExpressionTree {

  public static void main(String[] args) {
    BinTree<String> treeSet5 = new BinTree<>();
    treeSet5.value = "b";
    BinTree<String> treeSet6 = new BinTree<>();
    treeSet6.value = "c";

    BinTree<String> treeSet3 = new BinTree<>();
    treeSet3.value = "a";
    BinTree<String> treeSet4 = new BinTree<>();
    treeSet4.value = "*";
    treeSet4.left = treeSet5;
    treeSet4.right = treeSet6;


    BinTree<String> treeSet11 = new BinTree<>();
    treeSet11.value = "d";
    BinTree<String> treeSet12 = new BinTree<>();
    treeSet12.value = "e";

    BinTree<String> treeSet9 = new BinTree<>();
    treeSet9.value = "*";
    treeSet9.left = treeSet11;
    treeSet9.right = treeSet12;

    BinTree<String> treeSet10 = new BinTree<>();
    treeSet10.value = "f";


    BinTree<String> treeSet7 = new BinTree<>();
    treeSet7.value = "+";
    treeSet7.left = treeSet9;
    treeSet7.right = treeSet10;

    BinTree<String> treeSet8 = new BinTree<>();
    treeSet8.value = "g";

    BinTree<String> treeSet1 = new BinTree<>();
    treeSet1.value = "+";
    treeSet1.left = treeSet3;
    treeSet1.right = treeSet4;

    BinTree<String> treeSet2 = new BinTree<>();
    treeSet2.value = "*";
    treeSet2.left = treeSet7;
    treeSet2.right = treeSet8;

    BinTree<String> binTree = new BinTree<>();
    binTree.value = "+";
    binTree.left = treeSet1;
    binTree.right = treeSet2;

//    BinTreeTraversing.postfix(binTree);

    String[] strings = new String[13];
   /* strings[0] = "a";
    strings[1] = "b";
    strings[2] = "+";
    strings[3] = "c";
    strings[4] = "d";
    strings[5] = "e";
    strings[6] = "+";
    strings[7] = "*";
    strings[8] = "*";*/

    strings = new String[15];
    strings[0] = "a";
    strings[1] = "+";
    strings[2] = "b";
    strings[3] = "*";
    strings[4] = "c";
    strings[5] = "+";
    strings[6] = "(";
    strings[7] = "d";
    strings[8] = "*";
    strings[9] = "e";
    strings[10] = "+";
    strings[11] = "f";
    strings[12] = ")";
    strings[13] = "*";
    strings[14] = "g";

    BinTree binTree1 = binTreeOfExpressionByInfix(strings);

    BinTreeTraversing.level(binTree1);
  }

  public static BinTree binTreeOfExpressionBypostfix(String... postfix) {
    LinkedList<BinTree> binTrees = new LinkedList<>();

    for (String s : postfix) {
      if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {

        BinTree nodeAdd = new BinTree();
        nodeAdd.value = s;

        BinTree nodeA = binTrees.poll();
        BinTree nodeB = binTrees.poll();

        nodeAdd.left = nodeB;
        nodeAdd.right = nodeA;

        binTrees.push(nodeAdd);

      } else {
        BinTree<String> binTreeAdd = new BinTree<>();
        binTreeAdd.value = s;
        binTrees.push(binTreeAdd);
      }
    }
    return binTrees.poll();
  }


  public static BinTree binTreeOfExpressionByInfix(String... infix) {
    LinkedList<String> options = new LinkedList<>();
    LinkedList<BinTree> nums = new LinkedList<>();

    for (String s : infix) {
      if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("(") || s.equals(")")) {
        if (s.equals("(")) {
          options.push(s);
        } else if (s.equals(")")) {
          while (options.size() > 0) {
            if (options.peek().equals("(")) {
              options.poll();
              break;
            } else {
              BinTree<String> nodeAdd = new BinTree<>();
              nodeAdd.value = options.poll();

              nodeAdd.right = nums.poll();
              nodeAdd.left = nums.poll();
              nums.push(nodeAdd);
            }
          }
        } else if (s.equals("*") || s.equals("/")) {
          while (options.size() > 0) {
            if (options.peek().equals("(") || options.peek().equals("+") || options.peek().equals("-")) {
              break;
            } else {
              BinTree<String> nodeAdd = new BinTree<>();
              nodeAdd.value = options.poll();
              nodeAdd.right = nums.poll();
              nodeAdd.left = nums.poll();
              nums.push(nodeAdd);
            }
          }
          options.push(s);

        } else if (s.equals("+") || s.equals("-")) {
          while (options.size() > 0) {
            if (options.peek().equals("(")) {
              break;
            } else {
              BinTree<String> nodeAdd = new BinTree<>();
              nodeAdd.value = options.poll();
              nodeAdd.right = nums.poll();
              nodeAdd.left = nums.poll();
              nums.push(nodeAdd);
            }
          }
          options.push(s);
        }

      } else {
        BinTree<String> nodeAdd = new BinTree<>();
        nodeAdd.value = s;
        nums.push(nodeAdd);
      }
    }

    while (options.size() > 0) {
      BinTree<String> nodeAdd = new BinTree<>();
      nodeAdd.value = options.poll();
      nodeAdd.right = nums.poll();
      nodeAdd.left = nums.poll();
      nums.push(nodeAdd);
    }

    return nums.poll();
  }

}
