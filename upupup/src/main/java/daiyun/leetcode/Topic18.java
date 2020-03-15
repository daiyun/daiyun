package daiyun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class Topic18 {

    public static void main(String[] args) {

        Topic18 topic1 = new Topic18();

        Solution solution = topic1.new Solution();

        solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);

    }


    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);

            int len = nums.length;

            List<List<Integer>> ans = new ArrayList<>();

            for (int i = 0; i < len - 3; i++) {
                if (nums[i] > target) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                for (int j = i + 1; j < len; j++) {

                    int L = j + 1;
                    int R = len - 1;

                    while (L < R) {
                        if (target == (nums[i] + nums[j] + nums[L] + nums[R])) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));

                            while (nums[L] == nums[L + 1]) {
                                L++;
                            }

                            while (nums[R] == nums[R - 1]) {
                                R--;
                            }

                            L++;
                            R--;
                        } else if (target > (nums[i] + nums[j] + nums[L] + nums[R])) {
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