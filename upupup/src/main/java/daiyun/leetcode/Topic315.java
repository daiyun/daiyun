package daiyun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 */
public class Topic315 {

    public static void main(String[] args) {

        Topic315 topic1 = new Topic315();

        SolutionA solution = topic1.new SolutionA();

        int[][] a = {{1, 2, 3, 1, 55, 65, 345}, {4, 5, 6, 7, 8, 89, 99}};

//        {1,21,2,3}

        solution.insertSort(new int[]{1, 2, 2, 3, 4, 6, 7, 0}, 7, 2);
    }

    class Solution {
        public List<Integer> countSmaller(int[] nums) {

            if (nums == null) {
                return null;
            }

            List<Integer> countSmall = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                int smallCount = 0;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        smallCount++;
                    }
                }
                countSmall.add(smallCount);
            }

            return countSmall;
        }
    }

    class SolutionA {
        public List<Integer> countSmaller(int[] nums) {

            if (nums == null) {
                return null;
            }

            int length = nums.length;
            Integer[] countSmall = new Integer[length];
            int[] sortArr = new int[length];

            for (int i = length - 1; i >= 0; i--) {
                int index = insertSort(sortArr, length - i - 1, nums[i]);
                countSmall[i] = index;
            }

            return Arrays.asList(countSmall);
        }

        public int insertSort(int[] nums, int len, int a) {
            int start = 0;
            int end = len - 1;
            while (end >= 0 && start <= end) {
                int mid = (end + start) / 2;
                if (a <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            System.arraycopy(nums, start, nums, start + 1, (len - start));
            nums[start] = a;
            return start;
        }
    }
}
