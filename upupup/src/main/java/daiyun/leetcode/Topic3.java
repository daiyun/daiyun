package daiyun.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class Topic3 {

    public static void main(String[] args) {

        Topic3 topic1 = new Topic3();

        SolutionA solution = topic1.new SolutionA();

        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            int[] index = new int[128]; // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                i = Math.max(index[s.charAt(j)], i);
                index[s.charAt(j)] = j + 1;
                ans = Math.max(ans, j - i + 1);
            }
            return ans;
           /* int maxLength = 0;
            int pre = 0;
            int next = 0;

            Set<Character> set = new HashSet<>();
            while (next < s.length()) {
                if (set.size() == 0
                        || !set.contains(s.charAt(next))) {

                    set.add(s.charAt(next));
                    next++;

                    if (maxLength < (next - pre)) {
                        maxLength = next - pre;
                    }
                } else {
                    set.remove(s.charAt(pre));
                    pre++;
                }
            }

            return maxLength;*/
        }
    }

    class SolutionA {
        public int lengthOfLongestSubstring(String s) {
            if (s == null) {
                return 0;
            }

            int res = 1;
            if (s.length() < 2) {
                return s.length();
            }

            Set<Character> chars = new HashSet<>();

            int left = 0;
            int right = 0;

            while (right < s.length()) {
                Character charP = s.charAt(right);
                if (chars.contains(charP)) {
                    while (left < right) {
                        Character charH = s.charAt(left);
                        left++;
                        if (charH.equals(charP)) {
                            break;
                        }
                        chars.remove(charH);
                    }
                } else {
                    chars.add(charP);
                }

                int max = right - left + 1;
                if (res < max) {
                    res = max;
                }
                right++;
            }


            return res;
        }
    }

}
