package daiyun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question18 {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println("12:" + solution.fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11).size());
    // -5 -4 -3 -2 1 3 3 5
    //[[-5,-4,-3,1]]
    /**
     * [[-4,0,1,2]]
     * 预期：
     * [[-4,0,1,2],[-1,-1,0,1]]
     */

    LinkedList<String> s = new LinkedList<>();

    s.pollLast();
    s.poll();
  }

  static class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      Arrays.sort(nums);
      List<List<Integer>> res = new ArrayList<>();

      for (int i = 0; i < nums.length - 3; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {
          continue;
        }
        for (int j = i + 1; j < nums.length - 2; j++) {
          if (j > i + 1 && nums[j] == nums[j - 1]) {
            continue;
          }
          int pStart = j + 1;
          int pEnd = nums.length - 1;
          while (pStart < pEnd) {
            if (target == nums[i] + nums[j] + nums[pStart] + nums[pEnd]) {
              res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[pStart], nums[pEnd])));
              pEnd--;
              pStart++;
              while (pStart < pEnd && nums[pStart] == nums[pStart - 1]) {
                pStart++;
              }
              while (pStart < pEnd && nums[pEnd] == nums[pEnd + 1]) {
                pEnd--;
              }
            } else if (target > nums[i] + nums[j] + nums[pStart] + nums[pEnd]) {
              pStart++;
            } else {
              pEnd--;
            }
          }
        }
      }
      return res;
    }
  }
}
