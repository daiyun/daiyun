package daiyun.leetcode;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 6.     21112211
 * 7.     1221112221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 */
public class Topic38 {

    public static void main(String[] args) {

        Topic38 topic1 = new Topic38();

        Solution solution = topic1.new Solution();

        String str = solution.countAndSay(5);

        System.out.println(str);


    }

    class Solution {
        public String countAndSay(int n) {
            if (n == 1) {
                return "1";
            }

            String pre = countAndSay(n - 1);

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < pre.length(); i++) {
                char cur = pre.charAt(i);
                if (i + 1 < pre.length()) {
                    char next = pre.charAt(i + 1);
                    if (cur == next) {
                        sb.append("2" + cur);
                        i++;
                    } else {
                        sb.append("1" + cur);
                    }
                } else {
                    sb.append("1" + cur);
                }
            }

            return sb.toString();

        }
    }
}
