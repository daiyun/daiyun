package daiyun.leetcode.offer;

import java.util.Arrays;

/**
 * 用两个栈实现队列
 */
public class Offer3 {

    public static void main(String[] args) {


    }

    class Solution {
        public int findRepeatNumber(int[] nums) {
            if (nums == null || nums.length < 1) {
                return 0;
            }

            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == nums[i + 1]) {
                    return nums[i];
                }
            }
            return 0;
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

}
