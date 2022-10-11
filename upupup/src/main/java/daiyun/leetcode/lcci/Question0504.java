package daiyun.leetcode.lcci;

/**
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 * <p>
 * 示例1:
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出：[4, 1] 或者（[0b100, 0b1]）
 * 示例2:
 * <p>
 * 输入：num = 1
 * 输出：[2, -1]
 * 提示:
 * <p>
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 */
public class Question0504 {

    public static void main(String[] args) {
        Question0504 question = new Question0504();

        Question0504.Solution solution = question.new Solution();

//        1143207437
//        1017033
//        11
//        31

        int[] rs = solution.findClosedNumbers(5);

        System.out.println(rs[0]);
        System.out.println(rs[1]);

//        System.out.println(Integer.parseInt("2", 2));


    }


    class Solution {
        public int[] findClosedNumbers(int num) {

            StringBuffer bitList = new StringBuffer();

            int bit0Size = 0;
            int source = num;
            int i = 0;
            int first = 0;
            while (source != 0) {
                int a = source % 2;
                if (a == 0) {
                    bit0Size++;
                    if (bit0Size == 1) {
                        first = i;
                    }
                }
                bitList.append(a);
                source = source >> 1;
                i++;
            }


            if (bit0Size == 0) {
                if (i > 30) {
                    return new int[]{-1, -1};
                }
                StringBuffer bitList2 = new StringBuffer();
                bitList2.append(bitList);
                bitList2.insert(bitList2.length() - 1, '0');
                return new int[]{Integer.parseInt(new String(bitList2.reverse()), 2), -1};
            }

            String maxBit = null;
            StringBuffer sb2 = new StringBuffer(bitList);
            if (first == 0) {
                int maxFirst = first;
                boolean bit1Flag = false;
                int bit0Count = 1;
                int bit1Count = 0;
                maxFirst++;
                while (maxFirst < sb2.length() && (sb2.charAt(maxFirst) == '1' || bit1Count < 1)) {
                    if (sb2.charAt(maxFirst) == '1') {
                        bit1Count++;
                    } else {
                        bit0Count++;
                    }
                    maxFirst++;
                }
                if (maxFirst >= sb2.length()) {
                    sb2.insert(sb2.length() - 1, '0');
                    sb2.setCharAt(sb2.length() - 3, '0');
                    int k = 0;
                    bit1Count--;
                    while (bit1Count > 0) {
                        sb2.setCharAt(k++, '1');
                        bit1Count--;
                    }
                } else {
                    sb2.setCharAt(maxFirst--, '1');
                    sb2.setCharAt(maxFirst--, '0');
                    while (bit0Count > 0) {
                        sb2.setCharAt(maxFirst--, '0');
                        bit0Count--;
                    }
                    while (maxFirst >= 0) {
                        sb2.setCharAt(maxFirst--, '1');
                    }
                }

                maxBit = new String(sb2.reverse());
            } else {
                sb2.setCharAt(first, '1');
                sb2.setCharAt(first - 1, '0');

                maxBit = new String(sb2.reverse());
            }

            String minBit = null;
            int j = first;
            int count0 = 0;
            while (bitList.charAt(j) == '0') {
                count0++;
                j++;
            }
            bitList.setCharAt(j, '0');
            j--;
            while (first >= 0) {
                bitList.setCharAt(j--, '1');
                first--;
            }
            while (j >= 0) {
                bitList.setCharAt(j--, '0');
            }

            minBit = new String(bitList.reverse());

            return new int[]{Integer.parseInt(maxBit, 2), Integer.parseInt(minBit, 2)};

        }
    }

}
