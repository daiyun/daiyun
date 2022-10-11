package daiyun.leetcode.lcci;

/**
 * 绘制直线。有个单色屏幕存储在一个一维数组中，使得32个连续像素可以存放在一个 int 里。屏幕宽度为w，
 * 且w可被32整除（即一个 int 不会分布在两行上），屏幕高度可由数组长度及屏幕宽度推算得出。
 * 请实现一个函数，绘制从点(x1, y)到点(x2, y)的水平线。
 * <p>
 * 给出数组的长度 length，宽度 w（以比特为单位）、直线开始位置 x1（比特为单位）、
 * 直线结束位置 x2（比特为单位）、直线所在行数 y。返回绘制过后的数组。
 * <p>
 * 示例1:
 * <p>
 * 输入：length = 1, w = 32, x1 = 30, x2 = 31, y = 0
 * 输出：[3]
 * 说明：在第0行的第30位到第31为画一条直线，屏幕表示为[0b000000000000000000000000000000011]
 * 示例2:
 * <p>
 * 输入：length = 3, w = 96, x1 = 0, x2 = 95, y = 0
 * 输出：[-1, -1, -1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/draw-line-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question0508 {

    public static void main(String[] args) {
        Question0508 question = new Question0508();

        Question0508.Solution solution = question.new Solution();

//        1143207437
//        1017033
//        11


//        31

        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));


        int t = Integer.parseUnsignedInt(Integer.toBinaryString(-1), 2);

        System.out.println(t);

    }


    class Solution {
        public int[] drawLine(int length, int w, int x1, int x2, int y) {
            int[] res = new int[length];

            int k = w * y / 32;
            int min = Math.min(x1, x2);
            int max = Math.max(x1, x2);
            int lIndex = k + (min / 32);
            int rIndex = k + (max / 32);

            for (int i = lIndex; i <= rIndex; i++) {
                res[i] = -1;
            }

            res[lIndex] = res[lIndex] >>> x1 % 32;
            res[rIndex] = res[rIndex] & Integer.MIN_VALUE >> x2 % 32;

            return res;
        }
    }

}
