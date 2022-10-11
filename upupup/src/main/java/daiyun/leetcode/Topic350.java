package daiyun.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 */
public class Topic350 {

    public static void main(String[] args) {

        Topic350 topic1 = new Topic350();

        Solution solution = topic1.new Solution();

        int[][] a = {{1, 2, 3, 1, 55, 65, 345}, {4, 5, 6, 7, 8, 89, 99}};


    }

    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {

            if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
                return new int[]{};
            }

            HashMap<Integer, Integer> numCount = new HashMap<>();

            for (int i = 0; i < nums1.length; i++) {
                if (numCount.containsKey(nums1[i])) {
                    numCount.put(nums1[i], numCount.get(nums1[i]) + 1);
                } else {
                    numCount.put(nums1[i], 1);
                }
            }

            int[] comInteger = new int[nums2.length];
            int comSize = 0;
            for (Integer temp : nums2) {
                if (numCount.containsKey(temp)) {
                    comInteger[comSize++] = temp;
                    if (numCount.get(temp) > 1) {
                        numCount.put(temp, numCount.get(temp) - 1);
                    } else {
                        numCount.remove(temp);
                    }
                }
            }

            return Arrays.copyOf(comInteger, comSize);
        }
    }
}
