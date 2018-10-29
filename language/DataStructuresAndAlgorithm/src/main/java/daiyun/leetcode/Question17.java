package daiyun.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question17 {

  class Solution {
    String[] codes = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
      if (digits == null || digits.equals("")) {
        return new ArrayList<>();
      }
      List<String> result = new ArrayList<>();
      backtrace(digits, result, "", 1, digits.length());
      return result;
    }

    private void backtrace(String digits, List<String> list, String str, int deep, int n) {
      if (deep == n) {
        for (char c : codes[digits.charAt(deep - 1) - '0' - 2].toCharArray()) {
          list.add(str + c);
        }
      } else {
        for (char c : codes[digits.charAt(deep - 1) - '0' - 2].toCharArray()) {
          backtrace(digits, list, str + c, deep + 1, n);
        }
      }
    }

    public void doStack(String digits, List<String> res, String pre, int deep, int length) {
      if (deep == length) {
        for (char ch : codes[digits.charAt(length - deep) - '0' - 2].toCharArray()) {
          res.add(pre + ch);
        }
      } else {
        for (char ch : codes[digits.charAt(length - deep) - '0' - 2].toCharArray()) {
          doStack(digits, res, pre + ch, deep+1, length);
        }
      }
    }
  }

  class SolutionB {
    public List<String> letterCombinations(String digits) {
      List<String> res = new ArrayList<>();
      Character[][] dist = new Character[10][4];
      dist[2][0] = 'a';
      dist[2][1] = 'b';
      dist[2][2] = 'c';

      dist[3][0] = 'd';
      dist[3][1] = 'e';
      dist[3][2] = 'f';

      dist[4][0] = 'g';
      dist[4][1] = 'h';
      dist[4][2] = 'i';

      dist[5][0] = 'j';
      dist[5][1] = 'k';
      dist[5][2] = 'l';

      dist[6][0] = 'm';
      dist[6][1] = 'n';
      dist[6][2] = 'o';

      dist[7][0] = 'p';
      dist[7][1] = 'q';
      dist[7][2] = 'r';
      dist[7][3] = 's';

      dist[8][0] = 't';
      dist[8][1] = 'u';
      dist[8][2] = 'v';

      dist[9][0] = 'w';
      dist[9][1] = 'x';
      dist[9][2] = 'y';
      dist[9][3] = 'z';

      for (int i = 0; i < digits.length(); i++) {
        Character p = digits.charAt(i);
        Character[] chars = dist[Integer.parseInt(p + "")];
        List<String> temp = new ArrayList<>();
        for (int k = 0; k < chars.length; k++) {
          if (chars[k] != null && chars[k] != 0) {
            if (res.size() > 0) {
              for (int j = 0; j < res.size(); j++) {
                String pre = res.get(j);
                temp.add(pre + chars[k]);
              }
            } else {
              temp.add("" + chars[k]);
            }
          }
        }

        res = temp;

      }
      return res;

    }
  }

  class SolutionC {
    String[] codes = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
      if (digits == null || "".equals(digits)) {
        return null;
      }
      List<String> res = new ArrayList<>();
      doStack(digits, res, "", 1, digits.length());
      return res;
    }

    public void doStack(String digits, List<String> res, String pre, int deep, int length) {
      if (deep == length) {
        for (char ch : codes[digits.charAt(0) - '0' - 2].toCharArray()) {
          res.add(pre + ch);
        }
      } else {
        for (char ch : codes[digits.charAt(length - deep) - '0' - 2].toCharArray()) {
          doStack(digits, res, pre + ch, deep+1, length);
        }
      }
    }
  }
}
