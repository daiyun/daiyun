package daiyun.leetcode.lcci;

import java.util.HashMap;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * <p>
 * 示例1:
 * <p>
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 * 示例2:
 * <p>
 * 输入：n = 5
 * 输出：13
 * 提示:
 * <p>
 * n范围在[1, 1000000]之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question0801 {

    public static void main(String[] args) {
        Question0801 question = new Question0801();

        Question0801.Solution solution = question.new Solution();

        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));

        System.out.println(Integer.MAX_VALUE);


        int t = Integer.parseUnsignedInt(Integer.toBinaryString(-1), 2);

        System.out.println(t);

    }


    class Solution {
        public int waysToStep(int n) {
            int[] res = new int[n + 1];
            if (n == 0) {
                return 1;
            }
            res[0] = 1;

            if (n == 1) {
                return 1;
            }
            res[1] = 1;

            if (n == 2) {
                return 2;
            }
            res[2] = 2;

            for (int i = 3; i <= n; i++) {
                res[i] = (res[i - 3] + (res[i - 2] + res[i - 1]) % 1000000007) % 1000000007;
            }

            return res[n];
        }
    }

}
