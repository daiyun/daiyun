package daiyun.leetcode;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class Topic20 {

    public static void main(String[] args) {

        Topic20 topic1 = new Topic20();

        Solution solution = topic1.new Solution();


        System.out.println(solution.isValid("{}["));
    }


    class Solution {
        public boolean isValid(String s) {

            Stack<String> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '[') {
                    stack.push(c + "");
                } else if (c == '{') {
                    stack.push(c + "");
                } else if (c == '(') {
                    stack.push(c + "");
                } else if (c == ']') {
                    if (stack.size() == 0) {
                        return false;
                    }
                    if (!(stack.pop() + "").equals("[")) {
                        return false;
                    }
                } else if (c == '}') {
                    if (stack.size() == 0) {
                        return false;
                    }
                    if (!(stack.pop() + "").equals("{")) {
                        return false;
                    }
                } else if (c == ')') {
                    if (stack.size() == 0) {
                        return false;
                    }
                    if (!(stack.pop() + "").equals("(")) {
                        return false;
                    }
                }
            }

            if (stack.size() > 0) {
                return false;
            }

            return true;
        }
    }

}
