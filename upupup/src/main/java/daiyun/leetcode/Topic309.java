package daiyun.leetcode;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class Topic309 {

    public static void main(String[] args) {

        Topic309 topic1 = new Topic309();

        Solution solution = topic1.new Solution();

        int[][] a = {{1, 2, 3, 1, 55, 65, 345}, {4, 5, 6, 7, 8, 89, 99}};

        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 2, 4, 23, 2, 4, 5, 2, 4, 34, 23, 35, 2, 23, 54, 55, 5, 42, 23, 32, 54}));
//        {1,21,2,3}
    }

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) {
                return 0;
            }

            int maxProfit = 0;
            Integer buyIndex = null;

            for (int i = 0; i < prices.length; i++) {
                if (buyIndex == null) {
                    if (i + 1 < prices.length && prices[i] < prices[i + 1]) {
                        buyIndex = i;

                        if (i + 3 < prices.length
                                && prices[i + 1] > prices[i + 2]
                                && prices[i + 3] - prices[i + 2] > prices[i + 1] - prices[i]) {
                            buyIndex = null;
                        }
                        if (buyIndex != null) {
                            System.out.println("buy:" + buyIndex);
                        }
                    }
                } else {
                    boolean saleFlag = false;

                    if (i + 1 >= prices.length) {
                        saleFlag = true;
                    } else {
                        if (prices[i + 1] > prices[i]) {
                            if (i + 3 < prices.length
                                    && prices[i + 1] - prices[i] < prices[i + 3] - prices[i + 2]) {

                                saleFlag = true;
                            }
                        } else {
                            saleFlag = true;
                            if (i + 2 < prices.length && prices[i + 2] > prices[i]) {
                                saleFlag = false;
                            }
                        }
                    }


                    if (saleFlag) {
                        System.out.println("sale:" + i);
                        maxProfit += prices[i] - prices[buyIndex];
                        buyIndex = null;
                        i++;
                    }
                }
            }

            return maxProfit;
        }
    }
}
