package darren.gong.leetcode;

public class KInversePairs_629 {
  public static void main(String[] args) {
    KInversePairs_629 kInversePairs_629 = new KInversePairs_629();
    kInversePairs_629.kInversePairs(3, 2);
  }
  private final int MOD = 1000000007;
  public int kInversePairs(int n, int k) {
    long[][] dp = new long[n+1][k+1];
    dp[1][0] = 1;
    for (int i = 2; i <= n; i++) {
      long[] sum = new long[k+1];
      sum[0] = dp[i-1][0];
      for (int j = 1; j <= k; j++) {
        sum[j] = sum[j-1]+dp[i-1][j];
      }
      for (int j = 0; j <= k; j++) {
        int left = Math.max(0, j-(i-1));
        dp[i][j] = left-1 >= 0 ? (sum[j]-sum[left-1])%MOD : sum[j]%MOD;

/*
        for (int l = 0; l < j && l < i; l++) {
          dp[i][j] += dp[i-1][j-l];
        }
*/
      }
    }
    return (int)dp[n][k];
  }
}
