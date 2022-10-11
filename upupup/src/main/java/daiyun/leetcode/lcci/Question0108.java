package daiyun.leetcode.lcci;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 示例 2：
 * <p>
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 */
public class Question0108 {

    public static void main(String[] args) {
        Question0108 question = new Question0108();

        Question0108.Solution solution = question.new Solution();

//        "ds sdfs afs sdfa dfssf asdf             "
//        27

    }


    class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix == null) {
                return;
            }

            int x = matrix.length;
            if (matrix[0] == null) {
                return;
            }
            int y = matrix[0].length;


            boolean[] countX = new boolean[x];
            boolean[] countY = new boolean[y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (matrix[i][j] == 0) {
                        countX[i] = true;
                        countY[j] = true;
                    }
                }
            }

            for (int i = 0; i < x; i++) {
                if (countX[i]) {
                    for (int j = 0; j < y; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < y; i++) {
                if (countY[i]) {
                    for (int j = 0; j < x; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }
    }
}
