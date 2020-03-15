package daiyun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Topic49 {

    public static void main(String[] args) {

        Topic49 topic1 = new Topic49();

        Solution solution = topic1.new Solution();

        solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        System.out.println();
    }


    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new ArrayList<>();
            HashMap<String, Integer> knowWorlds = new HashMap();

            for (String str : strs) {
                char[] lets = str.toCharArray();
                Arrays.sort(lets);
                String k = new String(lets);
                if (knowWorlds.containsKey(k)) {
                    int index = knowWorlds.get(k);
                    res.get(index).add(str);
                } else {
                    knowWorlds.put(k, res.size());
                    List<String> tmep = new ArrayList<>();
                    tmep.add(str);
                    res.add(tmep);
                }
            }

            return res;
        }
    }

}
