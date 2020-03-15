package daiyun.leetcode;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，
 * 如果除法结果溢出，则返回 231 − 1。
 */
public class Topic29 {

    public static void main(String[] args) {

        Topic29 topic1 = new Topic29();

        Solution solution = topic1.new Solution();

        System.out.println(solution.divide(10, -2));
    }

    class Solution {
        public int divide(int dividend, int divisor) {
            if (Math.abs(dividend) < Math.abs(divisor)) {
                return 0;
            }

            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }

            int flag = -1;
            if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
                flag = 1;
            }

            int d = divisor;

            int pre = 1;
            while (Math.abs(dividend) > Math.abs(d << 1)) {
                pre = pre << 1;
                d = d << 1;
            }

            return flag * pre + divide(dividend - flag * d, divisor);

        }
    }

    class SolutionA {
        public int divide(int dividend, int divisor) {
            if (Math.abs(dividend) < Math.abs(divisor)) {
                return 0;
            }

            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }

            int flag = -1;
            if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
                flag = 1;
            }

            int ans = 0;
            while (Math.abs(dividend) >= Math.abs(divisor)) {
                int curAns = 1;
                int temp = divisor;
                while (Math.abs(dividend) >= Math.abs(temp << 1)) {
                    temp = temp << 1;
                    curAns = curAns << 1;
                }
                dividend = dividend - flag * temp;
                ans = ans + curAns * flag;
            }
            return ans * flag;
        }
    }
}
