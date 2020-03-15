package daiyun.leetcode;

import java.util.LinkedList;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，
 * 可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Topic42 {

    public static void main(String[] args) {

        Topic42 topic1 = new Topic42();

        SolutionA solution = topic1.new SolutionA();

        int res = solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});

        System.out.println();

    }


    class Solution {
        public int trap(int[] height) {
            int len = height.length;
            int ans = 0;

            int maxHight = 0;
            for (int i = 0; i < len; i++) {
                int wight = i - maxHight - 1;
                if (wight > 0) {
                    int h = Math.min(height[i], height[maxHight]);
                    if (h > 0) {
                        int preCount = 0;
                        for (int j = i - 1; j > maxHight; j--) {
                            preCount += height[j];
                        }
                        if (wight * h > preCount) {
                            ans = ans + (wight * h - preCount);
                            for (int j = i - 1; j > maxHight; j--) {
                                height[j] = h;
                            }
                        }
                    }
                }
                if (height[i] >= height[maxHight]) {
                    maxHight = i;
                }
            }

            return ans;
        }
    }

    class SolutionA {
        public int trap(int[] height) {
            int len = height.length;
            int ans = 0;

            LinkedList<Integer> stack = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                while (stack.size() > 0 && height[i] > height[stack.peek()]) {
                    int preIndex = stack.poll();
                    if (stack.size() == 0) {
                        break;
                    }
                    int distance = i - stack.peek() - 1;
                    ans = ans + (distance * Math.min(height[i], height[stack.peek()])) - height[preIndex];
                }
                stack.push(i);
            }

            return ans;
        }
    }

    class SolutionB {
        public int trap(int[] height) {
            int L = 0;
            int R = height.length - 1;
            int maxL = 0;
            int maxR = 0;

            int ans = 0;
            while (L < R) {
                if (height[L] < height[R]) {
                    if (height[L] > maxL) {
                        maxL = height[L];
                    } else {
                        ans += maxL - height[L];
                    }
                    L++;
                } else {
                    if (height[R] > maxR) {
                        maxR = height[R];
                    } else {
                        ans += maxR - height[R];
                    }
                    R--;
                }
            }
            return ans;
        }
    }
}
