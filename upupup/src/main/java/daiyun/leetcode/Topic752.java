package daiyun.leetcode;

import java.util.*;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 * <p>
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *  
 * <p>
 * 提示：
 * <p>
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 */
public class Topic752 {

    public static void main(String[] args) {

        Topic752 topic1 = new Topic752();

        Solution solution = topic1.new Solution();

        System.out.println(solution.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }


    class Solution {
        public int openLock(String[] deadends, String target) {
            Set<String> deadSet = new HashSet<>();
            if (deadends != null) {
                deadSet.addAll(Arrays.asList(deadends));
            }

            Set<String> search = new HashSet<>();
            search.add("0000");

            int step = 0;

            Queue<String> queue = new ArrayDeque<>();
            queue.add("0000");
            queue.add("");

            while (queue.size() > 0) {
                String node = queue.poll();
                if (deadSet.contains(node)) {
                    continue;
                }
                if (target.equals(node)) {
                    return step;
                } else if ("".equals(node)) {
                    step++;
                    if (queue.size() > 0) {
                        queue.offer("");
                    }
                } else {
                    for (int i = 0; i < 4; ++i) {
                        for (int d = -1; d <= 1; d += 2) {
                            int y = ((node.charAt(i) - '0') + d + 10) % 10;
                            String nei = node.substring(0, i) + ("" + y) + node.substring(i + 1);
                            if (!search.contains(nei)) {
                                search.add(nei);
                                queue.offer(nei);
                            }
                        }
                    }
                }
            }

            return -1;
        }

        public int nextChar(int a) {
            if (a == 9) {
                return 0;
            }
            return a + 1;
        }

        public int preChar(int a) {
            if (a == 0) {
                return 0;
            }
            return a - 1;
        }

        class MyStack {
            List<Integer> list = null;

            /** Initialize your data structure here. */
            public MyStack() {
                list = new ArrayList<>();
            }

            /** Push element x onto stack. */
            public void push(int x) {
                list.add(x);
            }

            /** Removes the element on top of the stack and returns that element. */
            public int pop() {
                return list.remove(list.size()-1);
            }

            /** Get the top element. */
            public int top() {
                return list.get(list.size()-1);
            }

            /** Returns whether the stack is empty. */
            public boolean empty() {
                return list.size() == 0;
            }
        }
    }


}
