package daiyun.leetcode;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class Topic4 {

    public static void main(String[] args) {

        Topic4 topic1 = new Topic4();

        Solution solution = topic1.new Solution();

        System.out.println(solution.findMedianSortedArrays(new int[]{
                        1, 3
                },
                new int[]{
                        2
                }));

    }

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double ans = 0.0d;
            int l1 = nums1.length;
            int l2 = nums2.length;

            int p = 0;

            int pre = 0;
            int next = 0;

            int p1 = 0;
            int p2 = 0;
            while (p1 < l1 || p2 < l2) {
                Integer d1 = null;
                if (p1 < l1) {
                    d1 = nums1[p1];
                }
                Integer d2 = null;
                if (p2 < l2) {
                    d2 = nums2[p2];
                }

                if (d1 != null && d2 != null) {
                    if (d1 < d2) {
                        p1++;
                        pre = next;
                        next = d1;
                    } else {
                        p2++;
                        pre = next;
                        next = d2;
                    }
                } else if (d1 != null) {
                    pre = next;
                    next = d1;
                    p1++;
                } else if (d2 != null) {
                    pre = next;
                    next = d2;
                    p2++;
                }

                p++;

                if ((l1 + l2) % 2 == 0) {
                    if (p > (l1 + l2) / 2) {
                        break;
                    }
                } else {
                    if (p > (l1 + l2) / 2 + 1) {
                        break;
                    }
                }

            }
            if ((l1 + l2) % 2 == 0) {
                ans = (pre + next) / 2.0;
            } else {
                ans = pre;
            }


            return ans;
        }
    }

}
