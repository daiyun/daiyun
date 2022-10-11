package daiyun.leetcode.lcci;

/**
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 * 输出：2
 * 示例2:
 * <p>
 * 输入：A = 1，B = 2
 * 输出：2
 * 提示:
 * <p>
 * A，B范围在[-2147483648, 2147483647]之间
 */
public class Question0506 {

    public static void main(String[] args) {
        Question0506 question = new Question0506();

        Question0506.Solution solution = question.new Solution();

//        1143207437
//        1017033
//        11
//        31

        int a = solution.convertInteger(1, 8364);

        System.out.println(a);

        System.out.println(1^3);

//        System.out.println(Integer.parseInt("2", 2));


    }


    class Solution {
        public int convertInteger(int A, int B) {
            String aBit = Integer.toBinaryString(A);
            String bBit = Integer.toBinaryString(B);

            int aLength = aBit.length() - 1;
            int bLength = bBit.length() - 1;

            int size = 0;
            while (aLength >= 0 || bLength >= 0) {
                if (aLength >= 0 && bLength >= 0) {
                    if (aBit.charAt(aLength) != bBit.charAt(bLength)) {
                        size++;
                    }
                } else {
                    if (aLength >= 0 && aBit.charAt(aLength) != '0') {
                        size++;
                    }

                    if (bLength >= 0 && bBit.charAt(bLength) != '0') {
                        size++;
                    }
                }

                aLength--;
                bLength--;
            }

            return size;
        }
    }

}
