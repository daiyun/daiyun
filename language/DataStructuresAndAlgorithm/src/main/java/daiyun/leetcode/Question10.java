package daiyun.leetcode;

public class Question10 {

  class SolutionB {
    public boolean isMatch(String s, String p) {

      int sLength = s.length();
      int pLength = p.length();
      boolean[][] sp = new boolean[sLength + 1][pLength + 1];

      sp[0][0] = true;

      // 初始状态
      // 当字符不为空 匹配模式为空时 返回不匹配
      for (int i = 1; i <= sLength; i++) {
        sp[i][0] = false;
      }

      // 初始状态
      // 只能是 a*b*c*类似的才能配置 依赖上一个模式匹配情况
      // 第一个字符不可能为 *
      for (int i = 1; i <= pLength; i++) {
        if (p.charAt(i - 1) == '*' && sp[0][i - 2]) {
          sp[0][i] = true;
        }else{
          sp[0][i] = false;
        }
      }

      for (int i = 1; i <= sLength; i++) {
        for (int j = 1; j <= pLength; j++) {
          if (s.charAt(i - 1) == p.charAt(j - 1)) {
            sp[i][j] = sp[i - 1][j - 1];
          } else if (p.charAt(j - 1) == '.') {
            sp[i][j] = sp[i - 1][j - 1];
          } else if (p.charAt(j - 1) == '*') {
            if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
              sp[i][j] = sp[i][j - 2];
            } else {
              sp[i][j] = (sp[i][j - 1] || sp[i][j - 2] || sp[i - 1][j]);
            }
          } else {
            sp[i][j] = false;
          }

        }
      }


      return sp[sLength][pLength];
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
