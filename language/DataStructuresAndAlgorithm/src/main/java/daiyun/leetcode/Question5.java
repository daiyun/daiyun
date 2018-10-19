package daiyun.leetcode;

public class Question5 {

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
