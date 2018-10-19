package daiyun.leetcode;

public class Question4 {

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
