package daiyun.leetcode;

import java.math.BigInteger;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 */
public class Topic62 {

    public static void main(String[] args) {

        Topic62 topic1 = new Topic62();

        Solution solution = topic1.new Solution();

        int res = solution.uniquePaths(36, 7);

        System.out.println(res);
    }

    class Solution {
        public int uniquePaths(int m, int n) {
            if (m <= 0 || n <= 0) {
                return 0;
            }


            int p = m + n - 2;

            /*BigInteger ans = new BigInteger(new Long(1).longValue());

            for (int i = p; i > p - (m - 1); i--) {
                ans = ans * i;
            }

            BigInteger temp = new BigInteger(1L);
            for (int j = 1; j <= m - 1; j++) {
                temp = temp * j;
            }*/

//            return (int) (ans.divide(temp).longValue());
            return 0;
        }
    }

    class SolutionA {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];

            for (int i = 0; i < n; i++) dp[0][i] = 1;
            for (int i = 0; i < m; i++) dp[i][0] = 1;

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }

    }

    class SolutionB {
        public int uniquePaths(int m, int n) {
            int S = m + n - 2;
            int D = n - 1;
            long  res = 1;
            for(int i = 1;i <= D;i++){
                res = res * (S - D + i) / i;
            }
            return (int)res;
        }
    }


}
