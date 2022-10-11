package daiyun.leetcode.lcci;

import java.util.Stack;

/**
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，
 * 但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。
 * 当栈为空时，peek 返回 -1。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null,null,null,1,null,2]
 * 示例2:
 * <p>
 * 输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 * 输出：
 * [null,null,null,null,null,true]
 * 说明:
 * <p>
 * 栈中的元素数目在[0, 5000]范围内。
 */
public class Question0305 {

    public static void main(String[] args) {
        Question0305 question = new Question0305();


//        "sdfsdsdssdfs"
//        "dssdfs"
//        "sdfsds"
//        27


    }


    static class SortedStack {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackTemp = new Stack<>();

        public SortedStack() {

        }

        public void push(int val) {
            stack.push(val);
        }

        public void pop() {
            Integer min = null;
            while (stack.size() > 0) {
                int temp = stack.pop();
                if (min == null || temp < min) {
                    min = temp;
                }
                stackTemp.push(temp);
            }

            while (stackTemp.size() > 0) {
                Integer temp = stackTemp.pop();
                if (temp.equals(min)) {
                    min = null;
                } else {
                    stack.push(temp);
                }
            }
        }

        public int peek() {
            Integer min = null;
            while (stack.size() > 0) {
                int temp = stack.pop();
                if (min == null || temp < min) {
                    min = temp;
                }
                stackTemp.push(temp);
            }

            while (stackTemp.size() > 0) {
                stack.push(stackTemp.pop());
            }

            if (min == null) {
                return -1;
            }
            return min;
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    static class SortedStackA {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackTemp = new Stack<>();

        public SortedStackA() {

        }

        public void push(int val) {

            while (stack.size() > 0 && stack.peek() < val) {
                stackTemp.push(stack.pop());
            }

            stack.push(val);

            while (stackTemp.size() > 0) {
                stack.push(stackTemp.pop());
            }
        }

        public void pop() {
            if (stack.size() > 0) {
                stack.pop();
            }
        }

        public int peek() {
            if (stack.size() == 0) {
                return -1;
            }
            return stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }
}
