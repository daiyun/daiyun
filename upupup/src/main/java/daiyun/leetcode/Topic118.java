package daiyun.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Topic118 {

    public static void main(String[] args) {

        Topic118 topic1 = new Topic118();

        Solution solution = topic1.new Solution();

        long start = System.currentTimeMillis();

        List res = solution.generate(5);

        System.out.println(System.currentTimeMillis() - start);
    }


    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            if (numRows < 1) {
                return res;
            }

            List<Integer> item = new ArrayList<>();
            item.add(1);
            res.add(item);
            if (numRows < 2) {
                return res;
            }

            for (int i = 2; i <= numRows; i++) {
                List<Integer> levelItem = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    int left = 0;
                    if (j - 1 >= 0) {
                        left = res.get(i - 2).get(j - 1);
                    }

                    int right = 0;
                    if (j < res.get(i - 2).size()) {
                        right = res.get(i - 2).get(j);
                    }

                    levelItem.add(left + right);
                }
                res.add(levelItem);
            }
            return res;
        }
    }
}
