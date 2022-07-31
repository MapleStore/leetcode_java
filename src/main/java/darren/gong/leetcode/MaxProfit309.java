package darren.gong.leetcode;

public class MaxProfit309 {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        //j=0表示卖出
        int[][] dp = new int[days+1][2];
        for (int i = 1; i <= days; i++) {
            if (i >= 2) {
                dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i-1]);
                dp[i][0] = Math.max(dp[i-1][1]+prices[i-1], dp[i-1][0]);
            } else {
                dp[i][1] = -prices[0];
                dp[i][0] = 0;
            }
        }
        return dp[days][0];
    }
}
