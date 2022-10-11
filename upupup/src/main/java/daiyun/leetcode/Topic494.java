package daiyun.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *  
 *
 * 提示：
 *
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 */
public class Topic494 {

    public static void main(String[] args) {

        Topic494 topic1 = new Topic494();

        SolutionA solution = topic1.new SolutionA();

        long start = System.currentTimeMillis();


        int res = solution.findTargetSumWays(new int[]
                        {7,46,36,49,5,34,25,39,41,38,49,47,17,11,1,41,7,16,23,13},3);

        System.out.println("res: "+res);

        System.out.println(System.currentTimeMillis()-start);
    }

    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            List<Integer> levelCount = new LinkedList<>();
            levelCount.add(0);

            for(int i = 0;i<nums.length;i++){
                List<Integer> nextLevel = new LinkedList<>();
                for(Integer pre:levelCount){
                    nextLevel.add(pre + nums[i]);
                    nextLevel.add(pre - nums[i]);
                }
                levelCount = nextLevel;
            }

            int count = 0;
            for(Integer temp:levelCount){
                if(temp == S){
                    count++;
                }
            }
            return count;
        }
    }

    class SolutionA {
        public int findTargetSumWays(int[] nums, int S) {
            return findTargetSumWays(nums, S, nums.length - 1, new HashMap<>());
        }

        public int findTargetSumWays(int[] nums, int S, int index, Map<String,Integer> map){
            if (index < 0) {
                return 0;
            }

            int count = 0;
            if(index == 0){
                if(nums[index] == S || nums[index] + S == 0){
                    if(nums[index] == S && nums[index] + S == 0){
                        return 2;
                    }
                    return 1;
                }else{
                    return 0;
                }
            }

            if (map.containsKey(index+"-"+S)) {
                return map.get(index + "-" + S);
            }

            count += findTargetSumWays(nums, S - nums[index], index - 1, map);
            count += findTargetSumWays(nums, S + nums[index], index - 1, map);

            map.put(index + "-" + S, count);
            return count;
        }
    }
}
