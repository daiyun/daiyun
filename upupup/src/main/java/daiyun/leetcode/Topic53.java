package daiyun.leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class Topic53 {

    public static void main(String[] args) {

        Topic53 topic1 = new Topic53();

        Solution solution = topic1.new Solution();

        int res = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});

        System.out.println(res);
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null) {
                return 0;
            }

            if (nums.length == 1) {
                return nums[0];
            }

            int maxAll = nums[0];
            int preAll = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int temp = nums[i];

                if (preAll > 0 && preAll + temp > 0) {
                    preAll = preAll + temp;
                } else {
                    preAll = temp;
                }


                if (preAll > maxAll) {
                    maxAll = preAll;
                }
            }
            return maxAll;
        }
    }


}
