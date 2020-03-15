package daiyun.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 */
public class Topic5 {

    public static void main(String[] args) {

        Topic5 topic1 = new Topic5();

        Solution solution = topic1.new Solution();

        System.out.println(solution.longestPalindrome2("babad"));

    }

    class Solution {

        /**
         * 动态规划
         *
         * @param s
         * @return
         */
        public String longestPalindrome2(String s) {
            String ans = "";
            int length = s.length();
            boolean[][] p = new boolean[length][length];

            for (int i = 0; i < length; i++) {
                for (int j = i; j >=0; j--) {
                    if (s.charAt(i) == s.charAt(j) && (i - j < 2 || p[j + 1 ][i - 1])) {
                        p[i][j] = true;

                        if (i - j + 1 > ans.length()) {
                            ans = s.substring(j, i + 1);
                        }
                    }
                }
            }
            return ans;
        }

        /**
         * 中心扩展算法
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            if (s.length() < 1) {
                return "";
            }

            int start = 0;
            int end = 0;

            for (int i = 0; i < s.length(); i++) {

                int child1 = maxLengthStr(s, i, i);
                int child2 = maxLengthStr(s, i, i + 1);

                int child = Math.max(child1, child2);
                if (child > start - end) {
                    start = i - (child - 1) / 2;
                    end = i + child / 2;
                }
            }

            return s.substring(start, end + 1);
        }

        public int maxLengthStr(String s, int start, int end) {
            int L = start;
            int R = end;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            return R - L - 1;
        }
    }


    /**
     * 最长公共子序列长度
     */
    class SolutionA {
        public int longestPalindrome(String s1, String s2) {
            if (s1.length() < 1 || s2.length() < 1) {
                return 0;
            }
            if (s1.charAt(0) == s2.charAt(0)) {
                return longestPalindrome(s1.substring(1, s1.length()), s2.substring(1, s2.length())) + 1;
            } else {
                return Math.max(longestPalindrome(s1.substring(1, s1.length()), s2)
                        , longestPalindrome(s1, s2.substring(1, s2.length())));
            }
        }
    }

    /**
     * 最长公共子序列
     */
    class SolutionB {
        public String longestPalindrome(String s1, String s2) {
            if (s1.length() < 1 || s2.length() < 1) {
                return "";
            }
            if (s1.charAt(0) == s2.charAt(0)) {
                return s1.charAt(0) + longestPalindrome(s1.substring(1, s1.length()), s2.substring(1, s2.length()));
            } else {
                String child1 = longestPalindrome(s1.substring(1, s1.length()), s2);
                String child2 = longestPalindrome(s1, s2.substring(1, s2.length()));
                if (child1.length() > child2.length()) {
                    return child1;
                } else {
                    return child2;
                }
            }
        }
    }

    /**
     * 最长子公共子串长度
     */
    class SolutionC {
        public int longestPalindrome(String s1, String s2, int index1, int index2) {
            if (index1 > s1.length() || index2 > s2.length()) {
                return 0;
            }
            int length = 0;
            int p1 = index1;
            int p2 = index2;
            while (p1 < s1.length() && p2 < s2.length() && s1.charAt(p1) == s2.charAt(p2)) {
                p1++;
                p2++;
                length++;
            }


            int length1 = longestPalindrome(s1, s2, index1 + 1, index2);
            int length2 = longestPalindrome(s1, s2, index1, index2 + 1);

            if (length > length1 && length > length2) {
                return length;
            } else if (length1 > length && length1 > length2) {
                return length1;
            } else {
                return length2;
            }

        }
    }

    /**
     * 最长公共子串
     */
    class SolutionD {
        public String longestPalindrome(String s1, String s2, int index1, int index2) {
            if (index1 > s1.length() || index2 > s2.length()) {
                return "";
            }
            String childStr = "";
            int p1 = index1;
            int p2 = index2;
            while (p1 < s1.length() && p2 < s2.length() && s1.charAt(p1) == s2.charAt(p2)) {
                childStr = childStr + s1.charAt(p1);
                p1++;
                p2++;
            }

            String child1 = longestPalindrome(s1, s2, index1 + 1, index2);
            String child2 = longestPalindrome(s1, s2, index1, index2 + 1);

            if (childStr.length() > child1.length() && childStr.length() > child2.length()) {
                return childStr;
            } else if (child1.length() > child2.length() && child1.length() > childStr.length()) {
                return child1;
            } else {
                return child2;
            }
        }
    }

}
