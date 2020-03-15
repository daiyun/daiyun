package daiyun.leetcode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 */
public class Topic6 {

    public static void main(String[] args) {

        Topic6 topic1 = new Topic6();

        Solution solution = topic1.new Solution();

        System.out.println(solution.convert("LEETCODEISHIRING", 3));

    }


    class Solution {
        public String convert(String s, int numRows) {
            StringBuffer sb = new StringBuffer();
            if (numRows == 1) {
                return s;
            }
            int gap = numRows * 2 - 2;

            for (int i = 0; i < numRows; i++) {

                for (int j = 0; j <= (s.length() / gap) + 1; j++) {

                    int p = i + j * gap;
                    int e = (j + 1) * gap;

                    while (p < e && p < s.length()) {
                        sb.append(s.charAt(p));
                        if((numRows * 2 - 2 - i - i) != 0){
                            p = p + (numRows * 2 - 2 - i - i);
                        }else{
                            break;
                        }
                    }
                }
            }

            return sb.toString();
        }
    }


}
