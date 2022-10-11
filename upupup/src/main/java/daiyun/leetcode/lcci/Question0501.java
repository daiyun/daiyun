package daiyun.leetcode.lcci;

/**
 * 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，
 * 使得M从N的第j位开始，到第i位结束。假定从j位到i位足以容纳M，也即若M = 10 011，
 * 那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
 * <p>
 * 示例1:
 * <p>
 * 输入：N = 10000000000, M = 10011, i = 2, j = 6
 * 输出：N = 10001001100
 * 示例2:
 * <p>
 * 输入： N = 0, M = 11111, i = 0, j = 4
 * 输出：N = 11111
 */
public class Question0501 {

    public static void main(String[] args) {
        Question0501 question = new Question0501();

        Question0501.Solution solution = question.new Solution();

//        1143207437
//        1017033
//        11
//        31
   /*     int j = 2;
        int i = 1;
        int a = 17;
        int b = 17 >> (j + 1);
        System.out.println(b);
        b = b << j;
        System.out.println(b);
        b = b + 3;
        System.out.println(b);
        b = b << 1;
        System.out.println(b);
        b = b + 1;
        System.out.println(b);
*/

        System.out.println(17 & 3);

        int res = solution.insertBits(17, 3, 1, 2);

        System.out.println(res);

//        System.out.println(solution.insertBits());

    }


    class Solution {
        public int insertBits(int N, int M, int i, int j) {
            int a = N & ((1 << i) - 1);
            N = N >> (j + 1);
            N = N << (j - i + 1);
            N = M + N;
            N = N << i;
            return N + a;
        }
    }

}
