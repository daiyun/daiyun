package daiyun.leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class Topic63 {

    public static void main(String[] args) {

        Topic63 topic1 = new Topic63();

        Solution solution = topic1.new Solution();

        int res = solution.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}

        });

        System.out.println(res);
    }


    class Solution {

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            if (obstacleGrid == null
                    || obstacleGrid.length == 0
                    || obstacleGrid[0] == null
                    || obstacleGrid[0].length == 0) {
                return 0;
            }

            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            int[][] res = new int[m][n];

            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][0] == 0) {
                    res[i][0] = 1;
                } else {
                    break;
                }
            }

            for (int j = 0; j < n; j++) {
                if (obstacleGrid[0][j] == 0) {
                    res[0][j] = 1;
                } else {
                    break;
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 0) {
                        res[i][j] = res[i][j - 1] + res[i - 1][j];
                    }
                }
            }
            return res[m - 1][n - 1];
        }

    }


    class SolutionA {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid == null) {
                return 0;
            }

            int x = obstacleGrid.length;
            if (obstacleGrid[0] == null) {
                return 0;
            }
            int y = obstacleGrid[0].length;

            int[][] dp = new int[x + 1][y + 1];

            for (int i = 0; i < x && obstacleGrid[i][0] != 1; i++) {
                dp[i + 1][1] = 1;
            }

            for (int i = 0; i < y && obstacleGrid[0][i] != 1; i++) {
                dp[1][i + 1] = 1;
            }

            for (int i = 1; i < x; i++) {
                for (int j = 1; j < y; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i + 1][j + 1] = 0;
                    } else {
                        dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j];
                    }
                }
            }

            return dp[x][y];
        }
    }

}
