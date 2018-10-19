package daiyun.leetcode;

import java.util.HashMap;

public class Question1 {
  /**
   * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
   * <p>
   * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
   * <p>
   * 示例:
   * <p>
   * 给定 nums = [2, 7, 11, 15], target = 9
   * <p>
   * 因为 nums[0] + nums[1] = 2 + 7 = 9
   * 所以返回 [0, 1]
   */

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> hashmap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int needNum = target - nums[i];
      if (hashmap.containsKey(needNum)) {
        return new int[]{hashmap.get(needNum), i};
      }
      hashmap.put(nums[i], i);
    }
    return null;
  }
}
