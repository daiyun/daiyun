package daiyun.leetcode;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class Topic34 {

    public static void main(String[] args) {

        Topic34 topic1 = new Topic34();

        SolutionA solution = topic1.new SolutionA();

        int[] ans = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5);

        System.out.println();
    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] ans = new int[]{-1, -1};

            if (nums == null || nums.length < 1) {
                return ans;
            }

            int L = 0;
            int R = nums.length - 1;

            Integer index = null;
            while (L < R) {

                if (nums[L] == target) {
                    index = L;
                    break;
                }

                if (nums[R] == target) {
                    index = R;
                    break;
                }

                int p = (L + R) / 2;
                if (nums[p] == target) {
                    index = p;
                }

                if (target > nums[p]) {
                    L = p + 1;
                } else {
                    R = p - 1;
                }
            }

            if (index == null) {
                return new int[]{-1, -1};
            }

            L = index;
            R = index;

            while (R < nums.length - 1 && target == nums[R + 1]) {
                R++;
            }

            while (L > 0 && target == nums[L - 1]) {
                L--;
            }

            return new int[]{L, R};
        }
    }

    class SolutionA {
        public int[] searchRange(int[] nums, int target) {
            int[] ans = new int[]{-1, -1};

            return new int[]{searchIndex(nums, target, true), searchIndex(nums, target, false)};
        }

        public int searchIndex(int[] nums, int target, boolean left) {
            int lo = 0;
            int hi = nums.length - 1;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (target > nums[mid]) {
                    lo = mid + 1;
                } else if (target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    if (lo == mid) {
                        hi = mid;
                    }
                    if (left) {
                        hi = mid;
                    } else {
                        lo = mid;
                    }
                }
            }

            if (target == nums[lo]) {
                return lo;
            }

            return -1;
        }


        public int searchLeft(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (target > nums[mid]) {
                    lo = mid + 1;
                } else if (target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    hi = mid;
                }
            }

            if (target == nums[lo]) {
                return lo;
            }

            return -1;
        }

        public int searchRight(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (target < nums[mid]) {
                    hi = mid - 1;
                } else if (target > nums[mid]) {
                    lo = mid + 1;
                } else {
                    if (lo == mid) {
                        hi = mid;
                    }
                    lo = mid;
                }
            }

            if (target == nums[lo]) {
                return lo;
            }

            return -1;
        }
    }
}
