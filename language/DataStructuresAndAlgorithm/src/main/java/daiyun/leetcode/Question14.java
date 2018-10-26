package daiyun.leetcode;

public class Question14 {

  public static void main(String[] args) {
    Question14 question14 = new Question14();

    Question14.Solution solution = question14.new Solution();

    String[] s = new String[]{"flower","flow","flight"};
    System.out.println(solution.longestCommonPrefix(s));
  }

  class Solution {
    public String longestCommonPrefix(String[] strs) {

      if (strs == null || strs.length == 0) {
        return "";
      }

      int p = 0;
      String res = "";

      while (true) {
        Character chars = null;

        if (p < strs[0].length()) {
          chars = strs[0].charAt(p);
        } else {
          p = -1;
          break;
        }

        for (int i = 1; i < strs.length; i++) {
          if (p < strs[i].length()) {
            if (chars != strs[i].charAt(p)) {
              p = -1;
              break;
            }
          } else {
            p = -1;
            break;
          }
        }

        if (p >= 0) {
          res = res + chars;
          p++;
        } else {
          break;
        }

      }
      return res;
    }
  }
}
