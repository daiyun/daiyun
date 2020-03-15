package daiyun.leetcode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 */
public class Topic45 {

    public static void main(String[] args) {

        Topic45 topic1 = new Topic45();

        Solution solution = topic1.new Solution();

        int ans = solution.jump(new int[]{2, 3, 1, 1, 4, 1, 1, 1, 1});

        System.out.println(ans);
    }


    class Solution {
        public int jump(int[] nums) {
            int ans = 0;
            if (nums.length < 2) {
                return ans;
            }
            int len = nums.length;

            for (int i = 0; i < len; ) {

                int curVales = nums[i];
                if (i + curVales == len - 1) {
                    ans++;
                    break;
                } else if (i + curVales < len) {
                    ans++;
                    int maxIndex = i;
                    for (int j = i + 1; j <= i + curVales; j++) {
                        if (nums[j] + j > nums[maxIndex] + maxIndex) {
                            maxIndex = j;
                        } else if (nums[j] + j == len - 1) {
                            maxIndex = j;
                            break;
                        }
                    }
                    i = maxIndex;
                } else {
                    break;
                }
            }

            return ans;
        }
    }


    class SolutionA {
        public int jump(int[] nums) {
            int ans = 0;
            if (nums == null || nums.length < 2) {
                return ans;
            }

            int maxPostion = 0;
            int end = 0;
            for (int i = 0; i < nums.length; i++) {
                maxPostion = Math.max(maxPostion, nums[i] + i);
                if (i == end) {
                    ans++;
                    end = maxPostion;
                }
            }
            return ans;
        }
    }

}
