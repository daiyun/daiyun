package daiyun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Topic47 {

    public static void main(String[] args) {

        Topic47 topic1 = new Topic47();

        Solution solution = topic1.new Solution();

        List<List<Integer>> ans = solution.permuteUnique(new int[]{3,3,0,3});

        System.out.println();
    }


    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {

            Arrays.sort(nums);

            List<List<Integer>> ans = new LinkedList<>();

            LinkedList<Integer> numsList = new LinkedList<>();
            for (Integer num : nums) {
                numsList.add(num);
            }

            doPermute(numsList, 0, ans);
            return ans;
        }

        public void doPermute(LinkedList<Integer> nums, int start, List<List<Integer>> ans) {
            if (start == nums.size()) {
                ans.add(new ArrayList<>(nums));
                return;
            }

            for (int i = start; i < nums.size(); i++) {

                if (i > start && nums.get(i) == nums.get(i - 1)) {
                    continue;
                }

                int curVaule = nums.remove(i);
                nums.add(start, curVaule);

                doPermute(nums, start + 1, ans);

                int affterVaule = nums.remove(start);
                nums.add(i, affterVaule);
            }
        }
    }

}
