package daiyun.leetcode.lcci;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分
 */
public class Question0101 {

    public static void main(String[] args) {
        Question0101 question = new Question0101();

        Question0101.Solution solution = question.new Solution();

        System.out.println(solution.isUnique("121"));
    }


    class Solution {
        public boolean isUnique(String astr) {

            if (astr == null || astr.length() < 1) {
                return true;
            }

            int[] charIndex = new int[256];
            for (int i = 0; i < astr.length(); i++) {
                if (charIndex[astr.charAt(i)] > 0) {
                    return false;
                }
                charIndex[astr.charAt(i)] = 1;
            }
            return true;
        }
    }
}
