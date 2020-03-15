package daiyun.leetcode;


/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class Topic125 {

    public static void main(String[] args) {

        Topic125 topic1 = new Topic125();

        Solution solution = topic1.new Solution();

        long start = System.currentTimeMillis();

        boolean res = solution.isPalindrome("A man, a plan, a canal: Panama");

        System.out.println(res);

        System.out.println(System.currentTimeMillis() - start);
    }


    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null) {
                return false;
            }
            if ("".equals(s)) {
                return true;
            }

            int len = s.length();

            int start = 0;
            int end = len - 1;

            while (start < end) {
                char left = s.charAt(start++);
                while (start < len && !(left >= 48 && left <= 57) && !(left >= 65 && left <= 90) && !(left >= 97 && left <= 122)) {
                    left = s.charAt(start++);
                }

                char right = s.charAt(end--);
                while (end >= 0 && !(right >= 48 && right <= 57) && !(right >= 65 && right <= 90) && !(right >= 97 && right <= 122)) {
                    right = s.charAt(end--);
                }

                if (right >= 48 && right <= 57) {
                    if (right != left) {
                        return false;
                    }
                } else if (right >= 65 && right <= 90) {
                    if (left >= 97 && left <= 122) {
                        left = (char) (left - 32);
                    }
                    if (right != left) {
                        return false;
                    }
                } else if (right >= 97 && right <= 122) {
                    if (left >= 65 && left <= 90) {
                        left = (char) (left + 32);
                    }
                    if (right != left) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
