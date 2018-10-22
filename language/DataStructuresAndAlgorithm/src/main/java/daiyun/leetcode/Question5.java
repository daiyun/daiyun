package daiyun.leetcode;

public class Question5 {

  /**
   * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
   * <p>
   * 示例 1：
   * <p>
   * 输入: "babad"
   * 输出: "bab"
   * 注意: "aba"也是一个有效答案。
   * 示例 2：
   * <p>
   * 输入: "cbbd"
   * 输出: "bb"
   */
  class Solution {
    public String longestPalindrome(String s) {
      int sLength = s.length();
      int maxLength = 0;
      int[] res = new int[2];
      for (int i = 0; i < sLength; i++) {
        for (int j = i; j < sLength; j++) {
          if (isRep(s, i, j)) {
            if (maxLength < (j - i + 1)) {
              maxLength = j - i + 1;
              res[0] = i;
              res[1] = j;
            }
          }
        }
      }
      return s.substring(res[0], res[1]);
    }

    public boolean isRep(String s, int st, int e) {
      int p = st;
      int n = e;
      while (p < n) {
        if (s.charAt(p) != s.charAt(n)) {
          return false;
        }
        p++;
        n--;
      }
      return true;
    }
  }
}
