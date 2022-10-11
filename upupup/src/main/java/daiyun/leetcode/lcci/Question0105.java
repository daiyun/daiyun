package daiyun.leetcode.lcci;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 */
public class Question0105 {

    public static void main(String[] args) {
        Question0105 question = new Question0105();

        Question0105.Solution solution = question.new Solution();

//        "ds sdfs afs sdfa dfssf asdf             "
//        27

        System.out.println(solution.oneEditAway("pale", "ple"));
    }


    class Solution {
        public boolean oneEditAway(String first, String second) {
            if (first == null && second == null) {
                return true;
            }

            if (first == null || second == null) {
                return false;
            }

            int lenFirst = first.length();
            int lenSecond = second.length();
            if (lenFirst == lenSecond) {
                return replaceChar(first, second);
            } else if (lenFirst > lenSecond) {
                return deleleChar(first, second);
            } else {
                return insertChar(first, second);
            }
        }

        public boolean replaceChar(String first, String second) {
            int size = 0;
            char[][] chars = new char[2][first.length()];
            chars[0] = first.toCharArray();
            chars[1] = second.toCharArray();

            for (int i = 0; i < first.length(); i++) {
                if (chars[0][i] != chars[1][i]) {
                    if (size > 0) {
                        return false;
                    }
                    size++;
                    chars[0][i] = chars[1][i];
                }
            }
            return new String(chars[0]).equals(new String(chars[1]));
        }

        public boolean deleleChar(String first, String second) {
            if (first.length() - second.length() > 1) {
                return false;
            }

            int size = 0;
            char[][] chars = new char[2][first.length()];
            chars[0] = first.toCharArray();
            System.arraycopy(second.toCharArray(), 0, chars[1], 0, second.length());

            for (int i = 0; i < first.length(); ) {
                if (chars[0][i] != chars[1][i]) {
                    if (size > 0) {
                        return false;
                    }
                    size++;
                    if (i + 1 < first.length()) {
                        System.arraycopy(chars[0], i + 1, chars[0], i, first.length() - i - 1);
                        chars[0][first.length() - 1] = 0;
                    } else {
                        chars[0][i] = 0;
                    }
                } else {
                    i++;
                }
            }
            return new String(chars[0]).trim().equals(new String(chars[1]).trim());

        }

        public boolean insertChar(String first, String second) {
            return deleleChar(second, first);
        }
    }
}
