package daiyun.leetcode.lcci;

import java.util.Stack;

/**
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * <p>
 * 说明：
 * <p>
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
public class Question0304 {

    public static void main(String[] args) {
        Question0304 question = new Question0304();


//        "sdfsdsdssdfs"
//        "dssdfs"
//        "sdfsds"
//        27


    }


    static class MyQueue {

        /**
         * Initialize your data structure here.
         */
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> outStack = new Stack<>();

        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            while (stack.size() > 0) {
                outStack.push(stack.pop());
            }

            int res = outStack.pop();
            while (outStack.size() > 0) {
                stack.push(outStack.pop());
            }
            return res;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            while (stack.size() > 0) {
                outStack.push(stack.pop());
            }

            int res = 0;
            if (outStack.size() > 0) {
                res = outStack.peek();
            }
            while (outStack.size() > 0) {
                stack.push(outStack.pop());
            }
            return res;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.empty();
        }
    }
}
