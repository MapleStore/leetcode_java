package darren.gong.leetcode;

public class TwoEggDrop_1884 {
  public int twoEggDrop(int n) {
    if (n <= 1) {
      return 1;
    }
    // 还剩j个鸡蛋 要验证i层的最小次数
    int[][] dp = new int[n+1][3];
    for (int i = 1; i <= n; i++) {
      dp[i][1] = i;
      dp[i][2] = Integer.MAX_VALUE;
      for (int j = 1; j < i; j++) {
        dp[i][2] = Math.min(dp[i][2], Math.max(dp[j-1][2]+1, dp[i-j][1]+1));
      }
    }
    return dp[n][2];
  }
}
