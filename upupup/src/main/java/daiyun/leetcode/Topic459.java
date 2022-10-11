package daiyun.leetcode;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: "aba"
 * <p>
 * 输出: False
 * 示例 3:
 * <p>
 * 输入: "abcabcabcabc"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic459 {

    public static void main(String[] args) {

        Topic459 topic1 = new Topic459();

        Solution solution = topic1.new Solution();

        System.out.println(solution.repeatedSubstringPattern("abaaaaba"));

    }

    class Solution {
        public boolean repeatedSubstringPattern(String s) {

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(0)) {
                    int j = i;
                    String str = s.substring(0, i);
                    for (; j + i <= s.length(); j = j + i) {
                        if (!str.equals(s.substring(j, j + i))) {
                            break;
                        }
                    }
                    if (j == s.length()) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
