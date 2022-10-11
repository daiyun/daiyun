package daiyun.leetcode;

import java.util.*;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic77 {

    public static void main(String[] args) {

        Topic77 topic1 = new Topic77();

        Solution solution = topic1.new Solution();

        List<List<Integer>> a= solution.combine(4, 4);

        System.out.println();
    }


    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if(n<1 || k>n){
                return res;
            }

            for(int i = 1;i<=n;i++){
                res.add(Arrays.asList(i));
            }

            for(int p = 2; p<=k; p++){
                List<List<Integer>> next = new ArrayList<>();
                for(List<Integer> child : res) {
                    for(int j = child.get(child.size()-1) + 1; j<=n; j++){
                        List temp = new ArrayList(child);
                        temp.add(j);
                        next.add(temp);
                    }
                }
                res = next;
            }

            return res;
        }
    }


}
