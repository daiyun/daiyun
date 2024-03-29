package daiyun.leetcode.lcci;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class Question0107 {

    public static void main(String[] args) {
        Question0107 question = new Question0107();

        Question0107.Solution solution = question.new Solution();

//        "ds sdfs afs sdfa dfssf asdf             "
//        27

    }


    class Solution {
        public void rotate(int[][] matrix) {
            if (matrix == null) {
                return;
            }

            int N = matrix.length;

            for (int i = 0; i < N / 2; i++) {
                for (int j = i; j < N - 1 - i; j++) {
                    int pre = matrix[i][j];
                    matrix[i][j] = matrix[N - j - 1][i];
                    matrix[N - j - 1][i] = matrix[N - i - 1][N - j - 1];
                    matrix[N - i - 1][N - j - 1] = matrix[N - (N - j - 1) - 1][N - i - 1];
                    matrix[N - (N - j - 1) - 1][N - i - 1] = pre;
                }
            }

        }
    }
}
