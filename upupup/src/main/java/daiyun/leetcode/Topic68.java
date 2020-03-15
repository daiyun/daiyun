package daiyun.leetcode;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Topic68 {

    public static void main(String[] args) {

        Topic68 topic1 = new Topic68();

        Solution solution = topic1.new Solution();


        System.out.println(solution.climbStairs(0));
    }


    class Solution {
        public int climbStairs(int n) {
            if (n <= 1) {
                return n;
            }

            int res = 1;

            int k = 1;
            while (2 * k <= n) {
                int allStep = k + n - (2 * k);
                res += uniquePaths(allStep, k);
                k++;
            }

            return res;
        }

        public int uniquePaths(int m, int n) {

            long res = 1;
            for (int i = 1; i <= n; i++) {
                res = res * (m - i + 1) / i;
            }
            return (int) res;
        }
    }

    class SolutionA {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }


}
