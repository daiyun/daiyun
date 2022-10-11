package daiyun.leetcode.lcci;

/**
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * <p>
 * 示例1:
 * <p>
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 * 示例2:
 * <p>
 * 输入：s1 = "aa", s2 = "aba"
 * 输出：False
 * 提示：
 * <p>
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 * <p>
 * 你能只调用一次检查子串的方法吗？
 */
public class Question0109 {

    public static void main(String[] args) {
        Question0109 question = new Question0109();

        Question0109.Solution solution = question.new Solution();

//        "sdfsdsdssdfs"
//        "dssdfs"
//        "sdfsds"
//        27

        System.out.println(solution.isFlipedString("dssdfs", "sdfsds"));
    }


    class Solution {
        public boolean isFlipedString(String s1, String s2) {
            if (s1 == null || s2 == null) {
                return false;
            }

            if (s1.length() != s2.length()) {
                return false;
            }

            int flipIndex = 0;

            while (flipIndex < s1.length()) {
                int i = flipIndex;
                for (; i < s1.length(); i++) {
                    if (s1.charAt(i) != s2.charAt(i - flipIndex)) {
                        flipIndex++;
                        break;
                    }
                }

                if (i == s1.length()) {
                    break;
                }
            }

            String res = s1.substring(flipIndex) + s1.substring(0, flipIndex);

            return s2.equals(res);
        }
    }
}
