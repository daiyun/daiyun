package daiyun.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class Topic88 {

    public static void main(String[] args) {

        Topic88 topic1 = new Topic88();

        Solution solution = topic1.new Solution();

        long start = System.currentTimeMillis();

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        solution.merge(nums1, 3, new int[]{2, 5, 6}, 3);

        System.out.println(System.currentTimeMillis() - start);
    }


    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n <= 0) {
                return;
            }


            List<Integer> res = new ArrayList<>();

            int i = 0;
            int j = 0;
            while (i < m || j < n) {
                Integer a = null;
                if (i < m) {
                    a = nums1[i];
                }

                Integer b = null;
                if (j < n) {
                    b = nums2[j];
                }

                if (a != null && b != null) {
                    if (b < a) {
                        res.add(b);
                        j++;
                    } else {
                        res.add(a);
                        i++;
                    }
                } else if (a != null) {
                    res.add(a);
                    i++;
                } else if (b != null) {
                    res.add(b);
                    j++;
                }
            }

            for (int k = 0; k < res.size(); k++) {
                nums1[k] = res.get(k);
            }
        }
    }

    class SolutionA {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p = m + n - 1;

            int p1 = m - 1;
            int p2 = n - 1;

            while (p1 >= 0 && p2 >= 0) {
                nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
            }

            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }

}
