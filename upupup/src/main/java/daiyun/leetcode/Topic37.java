package daiyun.leetcode;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * <p>
 * 一个数独。
 * <p>
 * <p>
 * <p>
 * 答案被标成红色。
 * <p>
 * Note:
 * <p>
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 */
public class Topic37 {

    public static void main(String[] args) {

        Topic37 topic1 = new Topic37();

        Solution solution = topic1.new Solution();

        char[][] arr = new char[9][9];


        arr[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        arr[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        arr[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        arr[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        arr[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        arr[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        arr[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        arr[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        arr[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};


        solution.solveSudoku(arr);

        System.out.println();
    }


    class Solution {

        char[][] board;
        int[][] rowCount = new int[9][10];
        int[][] colowCount = new int[9][10];
        int[][] boxCount = new int[9][10];

        boolean res = false;

        public void solveSudoku(char[][] board) {

            this.board = board;
            int N = board.length;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] != '.') {
                        char temp = board[i][j];
                        int p = temp - '0';
                        rowCount[i][p]++;
                        colowCount[j][p]++;
                        boxCount[3 * (i / 3) + (j / 3)][p]++;
                    }
                }
            }
            doPlace(0, 0);
        }

        public boolean canAdd(int row, int col, int a) {
            if (rowCount[row][a] > 0) {
                return false;
            }

            if (colowCount[col][a] > 0) {
                return false;
            }

            if (boxCount[3 * (row / 3) + (col / 3)][a] > 0) {
                return false;
            }

            return true;
        }

        public void addToPlace(int row, int col, int a) {
            board[row][col] = (char) (a + '0');
            rowCount[row][a]++;
            colowCount[col][a]++;
            boxCount[3 * (row / 3) + (col / 3)][a]++;
        }

        public void delPlace(int row, int col, int a) {
            board[row][col] = '.';
            rowCount[row][a]--;
            colowCount[col][a]--;
            boxCount[3 * (row / 3) + (col / 3)][a]--;
        }

        public void doPlace(int row, int col) {
            if (board[row][col] != '.') {
                placeNextNumbers(row, col);
            } else {
                for (int i = 1; i < 10; i++) {
                    if (canAdd(row, col, i)) {
                        addToPlace(row, col, i);
                        placeNextNumbers(row, col);

                        if (!res) {
                            delPlace(row, col, i);
                        }
                    }
                }
            }
        }

        public void placeNextNumbers(int row, int col) {
            if (row == 8 && col == 8) {
                res = true;
            } else {
                if (col == 8) {
                    doPlace(row + 1, 0);
                } else {
                    doPlace(row, col + 1);
                }
            }
        }
    }
}
