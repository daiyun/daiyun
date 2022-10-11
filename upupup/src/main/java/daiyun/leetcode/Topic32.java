package daiyun.leetcode;

import javafx.util.Pair;

import java.util.*;

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

        SolutionC solution = topic1.new SolutionC();

        System.out.println(solution.longestValidParentheses("(()))"));

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

    class SolutionA {
        public int longestValidParentheses(String s) {
            int maxLength = 0;
            if (s == null || s.length() < 2) {
                return maxLength;
            }

            char[] characters = s.toCharArray();
            Stack<Pair<Character, Integer>> stack = new Stack<>();
            Map<Integer, Integer> preLength = new HashMap<>();

            for (int i = 0; i < characters.length; i++) {
                char c = characters[i];
                if ('(' == c) {
                    stack.push(new Pair<>(c, i));
                } else {
                    if (stack.size() > 0) {
                        Pair<Character, Integer> pair = stack.pop();
                        int index = pair.getValue();
                        int preLen = preLength.getOrDefault(index - 1, 0);

                        int currentLength = i - index + 1 + preLen;
                        preLength.put(i, currentLength);
                        if (currentLength > maxLength) {
                            maxLength = currentLength;
                        }
                    }
                }
            }

            return maxLength;
        }
    }

    class SolutionB {
        public int longestValidParentheses(String s) {
            int maxLength = 0;
            if (s == null || s.length() < 2) {
                return maxLength;
            }

            char[] characters = s.toCharArray();
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);

            for (int i = 0; i < characters.length; i++) {
                char c = characters[i];
                if ('(' == c) {
                    stack.push(i);
                } else {
                    if (stack.size() > 0) {
                        stack.pop();

                        if (stack.size() > 0) {
                            int currentLength = i - stack.peek();
                            if (currentLength > maxLength) {
                                maxLength = currentLength;
                            }
                        } else {
                            stack.push(i);
                        }
                    }
                }
            }

            return maxLength;
        }
    }

    class SolutionC {
        public int longestValidParentheses(String s) {
            if (s == null || s.length() < 2) {
                return 0;
            }

            int[] dp = new int[s.length() + 1];

            for (int i = 0; i < s.length(); i++) {
                if (')' == s.charAt(i)) {
                    if ((i - dp[i] - 1) >= 0 && s.charAt(i - dp[i] - 1) == '(') {
                        dp[i + 1] = 2 + dp[i] + dp[i - dp[i] - 1];
                    }
                }
            }

            int max = 0;
            for (int length : dp) {
                if (length > max) {
                    max = length;
                }
            }
            return max;
        }
    }
}
