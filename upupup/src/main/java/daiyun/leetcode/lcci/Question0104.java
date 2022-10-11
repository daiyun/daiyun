package daiyun.leetcode.lcci;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * <p>
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * <p>
 * 回文串不一定是字典当中的单词。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 */
public class Question0104 {

    public static void main(String[] args) {
        Question0104 question = new Question0104();

        Question0104.Solution solution = question.new Solution();

//        "ds sdfs afs sdfa dfssf asdf             "
//        27

        System.out.println(solution.canPermutePalindrome("aabcaa"));
    }


    class Solution {
        public boolean canPermutePalindrome(String s) {
            if (s == null) {
                return false;
            }

            int len = s.length();
            int[] chars = new int[256];

            for (char c : s.toCharArray()) {
                if (chars[c] == 0) {
                    chars[c] = 1;
                } else {
                    chars[c] = chars[c] + 1;
                }
            }

            int singleSize = 0;

            for (int i : chars) {
                if (i % 2 == 1) {
                    singleSize++;
                    if (singleSize > (1 + len % 2)) {
                        return false;
                    }
                }
            }

            return true;

        }
    }
}
