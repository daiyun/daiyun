package daiyun.leetcode.lcci;

/**
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 * <p>
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 */
public class Question1611 {

    public static void main(String[] args) {
        Question1611 question = new Question1611();

        Question1611.Solution solution = question.new Solution();

//        "sdfsdsdssdfs"
//        "dssdfs"
//        "sdfsds"
//        27

        solution.divingBoard(1, 2, 3);
    }

    class Solution {
        public int[] divingBoard(int shorter, int longer, int k) {
            if (k == 0) {
                return new int[]{};
            }

            if (shorter == longer) {
                return new int[]{shorter * k};
            }

            int[] res = new int[k + 1];
            for (int i = k; i >= 0; i--) {
                res[k - i] = shorter * i + longer * (k - i);
            }

            return res;
        }
    }
}
