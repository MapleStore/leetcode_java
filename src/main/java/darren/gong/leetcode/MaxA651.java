package darren.gong.leetcode;

public class MaxA651 {
  public int maxA(int N) {
    if (N <= 3) {
      return N;
    }
    int[] dp = new int[N+1];
    for (int i = 1; i <= N; i++) {
      dp[i] = dp[i-1]+1;
      for (int j = 2; j <= i-2; j++) {
        dp[i] = Math.max(dp[i], dp[j] * (i-j-1));
      }
    }
    return dp[N];
  }
}
