package darren.gong.leetcode;

public class MaxProfit188 {
  public static void main(String[] args) {
    MaxProfit188 maxProfit188 = new MaxProfit188();
    maxProfit188.maxProfit(2, new int[]{1,2,4,7});
  }
  public int maxProfit(int k, int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int length = prices.length;
    k = Math.min(2*k, length);
    int[][][] dp = new int[length+1][k+1][2];
    // dp[][][] 最后一次交易第i个prices 交易j次 0买入 1卖出的最大利润
    for (int i = 1; i <= length; i++) {
      for (int j = 1; j <= k && j <= i; j++) {
        if (j == 1) {
          dp[i][j][0] = -prices[i-1];
          continue;
        }
        boolean buy = j%2 == 1;
        if (buy) {
          // 买入
          // 第j-1次卖出第t个price
          dp[i][j][0] = dp[i-1][j-1][1]-prices[i-1];
          for (int t = j-1; t <= i-1; t++) {
            dp[i][j][0] = Math.max(dp[t][j-1][1]-prices[i-1], dp[i][j][0]);
          }
        } else {
          // 卖出
          dp[i][j][1] = dp[i-1][j-1][0]+prices[i-1];
          for (int t = j-1; t <= i-1; t++) {
            dp[i][j][1] = Math.max(dp[t][j-1][0]+prices[i-1], dp[i][j][1]);
          }
        }
      }
    }
    int result = 0;
    for (int i = 0; i <= length; i++) {
      for (int j = 2; j <= k; j+=2) {
        result = Math.max(result, dp[i][j][1]);
      }
    }
    return result;
  }
}
