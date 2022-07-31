package darren.gong.leetcode;

public class BestTimetoBuyandSellStockwithCooldown {
    public static void main(String[] args) {
        BestTimetoBuyandSellStockwithCooldown bestTimetoBuyandSellStockwithCooldown = new BestTimetoBuyandSellStockwithCooldown();
        bestTimetoBuyandSellStockwithCooldown.maxProfit(new int[]{1,2,3,0,2});
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
}
