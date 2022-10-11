package daiyun.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，
 * 并返回他们的数组下标
 */
public class Topic1 {

    public static void main(String[] args) {

        Topic1 topic1 = new Topic1();

        Solution solution = topic1.new Solution();

        int[] res = solution.twoSum(new int[]{2, 7, 11, 15}, 9);

        System.out.println();
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {

            Map<Integer, Integer> indexs = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int p = target - nums[i];
                if (indexs.containsKey(p)) {
                    return new int[]{(int) indexs.get(p), i};
                }
                indexs.put(nums[i], i);
            }

            return null;
        }
    }


    class SolutionA {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];

            if (nums == null || nums.length < 2) {
                return res;
            }

            Map<Integer, Integer> kIndex = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int indexValue = nums[i];
                int find = target - indexValue;
                if (kIndex.containsKey(find)) {
                    res[0] = kIndex.get(find);
                    res[1] = i;
                    break;
                }
                kIndex.put(indexValue, i);
            }

            return res;
        }
    }
}
