package daiyun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class Topic40 {

    public static void main(String[] args) {

        Topic40 topic1 = new Topic40();

        SolutionA solution = topic1.new SolutionA();

        List<List<Integer>> ans = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);

        System.out.println();

    }

    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            Arrays.sort(candidates);

            return doCombinctionSum(candidates, target, 0);
        }

        public List<List<Integer>> doCombinctionSum(int[] candidates, int target, int index) {
            if (index >= candidates.length) {
                return null;
            }

            int curValue = candidates[index];
            if (curValue > target) {
                return null;
            }

            List<List<Integer>> ans = new ArrayList<>();

            if (curValue == target) {
                List<Integer> minRes = new ArrayList<>();
                minRes.add(curValue);
                ans.add(minRes);
                return ans;
            }


            if (index > 0 && candidates[index] != candidates[index - 1]) {
                List<List<Integer>> nextSearchRes1 = doCombinctionSum(candidates, target, index + 1);

                if (nextSearchRes1 != null) {
                    ans.addAll(nextSearchRes1);
                }
            }

            List<List<Integer>> nextSearchRes2 = doCombinctionSum(candidates, target - curValue, index + 1);
            if (nextSearchRes2 != null) {
                for (List<Integer> child : nextSearchRes2) {
                    if (child == null) {
                        continue;
                    }
                    child.add(curValue);
                    ans.add(child);
                }
            }

            return ans;
        }
    }

    class SolutionA {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            Arrays.sort(candidates);

            List<List<Integer>> ans = new LinkedList<>();

            doCombinctionSum(ans, candidates, target, 0, new ArrayList<Integer>());

            return ans;
        }

        public void doCombinctionSum(List<List<Integer>> ans,
                                     int[] candidates, int target,
                                     int start, List<Integer> res) {

            if (target == 0) {
                ans.add(new ArrayList<>(res));
                return;
            }

            if (start >= candidates.length) {
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                List<Integer> child = new ArrayList<>(res);
                child.add(candidates[i]);
                doCombinctionSum(ans, candidates, target - candidates[i], i + 1, child);
            }
        }
    }
}
