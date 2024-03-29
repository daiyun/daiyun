package daiyun.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Topic9 {

    public static void main(String[] args) {

        String a = new String();
        char[] chars = a.toCharArray();

        Topic9 topic1 = new Topic9();

        Solution solution = topic1.new Solution();


        System.out.println(solution.isPalindrome(111111111));
    }


    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }

            int revertedNumber = 0;
            while(x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x /= 10;
            }
            return x == revertedNumber || x == revertedNumber/10;
        }
    }


}
