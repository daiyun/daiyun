package daiyun.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class Topic167 {

    public static void main(String[] args) {

        Topic167 topic1 = new Topic167();

        Solution solution = topic1.new Solution();

        long start = System.currentTimeMillis();


        System.out.println(System.currentTimeMillis() - start);
    }


    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            HashMap<Integer, Integer> map = new HashMap();
            for (int i = 0; i < numbers.length; i++) {
                int a = numbers[i];
                if (map.containsKey(target - a)) {
                    return new int[]{map.get(target - a), i + 1};
                } else {
                    map.put(a, i + 1);
                }
            }
            return new int[]{};
        }
    }

    class SolutionA {
        public int[] twoSum(int[] numbers, int target) {

            int left = 0;
            int right = numbers.length - 1;

            while (left < right) {
                if (numbers[left] + numbers[right] > target) {
                    right--;
                } else if (numbers[left] + numbers[right] < target) {
                    left++;
                } else {
                    return new int[]{left + 1, right + 1};
                }
            }
            return new int[]{};
        }
    }

}
