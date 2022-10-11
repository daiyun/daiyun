package daiyun.leetcode;


import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic130 {

    public static void main(String[] args) {

        Topic130 topic1 = new Topic130();

        Solution solution = topic1.new Solution();

//        solution.numIslands(new char[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}});
    }


    class Solution {
        public void solve(char[][] board) {

            if (board == null || board.length == 0) {
                return;
            }

            if (board[0] == null || board[0].length == 0) {
                return;
            }

            int M = board.length;
            int N = board[0].length;

            Set<String> all = new HashSet<>();
            for (int i = 1; i < M - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    if (board[i][j] == 'O' && !all.contains(i + "-" + j)) {
                        Set<String> track = new HashSet<>();
                        if (isConnect(board, i, j, track)) {
                            for (String k : track) {
                                String[] info = k.split("-");
                                board[Integer.parseInt(info[0])][Integer.parseInt(info[1])] = 'X';
                            }
                        }
                        all.addAll(track);
                    }
                }
            }
        }

        public boolean isConnect(char[][] grid, int i, int j, Set<String> track) {
            track.add(i + "-" + j);

            boolean res = true;
            if (i + 1 < grid.length) {
                if (!track.contains((i + 1) + "-" + j)) {
                    if (grid[i + 1][j] == 'O') {
                        res = isConnect(grid, i + 1, j, track);
                    }
                }
            } else {
                res = false;
            }

            if (res && j + 1 < grid[0].length) {
                if (!track.contains(i + "-" + (j + 1))) {
                    if (grid[i][j + 1] == 'O') {
                        res = isConnect(grid, i, j + 1, track);
                    }
                }
            } else {
                res = false;
            }

            if (res && j > 0) {
                if (!track.contains(i + "-" + (j - 1))) {
                    if (grid[i][j - 1] == 'O') {
                        res = isConnect(grid, i, j - 1, track);
                    }
                }
            } else {
                res = false;
            }

            if (res && i > 0) {
                if (!track.contains((i - 1) + "-" + j)) {
                    if (grid[i - 1][j] == 'O') {
                        res = isConnect(grid, i - 1, j, track);
                    }
                }
            } else {
                res = false;
            }

            return res;
        }
    }
}
