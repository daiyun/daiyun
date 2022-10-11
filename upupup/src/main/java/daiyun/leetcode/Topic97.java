package daiyun.leetcode;


import java.util.HashMap;

/**
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 */
public class Topic97 {

    public static void main(String[] args) {

        Topic97 topic1 = new Topic97();

        long start = System.currentTimeMillis();
        Topic97.SolutionA solution = topic1.new SolutionA();
        boolean res = solution.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab");

        System.out.println(res);

        System.out.println(System.currentTimeMillis() - start);
    }


    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {

            int l1 = s1 == null ? 0 : s1.length();
            int l2 = s2 == null ? 0 : s2.length();
            int l3 = s3 == null ? 0 : s3.length();


            if (l1 == 0 && l2 == 0 && l3 == 0) {
                return true;
            }
            if (l3 == 0) {
                return false;
            }

            if (l3 != l1 + l2) {
                return false;
            }

            if (s3.charAt(0) != (l1 == 0 ? 0 : s1.charAt(0))
                    && s3.charAt(0) != (l2 == 0 ? 0 : s2.charAt(0))) {
                return false;
            }

            boolean res = false;
            if (l1 != 0 && s1.charAt(0) == s3.charAt(0)) {
                res = res || isInterleave(s1.substring(1), s2, s3.substring(1));
            }
            if (l2 != 0 && s2.charAt(0) == s3.charAt(0)) {
                res = res || isInterleave(s1, s2.substring(1), s3.substring(1));
            }

            return res;
        }
    }

    class SolutionA {
        public boolean isInterleave(String s1, String s2, String s3) {

            int l1 = s1 == null ? 0 : s1.length();
            int l2 = s2 == null ? 0 : s2.length();
            int l3 = s3 == null ? 0 : s3.length();


            if (l1 == 0 && l2 == 0 && l3 == 0) {
                return true;
            }
            if (l3 == 0) {
                return false;
            }

            if (l3 != l1 + l2) {
                return false;
            }

            HashMap<Character, Integer> hashMap = new HashMap<>();

            if (s1 != null) {
                for (Character c : s1.toCharArray()) {
                    if (hashMap.containsKey(c)) {
                        hashMap.put(c, hashMap.get(c) + 1);
                    } else {
                        hashMap.put(c, 1);
                    }
                }
            }

            if (s2 != null) {
                for (Character c : s2.toCharArray()) {
                    if (hashMap.containsKey(c)) {
                        hashMap.put(c, hashMap.get(c) + 1);
                    } else {
                        hashMap.put(c, 1);
                    }
                }
            }

            if (s3 != null) {
                for (Character c : s3.toCharArray()) {
                    if (hashMap.containsKey(c)) {
                        if (hashMap.get(c) > 1) {
                            hashMap.put(c, hashMap.get(c) - 1);
                        } else {
                            hashMap.remove(c);
                        }
                    } else {
                        return false;
                    }
                }
            }

            return hashMap.size() == 0;
        }
    }

}
