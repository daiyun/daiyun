package daiyun.leetcode;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class Topic59 {

    public static void main(String[] args) {

        Topic59 topic1 = new Topic59();

        Solution solution = topic1.new Solution();

        int[][] res = solution.generateMatrix(2);

        System.out.println();
    }

    class Solution {
        public int[][] generateMatrix(int n) {
            if (n <= 0) {
                return new int[0][];
            }

            int[][] res = new int[n][n];

            int start = 1;
            int end = n * n;

            int top = -1;
            int botton = n;
            int left = -1;
            int right = n;

            int i = 0;
            int j = 0;
            int way = 1;

            while (i < n && j < n) {
                res[i][j] = start++;
                if (way == 1) {
                    if (j + 1 < right) {
                        j++;
                    } else {
                        way = 2;
                        top = i;
                        i++;
                        if (i >= botton) {
                            break;
                        }
                    }
                } else if (way == 2) {
                    if (i + 1 < botton) {
                        i++;
                    } else {
                        way = 3;
                        right = j;
                        j--;
                        if (j <= left) {
                            break;
                        }
                    }
                } else if (way == 3) {
                    if (j - 1 > left) {
                        j--;
                    } else {
                        way = 4;
                        botton = i;
                        i--;
                        if (i <= top) {
                            break;
                        }
                    }
                } else if (way == 4) {
                    if (i - 1 > top) {
                        i--;
                    } else {
                        way = 1;
                        left = j;
                        j++;
                        if (j >= right) {
                            break;
                        }
                    }
                }
            }

            return res;
        }
    }


}
