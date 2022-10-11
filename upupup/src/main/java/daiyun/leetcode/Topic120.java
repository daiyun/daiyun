package daiyun.leetcode;


import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 *  
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Topic120 {

    public static void main(String[] args) {

        Topic120 topic1 = new Topic120();

        Solution solution = topic1.new Solution();

        long start = System.currentTimeMillis();


        System.out.println(System.currentTimeMillis() - start);
    }


    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() < 1) {
                return 0;
            }

            int M = triangle.size();
            int N = triangle.get(M - 1).size();
            int[][] dp = new int[M][N];

            for (int i = M - 1; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {

                    if (j >= triangle.get(i).size()) {
                        dp[i][j] = Integer.MAX_VALUE;
                        continue;
                    }

                    int right = 0;
                    int down = 0;
                    if (i + 1 < M) {
                        down = dp[i + 1][j];
                        if (j + 1 < N) {
                            right = dp[i + 1][j + 1];
                        }
                    }

                    dp[i][j] = triangle.get(i).get(j) + Math.min(down, right);
                }
            }

            return dp[0][0];
        }
    }
}
