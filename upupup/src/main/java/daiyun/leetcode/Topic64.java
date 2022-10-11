package daiyun.leetcode;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，
 * 使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class Topic64 {

    public static void main(String[] args) {

        Topic64 topic1 = new Topic64();

        Solution solution = topic1.new Solution();

        int res = solution.minPathSum(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}

        });

        System.out.println(res);
    }


    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }
            int[][] dp = new int[grid.length][grid[0].length];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    int up = Integer.MAX_VALUE;
                    if (i > 0) {
                        up = dp[i - 1][j];
                    }
                    int left = Integer.MAX_VALUE;
                    if (j > 0) {
                        left = dp[i][j - 1];
                    }
                    if (i == 0 && j == 0) {
                        up = 0;
                        left = 0;
                    }
                    dp[i][j] = Math.min(up, left) + grid[i][j];
                }
            }

            return dp[grid.length - 1][grid[0].length - 1];
        }
    }

}
