package daiyun.leetcode;


/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class Topic200 {

    public static void main(String[] args) {

        Topic200 topic1 = new Topic200();

        Solution solution = topic1.new Solution();

//        solution.numIslands(new char[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}});
    }


    class Solution {
        public int numIslands(char[][] grid) {
            int islandCount = 0;

            if (grid == null || grid.length == 0) {
                return islandCount;
            }

            if (grid[0] == null || grid[0].length == 0) {
                return islandCount;
            }

            int M = grid.length;
            int N = grid[0].length;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == '1') {
                        islandCount++;
                        grid[i][j] = '2';
                        isConnect(grid, i, j);
                    }
                }
            }
            return islandCount;
        }

        public void isConnect(char[][] grid, int i, int j) {

            if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                grid[i + 1][j] = '2';
                isConnect(grid, i + 1, j);
            }

            if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                grid[i][j + 1] = '2';
                isConnect(grid, i, j + 1);
            }

            if (j > 0 && grid[i][j - 1] == '1') {
                grid[i][j - 1] = '2';
                isConnect(grid, i, j - 1);
            }

            if (i > 0 && grid[i - 1][j] == '1') {
                grid[i - 1][j] = '2';
                isConnect(grid, i - 1, j);
            }
        }
    }
}
