package daiyun.leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class Topic35 {

    public static void main(String[] args) {

        Topic35 topic1 = new Topic35();

        Solution solution = topic1.new Solution();

        int ans = solution.searchInsert(new int[]{1, 3, 5, 6}, 4);

        System.out.println(ans);

    }

    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length-1;

            while (left < right) {
                int mid = (left + right) >> 1;

                if (target > nums[mid]) {
                    left = mid + 1;
                } else if (target < nums[mid] && false) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
            return right;
        }
    }
}
