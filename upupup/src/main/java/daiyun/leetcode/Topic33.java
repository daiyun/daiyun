package daiyun.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Topic33 {

    public static void main(String[] args) {

        Topic33 topic1 = new Topic33();

        Solution solution = topic1.new Solution();

        System.out.println(solution.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));


    }

    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int start = 0;
            int end = nums.length - 1;

            while (start <= end) {
                if (target == nums[start]) {
                    return start;
                }
                if (target == nums[end]) {
                    return end;
                }
                if (target < nums[start] && target > nums[end]) {
                    return -1;
                }
                if (end - start < 2) {
                    break;
                }

                int p = (end + start) / 2;

                if (nums[start] < nums[p]) {
                    if (target > nums[start] && target < nums[p]) {
                        end = p;
                    } else {
                        start = p;
                    }
                } else {
                    if (target < nums[start] && target > nums[p]) {
                        start = p;
                    } else {
                        end = p;
                    }
                }
            }

            return -1;
        }
    }
}
