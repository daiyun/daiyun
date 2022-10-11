package daiyun.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic60 {

    public static void main(String[] args) {

        Topic60 topic1 = new Topic60();

        Solution solution = topic1.new Solution();


        System.out.println(solution.getPermutation(3, 6));
    }

    class Solution {
        public String getPermutation(int n, int k) {
            List<Integer> nums = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                nums.add(i);
            }

            return doPermutation(nums, k);
        }

        public String doPermutation(List<Integer> nums, int k) {
            if (nums.size() == 0) {
                return "";
            }

            if (k <= 1 || nums.size() == 1) {
                return nums.remove(0) + doPermutation(nums, 1);
            }

            int p = 1;
            for (int i = 1; i < nums.size(); i++) {
                p = p * i;
            }

            int index = (k - 1) / p;
            int next = k - index * p;

            return nums.remove(index) + doPermutation(nums, next);
        }
    }


}
