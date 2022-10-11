package daiyun.leetcode.offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class Offer1 {

    public static void main(String[] args) {


        CQueue cQueue = new CQueue();

        cQueue.appendTail(5);
        cQueue.appendTail(2);

        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    static class CQueue {

        Stack<Integer> stackA;
        Stack<Integer> stackB;

        public CQueue() {
            stackA = new Stack<Integer>();
            stackB = new Stack<Integer>();
        }

        public void appendTail(int value) {
            stackA.push(value);
        }

        public int deleteHead() {

            while (stackA.size() > 0) {
                stackB.push(stackA.pop());
            }

            int res = -1;
            if (stackB.size() > 0) {
                res = stackB.pop();

                while (stackB.size() > 0) {
                    stackA.push(stackB.pop());
                }
            }


            return res;
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

}
