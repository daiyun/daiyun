package daiyun.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class Topic91 {

    public static void main(String[] args) {

        Topic91 topic1 = new Topic91();

        SolutionA solution = topic1.new SolutionA();

        long start = System.currentTimeMillis();

        int res = solution.numDecodings("100");

        System.out.println(res);

        System.out.println(System.currentTimeMillis() - start);
    }


    class Solution {
        public int numDecodings(String s) {
            int res = 0;
            if (s.length() < 1) {
                return res;
            }
            res = 1;
            int len = s.length();

            List<Integer> doubueIndex = new ArrayList<>();
            for (int i = 0; i < len - 1; i++) {
                int charValue = s.charAt(i) - '0';
                if (charValue < 3) {
                    int nextValue = s.charAt(i + 1) - '0';
                    if (nextValue < 7) {
                        doubueIndex.add(i);
                    }
                }
            }

            res = res + doubueIndex.size();

            for (int i = 2; i <= doubueIndex.size(); i++) {


            }

            return res;
        }
    }

    class SolutionA {
        public int numDecodings(String s) {
            if (s.length() < 1) {
                return 0;
            }
            int len = s.length();

            int[] res = new int[len + 1];

            if (s.charAt(0) == '0') {
                return 0;
            }
            res[1] = 1;
            res[0] = 1;

            for (int i = 2; i <= len; i++) {
                int charValue = s.charAt(i - 1) - '0';

                if (charValue > 0) {
                    if (s.charAt(i - 2) == '1' || (charValue < 7 && s.charAt(i - 2) == '2')) {
                        res[i] = res[i - 2] + res[i - 1];
                    } else {
                        res[i] = res[i - 1];
                    }
                } else {
                    if (s.charAt(i - 2) > '2' || s.charAt(i - 2) == '0') {
                        return 0;
                    }
                    res[i] = res[i - 2];
                }
            }


            return res[len];
        }
    }

}
