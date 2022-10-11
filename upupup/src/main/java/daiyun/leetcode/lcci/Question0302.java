package daiyun.leetcode.lcci;

import java.util.Stack;

/**
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，
 * 该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class Question0302 {

    public static void main(String[] args) {
        Question0302 question = new Question0302();


//        "sdfsdsdssdfs"
//        "dssdfs"
//        "sdfsds"
//        27

    }


    class MinStack {

        Stack<StackNode> stack = new Stack<>();

        class StackNode {
            int val;
            int min;

            public StackNode(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (stack.size() == 0) {
                stack.push(new StackNode(x, x));
            } else {
                stack.push(new StackNode(x, Math.min(x, stack.peek().min)));
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            if (stack.size() > 0) {
                return stack.peek().val;
            }
            return -1;
        }

        public int getMin() {
            if (stack.size() > 0) {
                return stack.peek().min;
            }
            return -1;
        }
    }
}
