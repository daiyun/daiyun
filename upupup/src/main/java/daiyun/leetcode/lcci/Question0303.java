package daiyun.leetcode.lcci;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 * <p>
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
 * [[1], [1], [2], [1], [], []]
 * 输出：
 * [null, null, null, 2, 1, -1]
 * 示例2:
 * <p>
 * 输入：
 * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
 * [[2], [1], [2], [3], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, 3]
 */
public class Question0303 {

    public static void main(String[] args) {
        Question0303 question = new Question0303();


//        "sdfsdsdssdfs"
//        "dssdfs"
//        "sdfsds"
//        27

        StackOfPlates stackOfPlates = new StackOfPlates(2);
        stackOfPlates.push(1);
        stackOfPlates.push(2);
        stackOfPlates.push(3);
        stackOfPlates.popAt(0);
        stackOfPlates.popAt(0);
        stackOfPlates.popAt(0);
    }


    static class StackOfPlates {

        LinkedList<Stack<Integer>> stacks = new LinkedList<>();
        int cap;

        public StackOfPlates(int cap) {
            this.cap = cap;
            stacks.add(new Stack<Integer>());
        }

        public void push(int val) {
            if (stacks.getLast().size() < cap) {
                stacks.getLast().push(val);
            } else {
                if (cap > 0) {
                    Stack<Integer> nextStack = new Stack<>();
                    nextStack.push(val);
                    stacks.add(nextStack);
                }
            }
        }

        public int pop() {
            Stack<Integer> stack = stacks.getLast();

            if (stack.size() == 0) {
                return -1;
            }

            if (stack.size() == 1 && stacks.size() > 1) {
                stacks.removeLast();
            }

            return stack.pop();
        }

        public int popAt(int index) {
            if (index >= stacks.size() || stacks.get(index) == null) {
                return -1;
            }

            Stack<Integer> stack = stacks.get(index);
            if (stack.size() == 1 && stacks.size() > 1) {
                stacks.remove(index);
            }

            if (stack.size() == 0) {
                return -1;
            }

            return stack.pop();
        }
    }
}
