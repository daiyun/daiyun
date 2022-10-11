package daiyun.leetcode.lcci;

/**
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 * <p>
 * 示例1:
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出 1 (或者 0b01)
 * 示例2:
 * <p>
 * 输入：num = 3
 * 输出：3
 * 提示:
 * <p>
 * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 */
public class Question0507 {

    public static void main(String[] args) {
        Question0507 question = new Question0507();

        Question0507.Solution solution = question.new Solution();

//        1143207437
//        1017033
//        11
//        31

        int a = solution.exchangeBits(8364);

        System.out.println(a);

        System.out.println(1 ^ 3);

//        System.out.println(Integer.parseInt("2", 2));


    }


    class Solution {
        public int exchangeBits(int num) {

            if (num == 0) {
                return 0;
            }

            int bitSize = 0;
            StringBuffer sb = new StringBuffer();
            while (num != 0) {
                sb.append(num % 2);
                num = num >> 1;
                bitSize++;
                if (bitSize % 2 == 0) {
                    char a = sb.charAt(bitSize - 1);
                    sb.setCharAt(bitSize - 1, sb.charAt(bitSize - 2));
                    sb.setCharAt(bitSize - 2, a);
                }
            }
            if (bitSize % 2 == 1) {
                sb.append('1');
                sb.setCharAt(bitSize - 2, '0');
            }

            return Integer.parseInt(sb.reverse().toString(), 2);
        }
    }

    class SolutionA {
        public int exchangeBits(int num) {
            if (num == 0) {
                return 0;
            }

            int odd = num & 0x55555555;
            int even = num & 0xaaaaaaaa;

            odd = odd << 1;
            even = even >>> 1;

            return odd | even;
        }
    }

}
