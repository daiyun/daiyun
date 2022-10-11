package daiyun.leetcode.lcci;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入: num = 1775(11011101111)
 * 输出: 8
 * 示例 2：
 * <p>
 * 输入: num = 7(0111)
 * 输出: 4
 */
public class Question0503 {

    public static void main(String[] args) {
        Question0503 question = new Question0503();

        Question0503.SolutionA solution = question.new SolutionA();

//        1143207437
//        1017033
//        11
//        31

        int rs = solution.reverseBits(1775);

        System.out.println(rs);


    }


    class Solution {
        public int reverseBits(int num) {
            StringBuffer sb = new StringBuffer();

            do {
                sb.append(num % 2);
                num = num / 2;
            } while (num != 0);

            int maxLength = 0;
            List<Integer> charCount = new ArrayList<>();
            for (int i = 0; i < sb.length(); ) {
                int count = 0;
                if (sb.charAt(i) == '1') {
                    while (i < sb.length() && sb.charAt(i) == '1') {
                        count++;
                        i++;
                    }
                } else {
                    i++;
                }
                charCount.add(count);
                if (count == 0) {
                    if (charCount.size() > 1 && charCount.get(charCount.size() - 2) > 0) {
                        if (charCount.get(charCount.size() - 2) + 1 > maxLength) {
                            maxLength = charCount.get(charCount.size() - 2) + 1;
                        }
                    } else {
                        if (1 > maxLength) {
                            maxLength = 1;
                        }
                    }
                } else {
                    if (charCount.size() > 2) {
                        if (charCount.get(charCount.size() - 3) + count + 1 > maxLength) {
                            maxLength = charCount.get(charCount.size() - 3) + count + 1;
                        }
                    } else {
                        if (count + 1 > maxLength) {
                            maxLength = count + 1;
                        }
                    }
                }
            }

            return maxLength;
        }
    }

    class SolutionA {
        public int reverseBits(int num) {

            int maxLength = 0;
            int numCount = 0;
            int preNumCount = 0;

            while (num != 0) {
                if (num % 2 == 0) {
                    if (maxLength < numCount + preNumCount + 1) {
                        maxLength = numCount + preNumCount + 1;
                    }
                    preNumCount = numCount;
                    numCount = 0;
                } else {
                    numCount++;
                }
                num = num >> 1;
            }
            if (maxLength < numCount + preNumCount + 1) {
                maxLength = numCount + preNumCount + 1;
            }

            return maxLength;
        }
    }

}
