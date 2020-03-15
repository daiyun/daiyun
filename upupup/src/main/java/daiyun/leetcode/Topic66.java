package daiyun.leetcode;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Topic66 {

    public static void main(String[] args) {

        Topic66 topic1 = new Topic66();

        Solution solution = topic1.new Solution();


        int[] res = solution.plusOne(new int[]{0});

        System.out.println();
    }


    class Solution {
        public int[] plusOne(int[] digits) {

            if (digits == null || digits.length == 0) {
                return digits;
            }

            int len = digits.length;

            int pre = 1;
            for (int i = len - 1; i >= 0; i--) {
                int cue = digits[i] + pre;
                pre = 0;
                if (cue > 9) {
                    pre = 1;
                    digits[i] = cue - 10;
                } else {
                    digits[i] = cue;
                    return digits;
                }
            }

            if (pre > 0) {
                int[] res = new int[len + 1];
                res[0] = pre;
                for (int i = 0; i < len; i++) {
                    res[i + 1] = digits[i];
                }
                return res;
            }
            return digits;
        }
    }


}
