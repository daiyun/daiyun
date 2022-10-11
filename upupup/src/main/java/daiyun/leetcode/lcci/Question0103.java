package daiyun.leetcode.lcci;

/**
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 * 示例1:
 * <p>
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * 示例2:
 * <p>
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 * 提示：
 * <p>
 * 字符串长度在[0, 500000]范围内。
 */
public class Question0103 {

    public static void main(String[] args) {
        Question0103 question = new Question0103();

        Question0103.Solution solution = question.new Solution();

//        "ds sdfs afs sdfa dfssf asdf             "
//        27

        System.out.println(solution.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27));
    }


    class Solution {
        public String replaceSpaces(String S, int length) {
            if (S == null) {
                return null;
            }

            char[] characters = S.toCharArray();

            int charIndex = 0;
            int index = 0;
            while (charIndex < length) {
                char c = characters[index];

                if (' ' == c) {

                    if (index < characters.length - 3) {
                        System.arraycopy(characters, index + 1,
                                characters, index + 3, length - charIndex - 1);
                    }

                    characters[index++] = '%';
                    characters[index++] = '2';
                    characters[index++] = '0';
                } else {
                    index++;
                }
                charIndex++;

            }

            return new String(characters).trim();
        }
    }
}
