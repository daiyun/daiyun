package daiyun.leetcode;

import java.util.*;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Topic46 {

    public static void main(String[] args) {

        Topic46 topic1 = new Topic46();

        SolutionA solution = topic1.new SolutionA();

        List<List<Integer>> ans = solution.permute(new int[]{1, 2, 3});

        System.out.println();
    }


    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new LinkedList<>();
            if (nums.length == 1) {
                ans.add(Arrays.asList(new Integer[]{nums[0]}));
                return ans;
            }

            List<List<Integer>> child = permute(Arrays.copyOfRange(nums, 1, nums.length));

            Integer cur = nums[0];
            for (List<Integer> item : child) {
                for (int i = 0; i < item.size(); i++) {
                    LinkedList<Integer> oneRes = new LinkedList<>(item);
                    oneRes.add(i, cur);
                    ans.add(oneRes);
                }
                LinkedList<Integer> oneRes = new LinkedList<>(item);
                oneRes.add(cur);
                ans.add(oneRes);
            }

            return ans;
        }
    }

    class SolutionA {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new LinkedList<>();

            List<Integer> numsList = new ArrayList<>();
            for (Integer num : nums) {
                numsList.add(num);
            }

            doPermute(numsList, 0, ans);
            return ans;
        }

        public void doPermute(List<Integer> nums, int start, List<List<Integer>> ans) {
            if (start == nums.size()) {
                ans.add(new ArrayList<>(nums));
                return;
            }

            for (int i = start; i < nums.size(); i++) {

                Collections.swap(nums, start, i);

                doPermute(nums, start + 1, ans);

                Collections.swap(nums, start, i);
            }
        }
    }

}
