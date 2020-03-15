package daiyun.leetcode;

import java.util.Arrays;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Topic56 {

    public static void main(String[] args) {

        Topic56 topic1 = new Topic56();

        SolutionA solution = topic1.new SolutionA();

        int[][] res = solution.merge(new int[][]{
                {1, 3}, {0, 6}, {8, 10}, {7, 18}
        });

        System.out.println();
    }

    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length <= 1) {
                return intervals;
            }

            int len = intervals.length;
            int mid = len / 2;

            int[][] left = merge(Arrays.copyOfRange(intervals, 0, mid));
            int[][] right = merge(Arrays.copyOfRange(intervals, mid, len));

            int[][] ans = new int[left.length + right.length][];
            int index = 0;

            int mergeSize = 0;
            for (int i = 0; i < left.length; i++) {
                int[] temp = left[i];
                if (temp == null || temp.length < 2) {
                    continue;
                }
                boolean canMerge = false;
                for (int j = 0; j < right.length; j++) {
                    if (temp[0] <= right[j][1] && temp[1] >= right[j][0]) {
                        canMerge = true;
                        mergeSize++;
                        if (temp[0] > right[j][0]) {
                            right[j][1] = Math.max(right[j][1], temp[1]);
                        } else {
                            right[j][0] = Math.min(right[j][0], temp[0]);
                            right[j][1] = Math.max(right[j][1], temp[1]);
                        }
                        break;
                    }
                }
                if (!canMerge) {
                    ans[index++] = temp;
                }
            }
            for (int[] temp : right) {
                ans[index++] = temp;
            }
            if (mergeSize > 0) {
                return merge(Arrays.copyOfRange(ans, 0, index));
            } else {
                return Arrays.copyOfRange(ans, 0, index);
            }
        }
    }


    class SolutionA {

        public int[][] merge(int[][] intervals) {

            if (intervals == null || intervals.length <= 1) {
                return intervals;
            }

            int len = intervals.length;

            for (int i = 0; i < len - 1; i++) {
                for (int j = 0; j < len - i - 1; j++) {
                    if (intervals[j][0] > intervals[j + 1][0]) {
                        int[] temp = intervals[j + 1];
                        intervals[j + 1] = intervals[j];
                        intervals[j] = temp;
                    }
                }
            }

            return doMerge(intervals);
        }

        public int[][] doMerge(int[][] intervals) {
            int len = intervals.length;
            int[][] ans = new int[len][];
            int index = -1;
            int i = 0;
            while (i < len) {
                if (index >= 0 && intervals[i][0] <= ans[index][1]) {
                    ans[index][1] = Math.max(intervals[i][1], ans[index][1]);
                } else {
                    index++;
                    ans[index] = intervals[i];
                }
                i++;
            }
            return Arrays.copyOfRange(ans, 0, index + 1);
        }
    }
}
