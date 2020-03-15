package daiyun.leetcode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class Topic55 {

    public static void main(String[] args) {

        Topic55 topic1 = new Topic55();

        Solution solution = topic1.new Solution();

        boolean res = solution.canJump(new int[]{2, 3, 1, 1, 4, 1, 1, 1, 1});

        System.out.println();
    }

    class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null) {
                return false;
            }

            if (nums.length < 2) {
                return true;
            }

//            int step = 0;
            int i = 0;
            for (; i < nums.length; ) {
                int max = i + nums[i];
                if (max == i) {
                    return i == nums.length - 1;
                }
                if (max >= nums.length) {
                    return true;
                }
//                step++;

                for (int j = i + 1; j <= max; j++) {
                    if (nums[j] + j >= nums[i] + i) {
                        i = j;
                    }
                }
            }

            return true;
        }
    }

    class SolutionA {
        public boolean canJump(int[] nums) {
            int lastPos = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i + nums[i] >= lastPos) {
                    lastPos = i;
                }
            }
            return lastPos == 0;
        }
    }

}
