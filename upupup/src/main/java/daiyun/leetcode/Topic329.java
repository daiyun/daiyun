package daiyun.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 * <p>
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 */
public class Topic329 {

    public static void main(String[] args) {

        Topic329 topic1 = new Topic329();

        Solution solution = topic1.new Solution();

        long start = System.currentTimeMillis();
        int[][] a = {
                {0,1,2,3,4,5,6,7,8,9},
                {19,18,17,16,15,14,13,12,11,10},
                {20,21,22,23,24,25,26,27,28,29},
                {39,38,37,36,35,34,33,32,31,30},
                {40,41,42,43,44,45,46,47,48,49},
                {59,58,57,56,55,54,53,52,51,50},
                {60,61,62,63,64,65,66,67,68,69},
                {79,78,77,76,75,74,73,72,71,70},
                {80,81,82,83,84,85,86,87,88,89},
                {99,98,97,96,95,94,93,92,91,90},
                {100,101,102,103,104,105,106,107,108,109},
                {119,118,117,116,115,114,113,112,111,110},
                {120,121,122,123,124,125,126,127,128,129},
                {139,138,137,136,135,134,133,132,131,130},
                {0,0,0,0,0,0,0,0,0,0}
        };


        int res = solution.longestIncreasingPath(a);

        System.out.println(res);

        System.out.println(System.currentTimeMillis()-start);
//        {1,21,2,3}

    }

    class Solution {

        public int longestIncreasingPath(int[][] matrix) {

            if (matrix == null || matrix.length == 0) {
                return 0;
            }

            if (matrix[0] == null || matrix[0].length == 0) {
                return 0;
            }

            int M = matrix.length;
            int N = matrix[0].length;

            int max = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    int down = largerRoot(matrix, i, j);
                    if (down > max) {
                        max = down;
                    }
                }
            }

            return max;
        }


        Map<String, Integer> set = new HashMap<>();

        public int largerRoot(int[][] matrix, int i, int j) {
            if (set.containsKey(i + "-" + j)) {
                return set.get(i + "-" + j);
            }

            int right = 0;
            if (j + 1 < matrix[0].length && matrix[i][j] > matrix[i][j + 1]) {
                right = largerRoot(matrix, i, j + 1);
            }

            int down = 0;
            if (i + 1 < matrix.length && matrix[i][j] > matrix[i + 1][j]) {
                down = largerRoot(matrix, i + 1, j);
            }

            int left = 0;
            if (j > 0 && matrix[i][j] > matrix[i][j - 1]) {
                left = largerRoot(matrix, i, j - 1);
            }

            int up = 0;
            if (i > 0 && matrix[i][j] > matrix[i - 1][j]) {
                up = largerRoot(matrix, i - 1, j);
            }
            int k = (Math.max(Math.max(right, left), Math.max(down, up)) + 1);

            set.put(i + "-" + j, k);
            return k;
        }
    }
}
