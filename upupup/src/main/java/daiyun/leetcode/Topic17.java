package daiyun.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Topic17 {

    public static void main(String[] args) {

        Topic17 topic1 = new Topic17();

        Solution solution = topic1.new Solution();


        solution.letterCombinations("23");


    }


    class Solution {

        Map<String, String> phone = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};

        List<String> res = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() != 0) {
                letterCombinations2("", digits);
            }
            return res;
        }


        public void letterCombinations2(String pre, String nextStr) {
            if (nextStr.length() == 0) {
                res.add(pre);
            } else {
                String letter = nextStr.charAt(0) + "";
                String curStr = phone.get(letter);
                for (int i = 0; i < curStr.length(); i++) {
                    letterCombinations2(pre + curStr.charAt(i), nextStr.substring(1));
                }
            }
        }
    }

}
