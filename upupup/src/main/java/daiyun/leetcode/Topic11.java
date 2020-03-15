package daiyun.leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class Topic11 {

    public static void main(String[] args) {

        Topic11 topic1 = new Topic11();

        SolutionA solution = topic1.new SolutionA();


        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }


    class Solution {
        public int maxArea(int[] height) {
            return max(height, 0, height.length - 1);
        }

        public int max(int[] hegiht, int start, int end) {
            if (start < 0 || start >= end) {
                return 0;
            }

            int area1 = max(hegiht, 0, end - 1);
            int area2 = max(hegiht, start + 1, end);
            int area3 = (end - start) * Math.min(hegiht[start], hegiht[end]);

            int area = Math.max(area1, area2);

            return Math.max(area, area3);
        }
    }

    class SolutionA {
        public int maxArea(int[] height) {
            int ans = 0;

            int start = 0;
            int end = height.length - 1;

            while (start < end) {

                int startV = height[start];
                int endV = height[end];

                if (endV >= startV) {
                    int ares = (end - start) * startV;
                    ans = Math.max(ans, ares);
                    start++;
                } else {
                    int ares = (end - start) * endV;
                    ans = Math.max(ans, ares);
                    end--;
                }
            }
            return ans;
        }
    }


}
