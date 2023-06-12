package darren.gong.leetcode;

public class CountOrders_1359 {
  private final int MOD = 1000000007;
  public int countOrders(int n) {
    if (n == 1) {
      return 1;
    }
    long[] dp = new long[n+1];
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      long pos = 2L*(i-1)+1;
      dp[i] = dp[i-1]*(((1L+pos)*pos)>>1);
      dp[i] %= MOD;
    }
    return (int) dp[n];
  }
}
