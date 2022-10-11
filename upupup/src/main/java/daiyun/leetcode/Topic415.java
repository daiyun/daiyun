package daiyun.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic415 {

    public static void main(String[] args) {

        Topic415 topic1 = new Topic415();

        Solution solution = topic1.new Solution();

        System.out.println(solution.addHex("ff", "ff"));

    }

    public Topic415() {
    }

    class Solution {

        private Map<Character, Integer> chat2Num = new HashMap<>();
        private Map<Integer, Character> num2Char = new HashMap<>();

        public Solution() {
            chat2Num.put('0', 0);
            chat2Num.put('1', 1);
            chat2Num.put('2', 2);
            chat2Num.put('3', 3);
            chat2Num.put('4', 4);
            chat2Num.put('5', 5);
            chat2Num.put('6', 6);
            chat2Num.put('7', 7);
            chat2Num.put('8', 8);
            chat2Num.put('9', 9);
            chat2Num.put('a', 10);
            chat2Num.put('b', 11);
            chat2Num.put('c', 12);
            chat2Num.put('d', 13);
            chat2Num.put('e', 14);
            chat2Num.put('f', 15);

            num2Char.put(0, '0');
            num2Char.put(1, '1');
            num2Char.put(2, '2');
            num2Char.put(3, '3');
            num2Char.put(4, '4');
            num2Char.put(5, '5');
            num2Char.put(6, '6');
            num2Char.put(7, '7');
            num2Char.put(8, '8');
            num2Char.put(9, '9');
            num2Char.put(10, 'a');
            num2Char.put(11, 'b');
            num2Char.put(12, 'c');
            num2Char.put(13, 'd');
            num2Char.put(14, 'e');
            num2Char.put(15, 'f');
        }

        public String addStrings(String num1, String num2) {
            if (num1 == null || num1.length() == 0) {
                return num2;
            }

            if (num2 == null || num2.length() == 0) {
                return num1;
            }

            StringBuffer sb = new StringBuffer();
            int p1 = num1.length() - 1;
            int p2 = num2.length() - 1;

            int pre = 0;
            while (p1 >= 0 || p2 >= 0) {
                int char1 = 0;
                if (p1 >= 0) {
                    char1 = num1.charAt(p1--) - '0';
                }

                int char2 = 0;
                if (p2 >= 0) {
                    char2 = num2.charAt(p2--) - '0';
                }

                int sum = char1 + char2 + pre;
                pre = 0;
                if (sum > 9) {
                    pre = sum / 10;
                    sum = sum - 10;
                }
                sb.append(sum);
            }
            if (pre != 0) {
                sb.append(pre);
            }

            return sb.reverse().toString();
        }


        public String addHex(String a, String b) {


            String res = "";

            int sumP = 0;
            int aP = a.length() - 1;
            int bP = b.length() - 1;

            while (aP >= 0 || bP >= 0) {
                int aChar = 0;
                if (aP >= 0) {
                    aChar = chat2Num.get(a.charAt(aP--));
                }
                int bChar = 0;
                if (bP >= 0) {
                    bChar = chat2Num.get(b.charAt(bP--));
                }

                int curr = sumP + aChar + bChar;
                sumP = curr / 16;
                curr = curr % 16;

                res = num2Char.get(curr) + res;
            }

            if (sumP > 0) {
                res = num2Char.get(sumP) + res;
            }

            return res;
        }
    }

}
