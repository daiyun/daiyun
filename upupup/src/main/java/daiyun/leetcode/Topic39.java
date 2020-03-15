package daiyun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Topic39 {

    public static void main(String[] args) {

        Topic39 topic1 = new Topic39();

        Solution solution = topic1.new Solution();

        List<List<Integer>> ans = solution.combinationSum(new int[]{2, 3, 5}, 8);


        System.out.println();
    }

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            Arrays.sort(candidates);

            int len = candidates.length;

            return combinationSum(candidates, target, 0);

        }

        public List<List<Integer>> combinationSum(int[] candidates, int target, int index) {
            List<List<Integer>> res = new ArrayList<>();

            if (index >= candidates.length) {
                return null;
            }

            int cur = candidates[index];
            int curNumNeedSize = 0;
            while (target >= cur * curNumNeedSize) {

                if (target == cur * curNumNeedSize) {
                    List<Integer> minAns = new ArrayList<>();
                    for (int i = 0; i < curNumNeedSize; i++) {
                        minAns.add(cur);
                    }
                    res.add(minAns);

                } else {
                    List<List<Integer>> child
                            = combinationSum(candidates, target - (cur * curNumNeedSize), index + 1);

                    if (child != null) {
                        for (List<Integer> item : child) {
                            for (int i = 0; i < curNumNeedSize; i++) {
                                item.add(cur);
                            }
                            res.add(item);
                        }
                    }

                }
                curNumNeedSize++;
            }
            return res;
        }
    }
}
