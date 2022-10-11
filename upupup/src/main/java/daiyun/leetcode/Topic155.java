package daiyun.leetcode;


import javafx.util.Pair;

import java.util.*;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 * <p>
 * 提示：
 * <p>
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 */
public class Topic155 {

    public static void main(String[] args) {

        Topic155 topic1 = new Topic155();

    }


    class MinStack {

        LinkedList<Pair<Integer, Integer>> nodes;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            nodes = new LinkedList<>();
        }

        public void push(int x) {
            if (nodes.size() > 0) {
                int preMin = nodes.peek().getValue();
                int min = Math.min(x, preMin);
                nodes.push(new Pair<>(x, min));
            } else {
                nodes.push(new Pair<>(x, x));
            }
        }

        public void pop() {
            nodes.pop();
        }

        public int top() {
            return nodes.peek().getKey();
        }

        public int getMin() {
            return nodes.peek().getValue();
        }
    }

}
