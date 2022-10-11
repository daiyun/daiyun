package daiyun.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic347 {

    public static void main(String[] args) {

        Topic347 topic1 = new Topic347();

        Solution solution = topic1.new Solution();


        int[] res = solution.topKFrequent(new int[]{5,3,1,1,1,3,73,1}, 2);

        System.out.println();

    }

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            int[] res = new int[k];

            Map<Integer,Integer> numCount = new HashMap<>();
            Map<Integer, Integer> index = new HashMap<>(k);

            for (int i : nums) {
                int count = numCount.getOrDefault(i,0);
                count++;
                numCount.put(i, count);

                if(index.containsKey(i)){
                    for(int j = index.get(i); j > 0; j--) {
                        if (numCount.getOrDefault(res[j],0) > numCount.getOrDefault(res[j-1],0)) {
                            int temp = res[j];
                            res[j] = res[j-1];
                            res[j-1] = temp;
                            index.put(i, j-1);
                            index.put(res[j], j);
                        } else {
                            break;
                        }
                    }
                }else if (numCount.getOrDefault(res[k-1], 0) < count) {
                    index.remove(res[k-1]);
                    res[k - 1] = i;
                    index.put(i, k - 1);
                    for(int j = k-1; j > 0; j--) {
                        if (numCount.getOrDefault(res[j],0) > numCount.getOrDefault(res[j-1],0)) {
                            int temp = res[j];
                            res[j] = res[j-1];
                            res[j-1] = temp;
                            index.put(i, j-1);
                            index.put(res[j], j);
                        } else {
                            break;
                        }
                    }
                }
            }

            return res;
        }
    }
}
