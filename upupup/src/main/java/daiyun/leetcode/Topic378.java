package daiyun.leetcode;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 */
public class Topic378 {

    public static void main(String[] args) {

        Topic378 topic1 = new Topic378();

        Solution solution = topic1.new Solution();

        int[][] a = {{1, 2, 3, 34, 55, 65, 345}, {4, 5, 6, 7, 8, 89, 99}};

        int b = solution.kthSmallest(a, 7);

        System.out.println(b);

    }

    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            if (matrix == null) {
                return 0;
            }
            if (k < 1) {
                return 0;
            }

            int length = matrix.length;
            if (length == 0) {
                return 0;
            }

            int temp = 0;
            if (matrix[0] == null) {
                return 0;
            }
            int lengthy = matrix[0].length;
            if (lengthy < 1) {
                return 0;
            }


            int value = matrix[0][0];
            int[] p = new int[length];
            while (temp < k) {

                Integer indexP = null;
                for (int i = 0; i < length; i++) {
                    if (p[i] >= lengthy) {
                        continue;
                    }

                    if (indexP == null) {
                        indexP = i;
                    } else {
                        if (p[i] < lengthy
                                && matrix[i][p[i]] < matrix[indexP][p[indexP]]) {
                            indexP = i;
                        }
                    }
                }
                if (indexP == null) {
                    break;
                }
                value = matrix[indexP][p[indexP]];
                p[indexP] = p[indexP] + 1;
                temp++;
            }


            return value;
        }
    }
}
