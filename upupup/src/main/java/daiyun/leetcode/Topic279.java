package daiyun.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class Topic279 {

    public static void main(String[] args) {

        Topic279 topic1 = new Topic279();

        Solution solution = topic1.new Solution();

        long start = System.currentTimeMillis();

        System.out.println(solution.numSquares(13));

        System.out.println(System.currentTimeMillis() - start);
    }

    class Solution {
        public int numSquares(int n) {
            if (n == 0) {
                return 0;
            }

            int a = (int) Math.sqrt(n);

            int sqr = a * a;
            if (n % sqr == 0) {
                return n / sqr;
            }

            int numSize = Integer.MAX_VALUE;
            while (a > 0) {
                int num = n / (a * a);
                int next = numSquares(n - (a * a) * num) + num;
                numSize = Math.min(numSize, next);
                a--;
            }

            return numSize;
        }
    }

}
