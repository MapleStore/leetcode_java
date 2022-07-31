package darren.gong.leetcode;

public class BestTimetoBuyandSellStockIV {
    public static void main(String[] args) {
        BestTimetoBuyandSellStockIII bestTimetoBuyandSellStockIII = new BestTimetoBuyandSellStockIII();
        bestTimetoBuyandSellStockIII.maxProfit(new int[]{1,2,3,4,5});
        return;
    }

    public int maxProfit(int[] prices) {
        //第1天  交易状态 0：买入    1:卖出
        int [][]dp = new int[prices.length+1][2];
        for (int i = 0; i <= prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = 0;
            } else if (i == 1) {
                dp[i][0] = -prices[i-1];
                dp[i][1] = 0;
            } else {
                // 今天买入 = 前天卖出 或 昨天买入（今天无操作）
                dp[i][0] = Math.max(dp[i-2][1] - prices[i-1], dp[i-1][0]);
                // 今天卖出 = 昨天买入 或 昨天卖出（今天无操作）
                dp[i][1] = Math.max(dp[i-1][0] + prices[i-1], dp[i-1][1]);
            }
        }
        return dp[prices.length][1];
    }

    public int maxProfit(int k, int[] prices) {
        if (k > prices.length/2) {
            return maxProfit(prices);
        }
        //第1天  交易状态 0：买入    1:卖出
        int [][][]dp = new int[prices.length+1][k+1][2];
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 1) {
                    dp[i][j][0] = -prices[i-1];
                    dp[i][j][1] = 0;
                } else {
                    // 今天1次买入 = 今天0次卖出，今天再买 昨天第一次买（今天无操作）
                    dp[i][j][0] = Math.max(dp[i][j-1][1] - prices[i-1], dp[i-1][j][0]);
                    // 今天1次卖出 = 昨天1次买入+卖出价格 或 昨天1次卖出（今天无操作）
                    dp[i][j][1] = Math.max(dp[i-1][j][0] + prices[i-1], dp[i-1][j][1]);
                }
            }
        }
        return dp[prices.length][k][1];
    }

    public int maxProfit1(int k, int[] prices) {
        if (k <= 0) {
            return 0;
        }
        int preDayNowBussSell = 0;
        int preDayNowBussBuy = Integer.MIN_VALUE;
        int preDayPreBussSell = 0;

        int todayNowBussBuy = 0;
        int todayNowBussSell = 0;
        //第1天  交易状态 0：买入    1:卖出
        int [][][]dp = new int[prices.length+1][k][2];
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 0; j < k; j++) {
                if (i == 1) {
                    preDayNowBussBuy = -prices[i-1];
                    todayNowBussBuy = -prices[i-1];

                    preDayNowBussSell = 0;
                    todayNowBussSell = 0;
                } else {
                    if (j == 0) {
                        todayNowBussBuy = Math.max(-prices[i - 1], preDayNowBussBuy);
                        // 今天0次卖出 = 昨天卖出（今天无操作） 或 昨天0次买入
                        todayNowBussSell = Math.max(preDayNowBussBuy + prices[i - 1], preDayNowBussSell);
                    } else {
                        // 今天1次买入 = 今天0次卖出，今天再买 昨天第一次买（今天无操作）
                        todayNowBussBuy = Math.max(preDayPreBussSell - prices[i - 1], preDayNowBussBuy);
                        // 今天1次卖出 = 昨天1次买入+卖出价格 或 昨天1次卖出（今天无操作）
                        todayNowBussSell = Math.max(preDayNowBussBuy + prices[i - 1], preDayNowBussSell);
                    }
                }
            }
            preDayNowBussBuy = todayNowBussBuy;
            preDayPreBussSell = todayNowBussSell;
            preDayNowBussSell = todayNowBussSell;
        }
        return todayNowBussSell;
    }

}
