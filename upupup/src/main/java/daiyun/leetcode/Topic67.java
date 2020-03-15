package daiyun.leetcode;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class Topic67 {

    public static void main(String[] args) {

        Topic67 topic1 = new Topic67();

        Solution solution = topic1.new Solution();

        int res = solution.mySqrt(1);

        System.out.println(res);
    }


    class Solution {
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            if (x == 1) {
                return 1;
            }

            long start = 0;
            long end = x / 2;
            while (start < end) {
                long mid = (start + end + 1) >>> 1;
                long square = mid * mid;
                if (square > x) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            }

            return (int) start;

        }
    }


}
