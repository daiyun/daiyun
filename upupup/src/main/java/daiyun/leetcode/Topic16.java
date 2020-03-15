package daiyun.leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Topic16 {

    public static void main(String[] args) {

        Topic16 topic1 = new Topic16();

        Solution solution = topic1.new Solution();

        System.out.println(solution.threeSumClosest(new int[]{-1,2,1,-4}, 1));

    }


    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);

            int len = nums.length;
            Integer ans = null;
            for (int i = 0; i < len; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int L = i + 1;
                int R = len - 1;
                while (L < R) {
                    if (target == nums[i] + nums[L] + nums[R]) {
                        return target;
                    } else {
                        if (ans != null) {
                            if (Math.abs(target - (nums[i] + nums[L] + nums[R]))
                                    < Math.abs(ans - (nums[i] + nums[L] + nums[R]))) {
                                ans = nums[i] + nums[L] + nums[R];
                            }
                        } else {
                            ans = nums[i] + nums[L] + nums[R];
                        }

                        if (target > nums[i] + nums[L] + nums[R]) {
                            L++;
                        } else {
                            R--;
                        }
                    }
                }
            }
            return ans;
        }
    }

}
