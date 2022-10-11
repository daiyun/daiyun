package daiyun.leetcode.lcci;

/**
 * 三合一。描述如何只用一个数组来实现三个栈。
 * <p>
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * <p>
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, -1, -1]
 */
public class Question0301 {

    public static void main(String[] args) {
        Question0301 question = new Question0301();


//        "sdfsdsdssdfs"
//        "dssdfs"
//        "sdfsds"
//        27

    }


    class TripleInOne {
        int[] stack;
        int[] size = new int[]{-1, -1, -1};
        int stackSize;

        public TripleInOne(int stackSize) {
            this.stackSize = stackSize;
            stack = new int[stackSize * 3];
        }

        public void push(int stackNum, int value) {
            if (size[stackNum] < stackSize - 1) {
                size[stackNum]++;
                stack[stackSize * stackNum + size[stackNum]] = value;
            }
        }

        public int pop(int stackNum) {
            if (size[stackNum] >= 0) {
                int p = size[stackNum]--;
                return stack[stackSize * stackNum + p];
            }
            return -1;
        }

        public int peek(int stackNum) {
            if (size[stackNum] >= 0) {
                return stack[stackSize * stackNum + size[stackNum]];
            }
            return -1;
        }

        public boolean isEmpty(int stackNum) {
            return size[stackNum] < 0;
        }
    }
}
