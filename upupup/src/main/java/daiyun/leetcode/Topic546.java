package daiyun.leetcode;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
 * 你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），
 * 这样一轮之后你将得到 k*k 个积分。
 * 当你将所有盒子都去掉之后，求你能获得的最大积分和。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：boxes = [1,3,2,2,2,3,4,3,1]
 * 输出：23
 * 解释：
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * ----> [1, 3, 3, 4, 3, 1] (3*3=9 分)
 * ----> [1, 3, 3, 3, 1] (1*1=1 分)
 * ----> [1, 1] (3*3=9 分)
 * ----> [] (2*2=4 分)
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= boxes.length <= 100
 * 1 <= boxes[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-boxes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic546 {

    public static void main(String[] args) {

        Topic546 topic1 = new Topic546();

        SolutionA solution = topic1.new SolutionA();


        int[] box = {3,8,8,5,5,3,9,2,4,4,6,5,8,4,8,6,9,6,2,8,6,4,1,9,5,3,10,5,3,3,9,8,8,6,5,3,7,4,9,6,3,9,4,3,5,10,7,6,10,7};

        int res = solution.removeBoxes(box);

        System.out.println(res);
    }

    class Solution {

        HashMap<String, Integer> boxRes = new HashMap<>();

        public int removeBoxes(int[] boxes) {

            if (boxes == null || boxes.length == 0) {
                return 0;
            }

            StringBuilder sb = new StringBuilder();
            for (int a : boxes) {
                sb.append(a + ",");
            }
            System.out.println(sb.toString());
            if (boxRes.containsKey(sb.toString())) {
                return boxRes.get(sb.toString());
            }

            if (boxes.length == 1) {
                return 1;
            }

            int maxScore = 0;

            for (int i = 0; i < boxes.length; ) {
                int k = i;
                while (k + 1 < boxes.length && boxes[k + 1] == boxes[k]) {
                    k++;
                }

                int n = k - i + 1;

                int[] childBoxes = new int[boxes.length - n];

                System.arraycopy(boxes, 0, childBoxes, 0, i);
                System.arraycopy(boxes, k + 1, childBoxes, i, boxes.length - k - 1);

                int childRes = removeBoxes(childBoxes) + n * n;
                if (childRes > maxScore) {
                    maxScore = childRes;
                }

                i = k + 1;
            }
            boxRes.put(sb.toString(), maxScore);

            return maxScore;
        }
    }

    class SolutionA {

        public int removeBoxes(int[] boxes) {
            if (boxes == null || boxes.length == 0) {
                return 0;
            }

            int[][][] dp = new int[boxes.length][boxes.length][boxes.length];

            return doBoxesRemove(boxes, dp, 0, boxes.length - 1, 0);
        }

        public int doBoxesRemove(int[] boxes, int[][][] dp, int start, int end, int count) {
            if (start > end) {
                return 0;
            }
            if (dp[start][end][count] != 0) {
                return dp[start][end][count];
            }

            while (end > start && boxes[end] == boxes[end - 1]) {
                count++;
                end--;
            }

            dp[start][end][count] = doBoxesRemove(boxes, dp, start, end - 1, 0)
                    + (count + 1) * (count + 1);

            for (int i = start; i < end; i++) {
                if (boxes[i] == boxes[end]) {
                    dp[start][end][count] = Math.max(dp[start][end][count],
                            doBoxesRemove(boxes, dp, start, i, count + 1)
                                    + doBoxesRemove(boxes, dp, i + 1, end - 1, 0)
                    );
                }
            }

            return dp[start][end][count];
        }
    }
}
