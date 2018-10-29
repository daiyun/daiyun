package daiyun.leetcode;

public class Question7 {
  /**
   * 给定一个 32 位有符号整数，将整数中的数字进行反转。
   * <p>
   * 示例 1:
   * <p>
   * 输入: 123
   * 输出: 321
   * 示例 2:
   * <p>
   * 输入: -123
   * 输出: -321
   * 示例 3:
   * <p>
   * 输入: 120
   * 输出: 21
   */

  class Solution {
    public int reverse(int x) {
      long res = 0;

      int p = x;
      int y = 0;

      int flag = 1;
      if (x < 0) {
        flag = -1;
        p = p * -1;
      }


      while (p > 9) {
        y = p % 10;
        p = p / 10;
        res = res * 10 + y;
        if (res > 2147483647) {
          return 0;
        }
      }

      if (p > 0) {
        res = res * 10 + p;
        if (res > 2147483647) {
          return 0;
        }

      }

      return (int) res * flag;
    }
  }
}
