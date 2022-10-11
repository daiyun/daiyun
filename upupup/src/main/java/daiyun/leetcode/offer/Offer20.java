package daiyun.leetcode.offer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer20 {

    public static void main(String[] args) {
        Offer20 offer = new Offer20();

        Solution solution = offer.new Solution();

        System.out.println(solution.isNumber("4e+"));

    }

    class Solution {
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            s = s.trim();
            if (s.length() == 0) {
                return false;
            }

            boolean eFlag = false;
            boolean douFlag = false;
            int numSize = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    numSize++;
                } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                    if (eFlag || i == s.length() - 1 || numSize == 0) {
                        return false;
                    } else {
                        eFlag = true;
                        douFlag = false;
                    }
                } else if (s.charAt(i) == '.') {
                    if (eFlag || douFlag) {
                        return false;
                    } else {
                        if (i > 0 && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9') {

                        } else if (i + 1 == s.length() || s.charAt(i + 1) > '9' || s.charAt(i + 1) < '0') {
                            return false;
                        }
                        douFlag = true;
                    }
                } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                    if (eFlag) {
                        if (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                            return false;
                        }
                        if ((i + 1 == s.length() || s.charAt(i + 1) < '0' || s.charAt(i + 1) > '9')) {
                            return false;
                        }
                    } else {
                        if (i != 0) {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            return true;
        }
    }

}
