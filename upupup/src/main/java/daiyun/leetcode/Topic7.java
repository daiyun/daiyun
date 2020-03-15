package daiyun.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Topic7 {

    public static void main(String[] args) {

        Topic7 topic1 = new Topic7();

        Solution solution = topic1.new Solution();


        System.out.println(solution.reverse(Integer.MIN_VALUE));
    }


    class Solution {
        public int reverse(int x) {
            int ans = 0;

            while (x != 0) {
                int residual = x % 10;
                if (ans > Integer.MAX_VALUE / 10
                        || (ans == Integer.MAX_VALUE / 10 && residual > 7)) {

                    ans = 0;
                    break;
                }
                if (ans < Integer.MIN_VALUE / 10
                        || (ans == Integer.MIN_VALUE / 10 && residual < -8)) {

                    ans = 0;
                    break;
                }
                ans = ans * 10 + residual;
                x = x / 10;
            }

            return ans;
        }
    }


}
