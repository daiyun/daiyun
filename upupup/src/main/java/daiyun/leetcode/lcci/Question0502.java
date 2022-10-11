package daiyun.leetcode.lcci;

/**
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
 * 如果该数字不在0和1之间，或者无法精确地用32位以内的二进制表示，则打印“ERROR”。
 * <p>
 * 示例1:
 * <p>
 * 输入：0.625
 * 输出："0.101"
 * 示例2:
 * <p>
 * 输入：0.1
 * 输出："ERROR"
 * 提示：0.1无法被二进制准确表示
 * 提示：
 * <p>
 * 32位包括输出中的"0."这两位。
 */
public class Question0502 {

    public static void main(String[] args) {
        Question0502 question = new Question0502();

        Question0502.Solution solution = question.new Solution();

//        1143207437
//        1017033
//        11
//        31


        System.out.println(0.00000d == 0.0);

//        System.out.println(solution.insertBits());

    }


    class Solution {
        public String printBin(double num) {

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("0.");

            while (num != 0) {
                num = num * 2;
                if (num >= 1) {
                    stringBuffer.append(1);
                    num = num - 1;
                } else {
                    stringBuffer.append(0);
                }
                if (stringBuffer.length() >= 32) {
                    return "ERROR";
                }
            }

            return stringBuffer.toString();
        }
    }

}
