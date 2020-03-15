package daiyun.leetcode;


import javafx.util.Pair;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class Topic127 {

    public static void main(String[] args) {

        Topic127 topic1 = new Topic127();

        Solution solution = topic1.new Solution();

        long start = System.currentTimeMillis();

        List<String> list = new ArrayList<>(Arrays.asList(new String[]{"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"}));


        int res = solution.ladderLength("qa", "sq", list);

        System.out.println(res);

        System.out.println(System.currentTimeMillis() - start);
    }


    class Solution {

        Set<String> sets = null;
        Map<String, Integer> isMetch = new HashMap<>();

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            System.out.println("len:" + wordList.size());
            if (wordList == null) {
                return 0;
            }

            if (sets == null) {
                sets = new HashSet<>(wordList);
            }


            if (sets.contains(endWord)) {

                int diffCount = diffCount(beginWord, endWord);
                if (diffCount == 1) {
                    return 2;
                }

                Integer minCount = null;
                for (int j = 0; j < wordList.size(); j++) {
                    String temp = wordList.get(j);

                    int diff = diffCount(temp, beginWord);

                    if (diff == 1) {
                        LinkedList<String> list = new LinkedList<>(wordList);
                        list.remove(j);

                        int count = ladderLength(temp, endWord, list);

                        if (minCount == null || count < minCount) {
                            minCount = count;
                        }

                        if (count == 2) {
                            break;
                        }
                    }

                }
                if (minCount != null) {
                    return minCount + 1;
                }
            }
            return 0;
        }

        public int diffCount(String beginWord, String endWord) {
            int diffCount = 0;
            int len = beginWord.length();
            for (int i = 0; i < len; i++) {
                char a = beginWord.charAt(i);
                char b = endWord.charAt(i);
                if (a != b) {
                    diffCount++;
                    if (diffCount > 1) {
                        break;
                    }
                }
            }
            return diffCount;
        }


    }

    class SolutionA {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            // Since all words are of same length.
            int L = beginWord.length();

            // Dictionary to hold combination of words that can be formed,
            // from any given word. By changing one letter at a time.
            HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

            wordList.forEach(
                    word -> {
                        for (int i = 0; i < L; i++) {
                            // Key is the generic word
                            // Value is a list of words which have the same intermediate generic word.
                            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                            ArrayList<String> transformations =
                                    allComboDict.getOrDefault(newWord, new ArrayList<String>());
                            transformations.add(word);
                            allComboDict.put(newWord, transformations);
                        }
                    });

            // Queue for BFS
            Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
            Q.add(new Pair(beginWord, 1));

            // Visited to make sure we don't repeat processing same word.
            HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
            visited.put(beginWord, true);

            while (!Q.isEmpty()) {
                Pair<String, Integer> node = Q.remove();
                String word = node.getKey();
                int level = node.getValue();
                for (int i = 0; i < L; i++) {

                    // Intermediate words for current word
                    String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                    // Next states are all the words which share the same intermediate state.
                    for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                        // If at any point if we find what we are looking for
                        // i.e. the end word - we can return with the answer.
                        if (adjacentWord.equals(endWord)) {
                            return level + 1;
                        }
                        // Otherwise, add it to the BFS Queue. Also mark it visited
                        if (!visited.containsKey(adjacentWord)) {
                            visited.put(adjacentWord, true);
                            Q.add(new Pair(adjacentWord, level + 1));
                        }
                    }
                }
            }

            return 0;
        }
    }

}
