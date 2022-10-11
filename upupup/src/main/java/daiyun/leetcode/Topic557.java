package daiyun.leetcode;

import java.util.HashMap;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 * <p>
 * 提示：
 * <p>
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic557 {

    public static void main(String[] args) {

        Topic557 topic1 = new Topic557();

        Solution solution = topic1.new Solution();


        String res = solution.reverseWords("");

        System.out.println(res);
    }

    class Solution {
        public String reverseWords(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }

            StringBuilder sb = new StringBuilder();
            int worldStart = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    int k = i - 1;
                    while (k > worldStart) {
                        sb.append(s.charAt(k--));
                    }
                    sb.append(' ');
                    worldStart = i;
                }
            }

            for (int k = s.length() - 1; k > worldStart; k--) {
                sb.append(s.charAt(k));
            }

            return sb.toString();
        }
    }
}
