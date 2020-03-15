package daiyun.leetcode;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class Topic41 {

    public static void main(String[] args) {

        Topic41 topic1 = new Topic41();

        Solution solution = topic1.new Solution();


    }

    class Solution {
        public int firstMissingPositive(int[] nums) {
            int len = nums.length;

            int count = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] == i) {
                    count++;
                    break;
                }
            }

            if (count == 0) {
                return 1;
            }

            if (len == 1) {
                return 2;
            }

            for (int i = 0; i < len; i++) {
                if (nums[i] < 0 || nums[i] > len) {
                    nums[i] = 1;
                }
            }

            for (int i = 0; i < len; i++) {
                int a = nums[i];
                int b = Math.abs(a);

                if (b == len) {
                    if (nums[0] > 0) {
                        nums[0] = -nums[0];
                    }
                } else {
                    if (nums[b] > 0) {
                        nums[b] = -nums[b];
                    }
                }
            }

            for (int i = 1; i < len; i++) {
                if (nums[i] > 0) {
                    return i;
                }
            }

            if (nums[0] > 0) {
                return len;
            }

            return len + 1;
        }
    }

    class SolutionA {
        public int firstMissingPositive(int[] nums) {
            int len = nums.length;

            int count = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] == i) {
                    count++;
                    break;
                }
            }

            if (count == 0) {
                return 1;
            }

            if (len == 1) {
                return 2;
            }

            for (int i = 0; i < len; i++) {
                if (nums[i] < 0 || nums[i] > len) {
                    nums[i] = 1;
                }
            }

            for (int i = 0; i < len; i++) {
                int a = nums[i];
                int b = Math.abs(a);

                if (b == len) {
                    if (nums[0] > 0) {
                        nums[0] = -nums[0];
                    }
                } else {
                    if (nums[b] > 0) {
                        nums[b] = -nums[b];
                    }
                }
            }

            for (int i = 1; i < len; i++) {
                if (nums[i] > 0) {
                    return i;
                }
            }

            if (nums[0] > 0) {
                return len;
            }

            return len + 1;
        }
    }
}
