package darren.gong.leetcode;

public class NumWays_276 {
  public static void main(String[] args) {
    NumWays_276 numWays_276 = new NumWays_276();
    numWays_276.numWays(7, 2);
  }
  public int numWays(int n, int k) {
    // 第i个栅栏涂j颜色的可能数量
    int[][] dp = new int[n][k];
    // i个栅栏的可能性总数, 用于减少计算量
    int[] count = new int[n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k; j++) {
        if (i == 0) {
          dp[i][j] = 1;
          count[i] += dp[i][j];
          continue;
        }
        if (i == 1) {
          dp[i][j] = count[i-1];
        } else {
          dp[i][j] = count[i-1]-dp[i-1][j];
          dp[i][j] += count[i-2]-dp[i-2][j];
        }
        count[i] += dp[i][j];
      }
    }
    return count[n-1];
  }
}
