package daiyun.leetcode;


/**
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * <p>
 *  
 * <p>
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * <p>
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * <p>
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 *  
 * <p>
 * 说明:
 * <p>
 * 骑士的健康点数没有上限。
 * <p>
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 */
public class Topic174 {

    public static void main(String[] args) {

        Topic174 topic1 = new Topic174();

        Solution solution = topic1.new Solution();

        solution.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}});
    }


    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            if (dungeon == null) {
                return 1;
            }
            int M = dungeon.length;
            int N = dungeon[0].length;

            int[][] dp = new int[M][N];
            for (int i = M - 1; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {
                    int changeHp = dungeon[i][j];

                    int right = -1;
                    if (j + 1 < N) {
                        right = dp[i][j + 1];
                    }
                    int down = -1;
                    if (i + 1 < M) {
                        down = dp[i + 1][j];
                    }

                    int minNeedHp = Math.min(right, down);
                    if (right == -1 && down == -1) {
                        minNeedHp = 1;
                    } else if (right == -1) {
                        minNeedHp = down;
                    } else if (down == -1) {
                        minNeedHp = right;
                    }

                    dp[i][j] = minNeedHp - changeHp > 0 ? minNeedHp - changeHp : 1;
                }
            }

            return dp[0][0];
        }
    }
}
