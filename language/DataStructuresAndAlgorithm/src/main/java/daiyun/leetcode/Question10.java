package daiyun.leetcode;

public class Question10 {


  class SolutionB {
    public boolean isMetch(String s, String p) {
      return false;
    }
  }

  class Solution {
    public boolean isMatch(String s, String p) {
      //"aab"
// "c*a*b"
      // "aaa"
// "ab*a*c*a"

//      "ab"
//      ".*.."
      int k = 0;
      int length = s.length();
      int pLength = p.length();

      Character[] preRegex = null;
      int re = 0;
      for (int i = 0; i < length; ) {
        Character c = s.charAt(i);
        if (k >= pLength) {
          return false;
        }

        Character[] regex = null;
        if (k + 1 < pLength) {
          if (p.charAt(k + 1) == '*') {
            regex = new Character[2];
            regex[0] = p.charAt(k);
            regex[1] = '*';
          } else {
            regex = new Character[1];
            regex[0] = p.charAt(k);
          }
        } else {
          regex = new Character[1];
          regex[0] = p.charAt(k);
        }


        if (preRegex != null) {
          re = metch(c, regex);

          if (re > 0) {
            preRegex = regex;
          }

          if (re <= 0) {
            if (preRegex.length == 2) {
              if (preRegex[0] == regex[0] || preRegex[0] == '.') {
                re = -1;
              }
            }
          }

        } else {
          re = metch(c, regex);
          if (re > 0) {
            preRegex = regex;
          }
        }


        if (re == 0) {
          return false;
        } else if (re > 0) {
          i++;
        }

        if (re == 1 || re == -1) {
          if (k + 1 < pLength) {
            if (p.charAt(k + 1) == '*') {
              k = k + 2;
            } else {
              k++;
            }
          } else {
            k++;
          }
        }
      }
      for (; k < pLength; ) {
        if (k + 1 < pLength) {
          if (p.charAt(k + 1) == '*') {
            k = k + 2;
          } else {
            return false;
          }
        } else {
          if (preRegex != null) {
            if (preRegex.length == 2) {

              if (preRegex[0] == p.charAt(k)) {
                k++;
              } else if (re == p.charAt(k)) {
                k++;
              } else {
                return false;
              }
            } else {
              return false;
            }
          } else {
            return false;
          }
        }
      }

      return true;
    }

    public int metch(Character s, Character regex[]) {
      if (regex.length == 1) {
        if (s == regex[0]) {
          return 1;
        } else if (regex[0] == '.') {
          return 1;
        } else {
          return 0;
        }
      } else {
        if (s == regex[0]) {
          return s;
        } else if (regex[0] == '.') {
          return s;
        } else {
          return -1;
        }
      }
    }

  }
}
