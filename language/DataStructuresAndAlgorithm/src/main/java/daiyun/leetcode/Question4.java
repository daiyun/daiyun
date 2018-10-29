package daiyun.leetcode;

public class Question4 {

  /**
   * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
   * <p>
   * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
   * <p>
   * 你可以假设 nums1 和 nums2 不同时为空。
   * <p>
   * 示例 1:
   * <p>
   * nums1 = [1, 3]
   * nums2 = [2]
   * <p>
   * 中位数是 2.0
   * 示例 2:
   * <p>
   * nums1 = [1, 2]
   * nums2 = [3, 4]
   * <p>
   * 中位数是 (2 + 3)/2 = 2.5
   */
  class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int length1 = nums1.length;
      int length2 = nums2.length;

      int k = (length1 + length2) % 2;
      int midSize = (length1 + length2) / 2;

      int p = 0;
      int c = 0;

      int n1 = 0;
      int n2 = 0;
      for (int i = 0; i <= midSize; i++) {
        if (n1 < length1 && n2 < length2) {
          if (nums1[n1] < nums2[n2]) {
            p = c;
            c = nums1[n1];
            n1++;
          } else {
            p = c;
            c = nums2[n2];
            n2++;
          }
        } else if (n1 < length1) {
          p = c;
          c = nums1[n1];
          n1++;
        } else if (n2 < length2) {
          p = c;
          c = nums2[n2];
          n2++;
        }
      }
      if (k == 0) {
        return ((double) p + (double) c) / 2;
      } else {
        return (double) c;
      }
    }
  }
}
