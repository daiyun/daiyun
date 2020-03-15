package daiyun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class Topic90 {

    public static void main(String[] args) {

        Topic90 topic1 = new Topic90();

        Solution solution = topic1.new Solution();

        List<List<Integer>> res = solution.subsetsWithDup(new int[]{2,2,2,2,2,2});


        System.out.println();
    }


    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();
            if (nums == null) {
                return res;
            }
            if (nums.length == 0) {
                res.add(new ArrayList<>());
                return res;
            }

            Arrays.sort(nums);

            subsetsWithDup2(nums, 0, res);

            return res;
        }

        public List<List<Integer>> subsetsWithDup2(int[] nums, int start, List<List<Integer>> res) {

            if (start == nums.length) {
                res.add(new ArrayList<>());
                return res;
            }

            List<List<Integer>> childRes = subsetsWithDup2(nums, start + 1, res);

            List<List<Integer>> curNew = new ArrayList<>();

            Integer curValue = nums[start];

            if (start < nums.length - 1 && nums[start] == nums[start + 1]) {
                for (List<Integer> item : childRes) {
                    if (item.size() > 0 && item.get(item.size() - 1) == curValue) {
                        List<Integer> newItem = new ArrayList<>(item);
                        newItem.add(curValue);
                        curNew.add(newItem);
                    }
                }
            } else {
                for (List<Integer> item : res) {
                    List<Integer> newItem = new ArrayList<>(item);
                    newItem.add(curValue);
                    curNew.add(newItem);
                }
            }

            res.addAll(curNew);

            return curNew;
        }
    }


}
