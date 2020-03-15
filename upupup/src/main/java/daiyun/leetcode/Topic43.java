package daiyun.leetcode;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Topic43 {

    public static void main(String[] args) {

        Topic43 topic1 = new Topic43();

        Solution solution = topic1.new Solution();

        String str = solution.multiply("123", "456");

        System.out.println(str);
    }


    class Solution {
        public String multiply(String num1, String num2) {
            int len1 = num1.length();
            int len2 = num2.length();

            int oneBitMaxLength = Math.max(len1, len2);
            int[][] allRes = new int[len2][oneBitMaxLength * 2];

            for (int i = len2 - 1; i >= 0; i--) {
                int a = num2.charAt(i) - '0';
                int carry = 0;
                for (int j = len1 - 1; j >= 0; j--) {
                    int b = num1.charAt(j) - '0';
                    if (a * b + carry > 10) {
                        allRes[i][(len1 - 1 - j) + (len2 - 1 - i)] = (a * b + carry) % 10;
                        carry = (a * b + carry) / 10;
                    } else {
                        allRes[i][(len1 - 1 - j) + (len2 - 1 - i)] = (a * b + carry);
                        carry = 0;
                    }
                }
            }

            int[] ans = new int[oneBitMaxLength * 2 + 1];

            int carry = 0;
            for (int i = 0; i < oneBitMaxLength * 2; i++) {

                int all = carry;
                for (int j = 0; j < len2; j++) {
                    all += allRes[j][i];
                }
                ans[i] = (all % 10);
                carry = all / 10;
            }
            if (carry > 0) {
                ans[oneBitMaxLength * 2] = carry;
            }

            String str = "";
            boolean isOk = false;
            for (int i = oneBitMaxLength * 2; i >= 0; i--) {
                if (!isOk && ans[i] == 0) {
                    continue;
                }
                isOk = true;
                str = str + ans[i];
            }

            return str;


        }
    }
}
