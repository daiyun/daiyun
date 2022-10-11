package daiyun.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 * <p>
 * 输入: "abcd"
 * 输出: "dcbabcd"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic214 {

    public static void main(String[] args) {

        Topic214 topic1 = new Topic214();

        Solution solution = topic1.new Solution();


        String res = solution.shortestPalindrome("abbaa");

        System.out.println(res);
    }

    class Solution {
        public String shortestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }

            int length = s.length();
            for (int i = length / 2; i >= 0; i--) {
                if (i < length - i) {
                    int k = 1;
                    while (k <= i && s.charAt(i - k) == s.charAt(i + k)) {
                        k++;
                    }

                    if (k - 1 == i) {
                        StringBuilder sb = new StringBuilder();
                        int temp = length - 1;
                        while (temp >= i + k) {
                            sb.append(s.charAt(temp--));
                        }
                        sb.append(s);
                        return sb.toString();
                    }
                }

                int p = 0;
                while (i - 1 - p >= 0 && s.charAt(i - 1 - p) == s.charAt(i + p)) {
                    p++;
                }

                if (p != 0 && i - p == 0) {
                    StringBuilder sb = new StringBuilder();
                    int temp = length - 1;
                    while (temp >= i + p) {
                        sb.append(s.charAt(temp--));
                    }
                    sb.append(s);
                    return sb.toString();
                }
            }

            return s;
        }
    }

}
