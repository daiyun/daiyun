package daiyun.leetcode.lcci;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 * <p>
 * 字符串长度在[0, 50000]范围内。
 */
public class Question0106 {

    public static void main(String[] args) {
        Question0106 question = new Question0106();

        Question0106.Solution solution = question.new Solution();

//        "ds sdfs afs sdfa dfssf asdf             "
//        27

        System.out.println(solution.compressString("aaccaa"));
    }


    class Solution {
        public String compressString(String S) {
            if (S == null || S.length() < 3) {
                return S;
            }

            StringBuffer sb = new StringBuffer();

            char preChar = S.charAt(0);
            int preCharCount = 1;
            for (int i = 1; i < S.length(); i++) {
                char c = S.charAt(i);

                if (c == preChar) {
                    preCharCount++;
                } else {
                    sb.append(preChar);
                    sb.append(preCharCount);
                    preChar = c;
                    preCharCount = 1;
                }
            }
            sb.append(preChar);
            sb.append(preCharCount);

            if (sb.length() >= S.length()) {
                return S;
            }
            return sb.toString();
        }
    }
}
