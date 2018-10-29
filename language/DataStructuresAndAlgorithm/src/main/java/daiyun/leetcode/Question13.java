package daiyun.leetcode;

public class Question13 {

  public static void main(String[] args) {
    String s = "asdfg";
    System.out.println(s.substring(3, 5));
  }

  class Sulution {
    public int romanToInt(String s) {

      int res = 0;
      int p = s.length();
      while (p > 0) {
        String temp = "";
        if (p - 2 >= 0) {
          temp = s.substring(p - 2, p);
        }

        if (temp.equals("IV")) {
          res += 4;
          p = p - 2;
        } else if (temp.equals("IX")) {
          res += 9;
          p = p - 2;
        } else if (temp.equals("XL")) {
          res += 40;
          p = p - 2;
        } else if (temp.equals("XC")) {
          res += 90;
          p = p - 2;
        } else if (temp.equals("CD")) {
          res += 400;
          p = p - 2;
        } else if (temp.equals("CM")) {
          res += 900;
          p = p - 2;
        } else {
          temp = s.substring(p - 1, p);
          if (temp.equals("I")) {
            res += 1;
            p = p - 1;
          } else if (temp.equals("V")) {
            res += 5;
            p = p - 1;
          } else if (temp.equals("X")) {
            res += 10;
            p = p - 1;
          } else if (temp.equals("L")) {
            res += 50;
            p = p - 1;
          } else if (temp.equals("C")) {
            res += 100;
            p = p - 1;
          } else if (temp.equals("D")) {
            res += 500;
            p = p - 1;
          } else if (temp.equals("M")) {
            res += 1000;
            p = p - 1;
          }
        }
      }
      return res;
    }
  }
}
