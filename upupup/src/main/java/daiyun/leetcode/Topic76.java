package daiyun.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Topic76 {

    public static void main(String[] args) {

        Topic76 topic1 = new Topic76();

        Solution solution = topic1.new Solution();


        //"aaaaaaaaaaaabbbbbcdd"
        //"abcdd"

//        String res = solution.minWindow("wegdtzwabazduwwdysdetrrctotpcepalxdewzezbfewbabbseinxbqqplitpxtcwwhuyntbtzxwzyaufihclztckdwccpeyonumbpnuonsnnsjscrvpsqsftohvfnvtbphcgxyumqjzltspmphefzjypsvugqqjhzlnylhkdqmolggxvneaopadivzqnpzurmhpxqcaiqruwztroxtcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanllpunlyohwfsssiazeixhebipfcdqdrcqiwftutcrbxjthlulvttcvdtaiwqlnsdvqkrngvghupcbcwnaqiclnvnvtfihylcqwvderjllannflchdklqxidvbjdijrnbpkftbqgpttcagghkqucpcgmfrqqajdbynitrbzgwukyaqhmibpzfxmkoeaqnftnvegohfudbgbbyiqglhhqevcszdkokdbhjjvqqrvrxyvvgldtuljygmsircydhalrlgjeyfvxdstmfyhzjrxsfpcytabdcmwqvhuvmpssingpmnpvgmpletjzunewbamwiirwymqizwxlmojsbaehupiocnmenbcxjwujimthjtvvhenkettylcoppdveeycpuybekulvpgqzmgjrbdrmficwlxarxegrejvrejmvrfuenexojqdqyfmjeoacvjvzsrqycfuvmozzuypfpsvnzjxeazgvibubunzyuvugmvhguyojrlysvxwxxesfioiebidxdzfpumyon", "ozgzyywxvtublcl");
//        String res = solution.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd");
        String res = solution.minWindow("ADOBECODEBANC", "A");

        System.out.println(res);
    }


    class Solution {
        public String minWindow(String s, String t) {
            if (s == null || s.length() == 0 || t == null || s.length() < t.length()) {
                return "";
            }

            if (s.equals(t)) {
                return s;
            }

            int len = s.length();
            HashMap<Character, Integer> sets = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                Character ch = t.charAt(i);
                if (sets.containsKey(ch)) {
                    int count = sets.get(ch) + 1;
                    sets.put(ch, count);
                } else {
                    sets.put(ch, 1);
                }
            }

            int start = -1;
            LinkedList<Integer> nextIndex = new LinkedList<>();
            String res = "";

            HashMap<Character, Integer> tempSets = new HashMap<>(sets);
            HashMap<Character, Integer> count = new HashMap<>();
            for (int i = 0; i < len; i++) {
                Character ch = s.charAt(i);

                if (count.containsKey(ch)) {
                    count.put(ch, count.get(ch) + 1);
                } else {
                    count.put(ch, 1);
                }

                if (tempSets.containsKey(ch)) {

                    if (start < 0) {
                        start = i;
                    }
                    if (i != start) {
                        nextIndex.add(i);
                    }
                    int cu = tempSets.get(ch);
                    if (cu == 1) {
                        tempSets.remove(ch);
                    } else {
                        tempSets.put(ch, cu - 1);
                    }

                    if (tempSets.size() == 0) {

                        while (nextIndex.size() >= t.length()) {
                            Character temp = s.charAt(start);
                            if (count.get(temp) > sets.get(temp)) {
                                int p = count.get(temp);
                                if (p == 1) {
                                    count.remove(temp);
                                } else {
                                    count.put(temp, p - 1);
                                }
                                start = nextIndex.pollFirst();
                            } else {
                                break;
                            }
                        }

                        tempSets.put(s.charAt(start), 1);

                        Character temp = s.charAt(start);
                        int p = count.get(temp);
                        if (p == 1) {
                            count.remove(temp);
                        } else {
                            count.put(temp, p - 1);
                        }

                        if ("".equals(res) || s.substring(start, i).length() < res.length()) {
                            res = s.substring(start, i + 1);
                        }

                        if (nextIndex.size() > 0) {
                            start = nextIndex.pollFirst();
                        } else {
                            break;
                        }

                    }

                } else {
                    if (sets.containsKey(ch)) {
                        nextIndex.add(i);
                    }
                }
            }


            return res;
        }
    }


}
