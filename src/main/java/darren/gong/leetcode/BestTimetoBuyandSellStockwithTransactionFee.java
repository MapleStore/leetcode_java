package darren.gong.leetcode;

public class BestTimetoBuyandSellStockwithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        //第1天  交易状态 0：买入    1:卖出
        int []dp = new int[2];
        int preBuy = -prices[0];
        int preSell = 0;
        for (int i = 1; i <= prices.length; i++) {
            // 今天买入 = 昨天卖出 或 昨天买入（今天无操作）
            dp[0] = Math.max(preSell - prices[i - 1], preBuy);
            // 今天卖出 = 昨天买入 或 昨天卖出（今天无操作）
            dp[1] = Math.max(preBuy + prices[i - 1] - fee, preSell);
            preBuy = dp[0];
            preSell = dp[1];
        }
        return dp[1];
    }
}
