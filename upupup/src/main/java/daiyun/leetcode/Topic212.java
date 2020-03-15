package daiyun.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 */
public class Topic212 {

    public static void main(String[] args) {

        Topic212 topic1 = new Topic212();

        Solution solution = topic1.new Solution();

        List<String> res = solution.findWords(new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}

        }, new String[]{"eat", "oath"});

        long start = System.currentTimeMillis();
        System.out.println(res);
        System.out.println(System.currentTimeMillis() - start);
    }

    class Solution {
        public List<String> findWords(char[][] board, String[] words) {

            List<String> res = new ArrayList<>();
            if (words == null) {
                return res;
            }

            for (String str : words) {
                if (exist(board, str)) {
                    res.add(str);
                }
            }

            return res;
        }

        public boolean exist(char[][] board, String word) {
            if (board == null) {
                return false;
            }
            if (board.length == 0 && word == null) {
                return true;
            }
            if (word == null) {
                return false;
            }

            if (word.length() == 0) {
                return true;
            }


            int x = board.length;
            int y = board[0].length;

            char start = word.charAt(0);

            boolean[][] used = new boolean[board.length][board[0].length];

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    char ch = board[i][j];
                    if (ch == start) {

                        if (doCheck(used, board, i, j, word, 0)) {
                            return true;
                        }
                        used[i][j] = false;
                    }
                }
            }


            return false;
        }

        public boolean doCheck(boolean[][] used, char[][] board, int i, int j, String word, int index) {


            if (i >= board.length ||
                    i < 0 ||
                    j >= board[0].length ||
                    j < 0 ||

                    index >= word.length() ||
                    used[i][j] ||

                    board[i][j] != word.charAt(index)) {

                return false;
            }

            if (index == word.length() - 1) {
                return true;
            }

            used[i][j] = true;

            if (doCheck(used, board, i + 1, j, word, index + 1) ||
                    doCheck(used, board, i - 1, j, word, index + 1) ||
                    doCheck(used, board, i, j + 1, word, index + 1) ||
                    doCheck(used, board, i, j - 1, word, index + 1)) {

                return true;
            }

            used[i][j] = false;

            return false;
        }
    }

}
