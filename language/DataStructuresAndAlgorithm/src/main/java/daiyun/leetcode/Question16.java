package daiyun.leetcode;

import java.util.Arrays;

public class Question16 {

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
  }

  static class Solution {
    public int threeSumClosest(int[] nums, int target) {
      int res = 0;
      boolean isStart = false;
      for (int i = 0; i < nums.length - 2; i++) {
        for (int j = i + 1; j < nums.length - 1; j++) {
          for (int k = j + 1; k < nums.length; k++) {
            int p = nums[i] + nums[j] + nums[k];

            if (!isStart) {
              res = p;
              isStart = true;
            } else {

              if (Math.abs(target - p) <= Math.abs(target - res)) {
                res = p;
              }

            }
          }
        }
      }
      return res;

    }
  }

  class SolutionB {
    public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
      int tempResult = nums[0] + nums[1] + nums[2];
      for (int i = 0; i < nums.length - 2; i++) {
        int head = i + 1;
        int tail = nums.length - 1;
        while (head < tail) {
          if (Math.abs(nums[i] + nums[head] + nums[tail] - target) <= Math.abs(tempResult - target)) {
            tempResult = nums[i] + nums[head] + nums[tail];
          }
          if (nums[i] + nums[head] + nums[tail] > target) {
            tail--;
          } else
            head++;
        }
      }
      return tempResult;
    }
  }
}
