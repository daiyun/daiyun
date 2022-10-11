package daiyun.leetcode.lcci;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 */
public class Question0102 {

    public static void main(String[] args) {
        Question0102 question = new Question0102();

        Question0102.Solution solution = question.new Solution();

        System.out.println(solution.CheckPermutation("121","211a"));
    }


    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1.length() == 0 && s2.length() == 0) {
                return true;
            }
            if (s1.length() != s2.length()) {
                return false;
            }

            int[] charCount = new int[256];
            for (int i = 0; i < s1.length(); i++) {
                if (charCount[s1.charAt(i)] > 0) {
                    charCount[s1.charAt(i)] = charCount[s1.charAt(i)] + 1;
                } else {
                    charCount[s1.charAt(i)] = 1;
                }
            }


            for (int i = 0; i < s2.length(); i++) {
                if (charCount[s2.charAt(i)] < 1) {
                    return false;
                } else {
                    charCount[s2.charAt(i)] = charCount[s2.charAt(i)] - 1;
                }
            }

            return true;
        }
    }
}
