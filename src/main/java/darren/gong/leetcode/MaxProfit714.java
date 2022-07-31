package darren.gong.leetcode;

public class MaxProfit714 {
    public int maxProfit(int[] prices, int fee) {
        int days = prices.length;
        int[][] dp = new int[days+1][2];
        for (int i = 1; i <= days; i++) {
            if (i >= 2) {
                dp[i][0] = Math.max(dp[i-1][1] + prices[i-1], dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-1][0] - prices[i-1] - fee, dp[i-1][1]);
            } else if (i == 1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i-1] - fee;
            }
        }
        return dp[days][0];
    }
}
