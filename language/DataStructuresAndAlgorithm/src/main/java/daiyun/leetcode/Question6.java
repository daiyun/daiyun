package daiyun.leetcode;

public class Question6 {

  /**
   * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
   * <p>
   * P   A   H   N
   * A P L S I I G
   * Y   I   R
   * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
   * <p>
   * 实现一个将字符串进行指定行数变换的函数:
   * <p>
   * string convert(string s, int numRows);
   * 示例 1:
   * <p>
   * 输入: s = "PAYPALISHIRING", numRows = 3
   * 输出: "PAHNAPLSIIGYIR"
   * 示例 2:
   * <p>
   * 输入: s = "PAYPALISHIRING", numRows = 4
   * 输出: "PINALSIGYAHRPI"
   * 解释:
   * <p>
   * P     I    N
   * A   L S  I G
   * Y A   H R
   * P     I
   */
  class Solution {
    public String convert(String s, int numRows) {

      int oneR = (numRows - 1) * 2;

      if (oneR == 0) {
        return s;
      }

      int sLength = s.length();

      int arrLength = sLength / oneR;

      if (sLength % oneR != 0) {
        arrLength = arrLength + 1;
      }

      arrLength = arrLength * 2;


      char[][] arrs = new char[numRows][arrLength];

      int p = 0;
      for (int i = 0; i < arrLength; i++) {
        if (i % 2 == 0 || numRows == 2) {
          for (int j = 0; j < numRows; j++) {
            if (p < sLength) {
              arrs[j][i] = s.charAt(p++);
            } else {
              break;
            }
          }
        } else {
          for (int j = numRows - 2; j > 0; j--) {
            if (p < sLength) {
              arrs[j][i] = s.charAt(p++);
            } else {
              break;
            }
          }
        }
      }

      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < arrLength; j++) {
          if (arrs[i][j] != 0) {
            sb.append(arrs[i][j]);
          }
        }
      }


      return sb.toString();
    }
  }
}

/*
0   2    4       6

0   6    12     18   2*(4-1)*(k/2-1)
1 5 7 11 13  17 19
2 4 8 10 14  16 20
3   9    15

0   4   8           2*(3-1)*(k/2-1)
1 3 5 7 9
2   6
    1 1
1 1
2 2
3 4  2*(n-1);
4 6*/
