package daiyun.leetcode;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的字符串长度不会超过 1000 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic647 {

    public static void main(String[] args) {

        Topic647 topic1 = new Topic647();

        Solution solution = topic1.new Solution();

        System.out.println(solution.countSubstrings("00110"));

    }

    class Solution {
        public int countSubstrings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int count = 0;

            for (int i = 0; i < s.length(); i++) {
                count += doCountSubStrings(s, i);
            }

            return count;
        }

        public int doCountSubStrings(String s, int index) {
            int i = 1;
            int left = index - 1;
            int right = index + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                i++;
                left--;
                right++;
            }

            left = index - 1;
            right = index;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                i++;
                left--;
                right++;
            }
            return i;
        }
    }
}
