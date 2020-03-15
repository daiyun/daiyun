package daiyun.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class Topic32 {

    public static void main(String[] args) {

        Topic32 topic1 = new Topic32();

        Solution solution = topic1.new Solution();

        System.out.println(solution.longestValidParentheses(")()())"));

    }

    class Solution {
        public int longestValidParentheses(String s) {
            int len = s.length();
            if (len < 2) {
                return 0;
            }

            LinkedList<Map<Integer, Character>> stack = new LinkedList<>();

            boolean[] isMetch = new boolean[len];


            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    Map<Integer, Character> map = new HashMap<>();
                    map.put(i, c);
                    stack.push(map);
                } else {
                    if (stack.size() > 0) {
                        Map<Integer, Character> map = stack.pop();
                        Set<Integer> set = map.keySet();
                        for (Integer k : set) {
                            Character c2 = map.get(k);
                            if (c2 == '(') {
                                isMetch[i] = true;
                                isMetch[k] = true;
                            }
                        }
                    }
                }
            }

            int maxLength = 0;
            int curLen = 0;
            for (int i = 0; i < len; i++) {
                if (isMetch[i]) {
                    curLen++;
                } else {
                    if (maxLength < curLen) {
                        maxLength = curLen;
                        curLen = 0;
                    }
                }
            }
            if (maxLength < curLen) {
                maxLength = curLen;
            }

            return maxLength;
        }
    }
}
