package darren.gong.leetcode.interview;

public class WaysToChange_0811 {
  // 面试题 08.11. 硬币
  public int waysToChange(int n) {
    int[] coins = new int[]{1,5,10,25};
    int[] dp = new int[n+1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int i = coin; i <= n; i++) {
        dp[i] = (dp[i]+dp[i-coin])%1000000007;
      }
    }
    return dp[n];
  }
}
