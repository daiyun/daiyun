package daiyun.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 * <p>
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class Topic73 {

    public static void main(String[] args) {

        Topic73 topic1 = new Topic73();

        Solution solution = topic1.new Solution();

        solution.setZeroes(new int[][]{
                {1, 2, 3}, {1, 0, 1}, {1, 2, 2}
        });
        System.out.println();
    }


    class Solution {
        public void setZeroes(int[][] matrix) {

            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return;
            }

            Set<Integer> rowIndex = new HashSet<>();
            Set<Integer> lowIndex = new HashSet<>();

            int row = matrix.length;
            int low = matrix[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < low; j++) {
                    if (matrix[i][j] == 0) {
                        rowIndex.add(i);
                        lowIndex.add(j);
                    }
                }
            }

            for (Integer i : rowIndex) {
                for (int j = 0; j < low; j++) {
                    matrix[i][j] = 0;
                }
            }

            for (Integer i : lowIndex) {
                for (int j = 0; j < row; j++) {
                    matrix[j][i] = 0;
                }
            }


        }
    }


}
