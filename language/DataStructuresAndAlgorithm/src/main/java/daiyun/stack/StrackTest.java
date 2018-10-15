package daiyun.stack;

import java.util.LinkedList;

public class StrackTest {

  public static void main(String[] args) {
    StrackTest test = new StrackTest();

    String[] strings = new String[8];
    strings[0] = "/*";
    strings[1] = "{";
    strings[2] = "[";
    strings[3] = "(";
    strings[4] = ")";
    strings[5] = "]";
    strings[6] = "}";
    strings[7] = "*/";

    System.out.println(test.charCheck(strings));
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
    System.out.println(test.infixToPostfix(strings));

    strings = new String[11];
    strings[0] = "6";
    strings[1] = "5";
    strings[2] = "2";
    strings[3] = "3";
    strings[4] = "+";
    strings[5] = "8";
    strings[6] = "*";
    strings[7] = "+";
    strings[8] = "3";
    strings[9] = "+";
    strings[10] = "*";
    System.out.println(test.postfixToinfix(strings));

  }

  public boolean charCheck(String... strs) {
    LinkedList<String> stacks = new LinkedList<String>();

    boolean flag = true;
    for (String str : strs) {
      if (str.equals("/*") || str.equals("(") || str.equals("[") || str.equals("{")) {
        stacks.push(str);
      } else {
        String endStr = stacks.poll();

        if (str.equals("*/")) {
          if (!endStr.equals("/*")) {
            flag = false;
            break;
          }
        }

        if (str.equals(")")) {
          if (!endStr.equals("(")) {
            flag = false;
            break;
          }
        }

        if (str.equals("]")) {
          if (!endStr.equals("[")) {
            flag = false;
            break;
          }
        }

        if (str.equals("}")) {
          if (!endStr.equals("{")) {
            flag = false;
            break;
          }
        }

      }

    }

    if (stacks.size() > 0) {
      flag = false;
    }

    return flag;
  }

  public String postfixToinfix(String... postfix) {
    LinkedList<String> stack = new LinkedList<>();
    for (String s : postfix) {
      if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("(") || s.equals(")")) {
        String a = stack.poll();
        String b = stack.poll();
        stack.push("(" + a + s + b + ")");
      } else {
        stack.push(s);
      }
    }
    return stack.poll();
  }

  public String infixToPostfix(String... infix) {

    LinkedList<String> list = new LinkedList<String>();

    String res = "";
    for (String s : infix) {

      if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("(") || s.equals(")")) {
        if (s.equals("(")) {
          list.push(s);
        } else if (s.equals(")")) {
          while (list.size() > 0) {
            if (list.peek().equals("(")) {
              list.poll();
              break;
            } else {
              String pollS = list.poll();
              res = res + pollS;
            }
          }
        } else if (s.equals("*") || s.equals("/")) {
          while (list.size() > 0) {
            if (list.peek().equals("+") || list.peek().equals("-") || list.peek().equals("(")) {
              break;
            } else {
              String pollS = list.poll();
              res = res + pollS;
            }

          }
          list.push(s);
        } else if (s.equals("+") || s.equals("-")) {

          while (list.size() > 0) {
            if (list.peek().equals("(")) {
              break;
            } else {
              String pollS = list.poll();
              res = res + pollS;
            }
          }
          list.push(s);
        }


      } else {
        res = res + s;
      }
    }

    while (list.size() > 0) {
      String pollS = list.poll();
      res = res + pollS;
    }

    return res;
  }
}
