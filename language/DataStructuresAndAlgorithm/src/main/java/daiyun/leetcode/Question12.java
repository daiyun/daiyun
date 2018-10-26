package daiyun.leetcode;

public class Question12 {

  class Solution {
    public String intToRoman(int num) {

      StringBuffer res = new StringBuffer();
      while (num > 0) {
        if (num >= 1000) {
          num = num - 1000;
          res.append("M");
        } else if (num >= 900) {
          num = num - 900;
          res.append("CM");
        } else if (num >= 500) {
          num = num - 500;
          res.append("D");
        } else if (num >= 400) {
          num = num - 400;
          res.append("CD");
        } else if (num >= 100) {
          num = num - 100;
          res.append("C");
        } else if (num >= 90) {
          num = num - 90;
          res.append("XC");
        } else if (num >= 50) {
          num = num - 50;
          res.append("L");
        } else if (num >= 40) {
          num = num - 40;
          res.append("XL");
        } else if (num >= 10) {
          num = num - 10;
          res.append("X");
        } else if (num >= 9) {
          num = num - 9;
          res.append("IX");
        } else if (num >= 5) {
          num = num - 5;
          res.append("V");
        } else if (num >= 4) {
          num = num - 4;
          res.append("IV");
        } else if (num >= 1) {
          num = num - 1;
          res.append("I");
        }
      }

      return res.toString();
    }
  }
}
