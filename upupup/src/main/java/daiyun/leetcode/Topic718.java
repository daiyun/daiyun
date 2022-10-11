package daiyun.leetcode;

import java.util.HashMap;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 * <p>
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class Topic718 {

    public static void main(String[] args) {

        Topic718 topic1 = new Topic718();

        SolutionC solution = topic1.new SolutionC();



        System.out.println(solution.findLength(new int[]{5,14,53,80,48}, new int[]{50,47,3,80,83}));

    }

    // 子数组未连续的
    class Solution {
        public int findLength(int[] A, int[] B) {

            if (A == null || B == null) {
                return 0;
            }

            int aLength = A.length;
            int bLength = B.length;

            int comChrildLength = 0;
            if (aLength == 0 || bLength == 0) {
                return comChrildLength;
            }

            HashMap<Integer, Integer> aKcount = new HashMap<>();

            int[] min = A;
            int[] max = B;
            if (aLength > bLength) {
                min = B;
                max = A;
            }

            for (int aValue : min) {
                if (aKcount.containsKey(aValue)) {
                    aKcount.put(aValue, aKcount.get(aValue) + 1);
                } else {
                    aKcount.put(aValue, 1);
                }
            }

            for (int bValue : max) {
                if (aKcount.containsKey(bValue)) {
                    int aCount = aKcount.get(bValue);
                    if (aCount > 1) {
                        aKcount.put(bValue, aKcount.get(bValue) - 1);
                    } else {
                        aKcount.remove(bValue);
                    }
                    comChrildLength++;
                }
            }

            return comChrildLength;
        }
    }

    class SolutionB {
        public int findLength(int[] A, int[] B) {

            if (A == null || B == null) {
                return 0;
            }

            int aLength = A.length;
            int bLength = B.length;

            int comChrildLength = 0;
            if (aLength == 0 || bLength == 0) {
                return comChrildLength;
            }

            for (int i = 0; i < aLength; i++) {

            }

            return comChrildLength;
        }
    }

    class SolutionC {
        public int findLength(int[] A, int[] B) {

            if (A == null || B == null) {
                return 0;
            }

            int aLength = A.length;
            int bLength = B.length;

            int comChrildLength = 0;
            if (aLength == 0 || bLength == 0) {
                return comChrildLength;
            }

            for (int i = 0; i < aLength; i++) {
                int max = maxCommLength(A, i, B, 0);
                if (max > comChrildLength) {
                    comChrildLength = max;
                }
            }

            for (int i = 0; i < bLength; i++) {
                int max = maxCommLength(A, 0, B, i);
                if (max > comChrildLength) {
                    comChrildLength = max;
                }
            }

            return comChrildLength;
        }

        public int maxCommLength(int[] A, int aStart, int[] B, int bStart) {

            int aLength = A.length;
            int bLength = B.length;

            int max = 0;

            while (aStart < aLength && bStart < bLength) {
                if (A[aStart] == B[bStart]) {
                    max++;
                    aStart++;
                    bStart++;
                } else {
                    break;
                }
            }
            return max;
        }
    }
}
