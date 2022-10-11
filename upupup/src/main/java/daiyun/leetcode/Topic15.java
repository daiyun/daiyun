package daiyun.leetcode;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Topic15 {

    public static void main(String[] args) {

        Topic15 topic1 = new Topic15();

        SolutionA solution = topic1.new SolutionA();

        List<List<Integer>> lists = solution.threeSum(new int[]{1, -1, -1, 0});

        System.out.println();

    }


    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Integer p = null;
            List<List<Integer>> ans = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {

                if (nums[i] > 0) {
                    break;
                }

                if (i > 0 && nums[i] == p) {
                    continue;
                }
                p = nums[i];
                Set<Integer> index = new HashSet<>();
                for (int j = i + 1; j < nums.length; j++) {
                    if (index.contains(-(p + nums[j]))) {
                        ans.add(Arrays.asList(p, nums[j], -(p + nums[j])));
                    } else {
                        index.add(nums[j]);
                    }
                }
            }

            return ans;
        }

    }

    class SolutionA {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length < 3) {
                return res;
            }

            // 排序
            Arrays.sort(nums);

            for (int first = 0; first < nums.length; first++) {
                if (nums[first] > 0) {
                    break;
                }

                if ((first > 0 && nums[first] == nums[first - 1])) {
                    continue;
                }

                int second = first + 1;
                int third = nums.length - 1;
                while (second < third) {
                    if (nums[second] + nums[third] == -nums[first]) {
                        List<Integer> oneRes = new ArrayList<>();
                        oneRes.add(first);
                        oneRes.add(second);
                        oneRes.add(third);
                        res.add(oneRes);
                        second++;
                        third--;
                    } else if (nums[second] + nums[third] < -nums[first]) {
                        second++;
                        while (second < third && nums[second] == nums[second - 1]) {
                            second++;
                        }
                    } else {
                        third--;
                        while (second < third && nums[third] == nums[third + 1]) {
                            third--;
                        }
                    }
                }
            }

            return res;
        }

    }

}
