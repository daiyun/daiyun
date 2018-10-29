package daiyun.leetcode;

/**
 * @author godaiyun
 * @date 2018-10-29 09:49.
 */
public class Question29 {

  public static void main(String[] args) {

    Question29 question29 = new Question29();
    Question29.SolutionB solution = question29.new SolutionB();


    System.out.println(solution.divide(10, 3));
  }


  class Solution {
    public int divide(int dividend, int divisor) {

      int res = 0;

      int flag = 1;
      if (dividend < 0 && divisor > 0) {
        divisor = -divisor;
        flag = -1;
      } else if (dividend > 0 && divisor < 0) {
        dividend = -dividend;
        flag = -1;
      }

      while (dividend == Integer.MIN_VALUE || Math.abs(dividend) >= Math.abs(divisor)) {
        if (res == Integer.MAX_VALUE) {
          return Integer.MAX_VALUE;
        }
        res++;
        dividend = dividend - divisor;
      }

      if (flag == 1) {
        return res;
      } else {
        return -res;
      }
    }
  }

  class SolutionB {
    public int divide(int dividend, int divisor) {
      if (dividend == Integer.MIN_VALUE && divisor == -1) {
        return Integer.MAX_VALUE;
      }

      long a = (long) dividend;
      long b = (long) divisor;

      int flag = 1;

      if (a < 0 && b < 0) {
        a = -a;
        b = -b;
      } else if (a > 0 && b < 0) {
        b = -b;
        flag = -1;
      } else if (a < 0 && b > 0) {
        a = -a;
        flag = -1;
      }

      int maxN = 0;

      while (a >= b) {
        int cur = 1;
        long temp = b;
        while (a >= (temp << 1)) {
          temp = temp << 1;
          cur = cur << 1;
        }
        a = a - temp;
        maxN = maxN + cur;
      }

      if (flag == 1) {
        return maxN;
      } else {
        return -maxN;
      }
    }
  }
}
