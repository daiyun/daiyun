package daiyun.tree;

import java.util.LinkedList;

public class ExpressionTree {


  public static void main(String[] args) {
    char[] arr = {'(', 'a', '+', 'b', ')', '*', 'c'};
//    char[] arr = {'a', 'b', '+', 'c', '*'};
    midToLast(arr);
    System.out.println();
  }

  public static void midToLast(char[] arr) {

    LinkedList<Character> stack = new LinkedList<>();
    for (int i = 0; i < arr.length; i++) {
      char p = arr[i];
      if (p == '-' || p == '+' || p == '*' || p == '/' || p == '(' || p == ')') {
        if (p == '(') {
          stack.push(p);
        } else if (p == ')') {
          while (stack.size() > 0 && stack.peek() != '(') {
            System.out.print(stack.pop() + " ");
          }
          if (stack.size() > 0) {
            stack.pop();
          }
        } else if (p == '-' || p == '+') {
          while (stack.size() > 0 && stack.peek() != '(') {
            System.out.print(stack.pop() + " ");
          }
          stack.push(p);
        } else if (p == '*' || p == '/') {

          while (stack.size() > 0 && (stack.peek() == '*' || stack.peek() == '/')) {
            System.out.print(stack.pop() + " ");
          }
          stack.push(p);
        }
      } else {
        System.out.print(p + " ");
      }
    }
    while (stack.size() > 0) {
      System.out.print(stack.pop() + " ");
    }
  }

  public static void lastToMid(char[] arr) {

    LinkedList<String> stack = new LinkedList<>();
    for (int i = 0; i < arr.length; i++) {
      char p = arr[i];
      if (p == '+' || p == '-' || p == '*' || p == '/') {
        String b = stack.pop();
        String a = stack.pop();
        stack.push("(" + a + p + b + ")");
      } else {
        stack.push(p + "");
      }
    }
    System.out.println(stack.pop());

  }
}
