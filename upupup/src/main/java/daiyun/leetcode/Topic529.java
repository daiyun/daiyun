package daiyun.leetcode;

import java.util.HashMap;

/**
 * 让我们一起来玩扫雷游戏！
 * <p>
 * 给定一个代表游戏板的二维字符矩阵。
 *  'M' 代表一个未挖出的地雷，
 * 'E' 代表一个未挖出的空方块，
 * 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，
 * 数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，
 * 'X' 则表示一个已挖出的地雷。
 * <p>
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * <p>
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * <p>
 * [['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'M', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E']]
 * <p>
 * Click : [3,0]
 * <p>
 * 输出:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * 解释:
 * <p>
 * 示例 2：
 * <p>
 * 输入:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * Click : [1,2]
 * <p>
 * 输出:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'X', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * 解释:
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * 输入矩阵的宽和高的范围为 [1,50]。
 * 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
 * 输入面板不会是游戏结束的状态（即有地雷已被挖出）。
 * 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minesweeper
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic529 {

    public static void main(String[] args) {

        Topic529 topic1 = new Topic529();

        Solution solution = topic1.new Solution();


        int[] box = {3, 8, 8, 5, 5, 3, 9, 2, 4, 4, 6, 5, 8, 4, 8, 6, 9, 6, 2, 8, 6, 4, 1, 9, 5, 3, 10, 5, 3, 3, 9, 8, 8, 6, 5, 3, 7, 4, 9, 6, 3, 9, 4, 3, 5, 10, 7, 6, 10, 7};


        System.out.println();
    }

    class Solution {
        public char[][] updateBoard(char[][] board, int[] click) {

            if (click != null && click.length >= 2) {
                for (int i = 0; i < click.length; i += 2) {
                    int x = click[i];
                    int y = click[i + 1];

                    char c = board[x][y];
                    if ('M' == c) {
                        board[x][y] = 'X';
                        break;
                    } else if ('E' == c) {
                        updateBoardB(board, x, y);
                    }
                }
            }

            return board;
        }

        public int updateBoardB(char[][] board, int x, int y) {
            int size = 0;
            if (x > 0 && y > 0 && board[x - 1][y - 1] == 'M') {
                size++;
            }

            if (x > 0 && board[x - 1][y] == 'M') {
                size++;
            }

            if (x > 0 && y < board[0].length - 1 && board[x - 1][y + 1] == 'M') {
                size++;
            }

            if (y > 0 && board[x][y - 1] == 'M') {
                size++;
            }

            if (y < board[0].length - 1 && board[x][y + 1] == 'M') {
                size++;
            }

            if (x < board.length - 1 && y > 0 && board[x + 1][y - 1] == 'M') {
                size++;
            }

            if (x < board.length - 1 && board[x + 1][y] == 'M') {
                size++;
            }

            if (x < board.length - 1 && y < board[0].length - 1 && board[x + 1][y + 1] == 'M') {
                size++;
            }

            if (size == 0) {
                board[x][y] = 'B';

                if (x > 0 && y > 0 && board[x - 1][y - 1] == 'E') {
                    updateBoardB(board, x - 1, y - 1);
                }

                if (x > 0 && board[x - 1][y] == 'E') {
                    updateBoardB(board, x - 1, y);
                }

                if (x > 0 && y < board[0].length - 1 && board[x - 1][y + 1] == 'E') {
                    updateBoardB(board, x - 1, y + 1);
                }

                if (y > 0 && board[x][y - 1] == 'E') {
                    updateBoardB(board, x, y - 1);
                }

                if (y < board[0].length - 1 && board[x][y + 1] == 'E') {
                    updateBoardB(board, x, y + 1);
                }

                if (x < board.length - 1 && y > 0 && board[x + 1][y - 1] == 'E') {
                    updateBoardB(board, x + 1, y - 1);
                }

                if (x < board.length - 1 && board[x + 1][y] == 'E') {
                    updateBoardB(board, x + 1, y);
                }

                if (x < board.length - 1 && y < board[0].length - 1 && board[x + 1][y + 1] == 'E') {
                    updateBoardB(board, x + 1, y + 1);
                }
            } else {
                board[x][y] = (char) (size + '0');
            }
            return size;
        }
    }
}
