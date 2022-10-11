package daiyun.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic93 {

    public static void main(String[] args) {

        Topic93 topic1 = new Topic93();

        Solution solution = topic1.new Solution();

        long start = System.currentTimeMillis();

        solution.restoreIpAddresses("25525511135");
        System.out.println(System.currentTimeMillis() - start);
    }


    class Solution {
        public List<String> restoreIpAddresses(String s) {
            return restoreIpAddresses(s.toCharArray(), 4);
        }

        public List<String> restoreIpAddresses(char[] s, int size) {
            List<String> res = new ArrayList<>();
            if (s == null || s.length < size || s.length > size * 3) {
                return res;
            }

            if (size == 1) {
                int bitNum = Integer.parseInt(new String(s));
                if (s.length == 1) {
                    res.add(new String(s));
                } else if (s.length == 2) {
                    if (bitNum >= 10) {
                        res.add(new String(s));
                    }
                } else {
                    if (bitNum >= 100 && bitNum <= 255) {
                        res.add(new String(s));
                    }
                }
                return res;
            }

            List<String> one = restoreIpAddresses(Arrays.copyOf(s, s.length - 1), size - 1);
            if (one.size() > 0) {
                for (String str : one) {
                    res.add(str + "." + s[s.length - 1]);
                }
            }

            if (s.length - 2 > 0) {
                int bitNum = Integer.parseInt("" + s[s.length - 2] + s[s.length - 1]);
                if (bitNum >= 10 && bitNum <= 99) {
                    List<String> two = restoreIpAddresses(Arrays.copyOf(s, s.length - 2), size - 1);
                    if (two.size() > 0) {
                        for (String str : two) {
                            res.add(str + "." + s[s.length - 2] + s[s.length - 1]);
                        }
                    }
                }
            }

            if (s.length - 3 > 0) {
                int bitNum = Integer.parseInt("" + s[s.length - 3] + s[s.length - 2] + s[s.length - 1]);

                if (bitNum >= 100 && bitNum <= 255) {
                    List<String> three = restoreIpAddresses(Arrays.copyOf(s, s.length - 3), size - 1);
                    if (three.size() > 0) {
                        for (String str : three) {
                            res.add(str + "." + bitNum);
                        }
                    }
                }
            }

            return res;
        }
    }

}
