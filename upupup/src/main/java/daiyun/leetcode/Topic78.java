package daiyun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Topic78 {

    public static void main(String[] args) {

        Topic78 topic1 = new Topic78();

        Solution solution = topic1.new Solution();

        List<List<Integer>> res = solution.subsets(new int[]{1,2,3});


        System.out.println();
    }


    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length == 0) {
                res.add(new ArrayList<>());
                return res;
            }

            Integer curValue = nums[nums.length - 1];

            List<List<Integer>> childRes = subsets(Arrays.copyOfRange(nums, 0, nums.length - 1));

            res.addAll(childRes);

            for (List<Integer> item : childRes) {
                List<Integer> resItem = new ArrayList<>(item);
                resItem.add(curValue);
                res.add(resItem);
            }

            return res;
        }
    }

    class SolutionA {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            int len = nums.length;
            subsets2(result,nums,len);
            return result;
        }
        public void subsets2(List<List<Integer>> result, int[] nums, int len) {
            if(len==0){
                List<Integer> ele = new ArrayList<Integer>();
                result.add(ele);
                return;
            }
            subsets2(result, nums, len - 1);
            List<Integer> ele = null;
            List<Integer> temp = null;
            int size = result.size();
            for(int i=0;i<size;++i){
                temp = result.get(i);
                //ele = new ArrayList<Integer>(temp);
                ele = (List)((ArrayList)temp).clone();
                ele.add(nums[len-1]);
                result.add(ele);
            }
        }
    }


}
