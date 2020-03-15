package daiyun.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 */
public class Topic30 {

    public static void main(String[] args) {

        Topic30 topic1 = new Topic30();

        Solution solution = topic1.new Solution();


        solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});

    }

    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            if (words == null || words.length == 0) {
                return null;
            }

            List<Integer> ans = new ArrayList<>();

            int arrLen = words.length;
            int len = words[0].length();
            HashMap<String, Integer> wordsMap = new HashMap<>();
            for (String str : words) {
                wordsMap.put(str, wordsMap.getOrDefault(str, 0) + 1);
            }


            for (int i = 0; i < s.length() - arrLen * len; i++) {
                String firstStr = s.substring(i, i + len);
                if (!wordsMap.containsKey(firstStr)) {
                    continue;
                }

                HashMap<String, Integer> metchRes = new HashMap<>(wordsMap);
                for (int j = i; j < i + arrLen * len; j = j + len) {
                    String wordsOrder = s.substring(j, j + len);
                    if (!metchRes.containsKey(wordsOrder)) {
                        break;
                    }
                    Integer curSize = metchRes.get(wordsOrder);
                    if (curSize > 1) {
                        metchRes.put(wordsOrder, curSize - 1);
                    } else {
                        metchRes.remove(wordsOrder);
                    }
                }

                if (metchRes.size() == 0) {
                    ans.add(i);
                }
            }

            return ans;
        }
    }
}
