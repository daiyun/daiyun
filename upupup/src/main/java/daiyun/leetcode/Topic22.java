package daiyun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Topic22 {

    public static void main(String[] args) {

        Topic22 topic1 = new Topic22();

        Solution solution = topic1.new Solution();


    }

    class Solution {
        public List<String> generateParenthesis(int n) {

            List<String> ans = new ArrayList<>();
            backtrack(ans, "", 0, 0, n);
            return ans;

        }

        public void backtrack(List<String> ans, String str, int open, int close, int max) {

            if (str.length() == max * 2) {
                ans.add(str);
                return;
            }

            if (open < max) {
                backtrack(ans, str + "(", open + 1, close, max);
            }

            if (close < open) {
                backtrack(ans, str + ")", open, close + 1, max);
            }
        }
    }

}
