package daiyun.leetcode;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 * <p>
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 * <p>
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 */
public class Topic44 {

    public static void main(String[] args) {

        Topic44 topic1 = new Topic44();

        Solution solution = topic1.new Solution();

        boolean res = solution.isMatch("aaa", "a");

        System.out.println(res);
    }


    class Solution {
        public boolean isMatch(String s, String p) {

            if ((s == null && p == null) || (s.length() == 0 && p.length() == 0)) {
                return true;
            }

            if ((p == null && s != null) || (p.length() == 0 && s.length() > 0)) {
                return false;
            }

            if (s.length() == 0) {
                char c = p.charAt(0);
                if (c == '*' || c == '?') {
                    return isMatch(s, p.substring(1));
                } else {
                    return false;
                }
            }

            int a = s.charAt(0);
            int c = p.charAt(0);

            if (a == c || c == '?') {
                return isMatch(s.substring(1), p.substring(1));
            } else if (c == '*') {

                boolean one = isMatch(s.substring(1), p);
                boolean two = isMatch(s, p.substring(1));


                if (one || two) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }
    }

    class SolutionA {
        public boolean isMatch(String s, String p) {
            int len1 = s.length();
            int len2 = p.length();

            boolean[][] ans = new boolean[len1 + 1][len2 + 1];

            ans[0][0] = true;


            for (int i = 1; i <= len2; i++) {
                ans[0][i] = ans[0][i - 1] && (p.charAt(i - 1) == '*' || p.charAt(i - 1) == '?');
            }

            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                        ans[i][j] = ans[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        ans[i][j] = ans[i - 1][j] || ans[i][j - 1];
                    }
                }
            }

            return ans[len1][len2];
        }
    }
}
