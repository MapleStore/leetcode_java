package darren.gong.leetcode.offer;

public class DicesProbability_60 {
  public double[] dicesProbability(int n) {
    // i个骰子得到 j的数量
    int[][] dp = new int[n+1][6*n+1];
    for (int j = 1; j <= 6; j++) {
      dp[1][j] = 1;
    }
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= 6*n; j++) {
        if (i > j) {
          continue;
        }
        for (int k = 1; k <= 6; k++) {
          if (i-1 <= 0) {
            continue;
          }
          if (j-k <= 0) {
            continue;
          }
          dp[i][j] += dp[i-1][j-k];
        }
      }
    }
    double[] result = new double[6*n-n+1];
    for (int i = 0; i <= 6*n-n; i++) {
      result[i] = (double) dp[n][i+n]/Math.pow(6,n);
    }
    return result;
  }
}
