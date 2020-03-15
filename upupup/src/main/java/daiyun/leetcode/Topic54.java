package daiyun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Topic54 {

    public static void main(String[] args) {

        Topic54 topic1 = new Topic54();

        SolutionA solution = topic1.new SolutionA();

        List<Integer> res = solution.spiralOrder(new int[][]{
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        });

        System.out.println();
    }

    class SolutionA {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            if (matrix == null || matrix.length == 0) {
                return ans;
            }


            int m = matrix.length;
            int n = matrix[0].length;

            int left = 0;
            int right = n - 1;
            int top = 0;
            int botton = m - 1;

            while (left < right || top < botton) {
                for (int j = left; j <= right && top <= botton; j++) {
                    ans.add(matrix[top][j]);
                }
                top++;

                for (int i = top; i <= botton && right >= left; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;

                for (int j = right; j >= left && botton >= top; j--) {
                    ans.add(matrix[botton][j]);
                }
                botton--;

                for (int i = botton; i >= top && left <= right; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }


            return ans;
        }
    }

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            if (matrix == null || matrix.length == 0) {
                return ans;
            }


            int m = matrix.length;
            int n = matrix[0].length;

            int left = -1;
            int right = n;
            int top = -1;
            int botton = m;

            int i = 0;
            int j = 0;

            int way = 1;

            while (i < m && j < n) {
                ans.add(matrix[i][j]);

                if (way == 1) {
                    if (j + 1 < right) {
                        j++;
                    } else {
                        top = i;
                        way = 2;
                        i++;
                        if (i >= botton) {
                            break;
                        }
                    }
                } else if (way == 2) {
                    if (i + 1 < botton) {
                        i++;
                    } else {
                        right = j;
                        way = 3;
                        j--;
                        if (j <= left) {
                            break;
                        }
                    }
                } else if (way == 3) {
                    if (j - 1 > left) {
                        j--;
                    } else {
                        botton = i;
                        way = 4;
                        i--;
                        if (i <= top) {
                            break;
                        }
                    }
                } else if (way == 4) {
                    if (i - 1 > top) {
                        i--;
                    } else {
                        left = j;
                        way = 1;
                        j++;
                        if (j >= right) {
                            break;
                        }
                    }
                }
            }

            return ans;
        }
    }


}
