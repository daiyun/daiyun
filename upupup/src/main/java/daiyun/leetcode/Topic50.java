package daiyun.leetcode;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class Topic50 {

    public static void main(String[] args) {

        Topic50 topic1 = new Topic50();

        Solution solution = topic1.new Solution();

        double res = solution.myPow(2, 10);

        System.out.println();
    }

    class Solution {
        public double myPow(double x, int n) {

            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return x;
            }

            if (n == -1) {
                return 1 / x;
            }

            int a = Math.abs(n);
            double b = 0;
            if (a % 2 == 0) {
                b = myPow(x, n / 2);
                b = b * b;

            } else {
                b = x * myPow(x, n - 1);
            }

            if (n < 0) {
                return 1.0 / b;
            }
            return b;
        }
    }

}
