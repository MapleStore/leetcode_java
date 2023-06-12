package darren.gong.leetcode;

public class MinCostII_265 {
  public static void main(String[] args) {
    MinCostII_265 minCostII_265 = new MinCostII_265();
    minCostII_265.minCostII(new int[][]{{15,17,15,20,7,16,6,10,4,20,7,3,4},{11,3,9,13,7,12,6,7,5,1,7,18,9}});
  }
  public int minCostII(int[][] costs) {
    int n = costs.length;
    int k = costs[0].length;
    int[][][] dp = new int[n][2][2];
    dp[0][0] = new int[]{-1, 999999};
    dp[0][1] = new int[]{-1, 999999};
    for (int i = 0; i < k; i++) {
      int currentCost = costs[0][i];
      if (currentCost <= dp[0][0][1]) {
        dp[0][1] = dp[0][0];
        dp[0][0] = new int[]{i, currentCost};
      } else if (currentCost <= dp[0][1][1]) {
        dp[0][1] = new int[]{i, currentCost};
      }
    }
    for (int i = 1; i < n; i++) {
      dp[i][0] = new int[]{-1, 999999};
      dp[i][1] = new int[]{-1, 999999};
      for (int j = 0; j < k; j++) {
        int preCost = j == dp[i-1][0][0] ? dp[i-1][1][1] : dp[i-1][0][1];
        int currentCost = costs[i][j]+preCost;
        if (currentCost <= dp[i][0][1]) {
          dp[i][1] = dp[i][0];
          dp[i][0] = new int[]{j, currentCost};
        } else if (currentCost <= dp[i][1][1]) {
          dp[i][1] = new int[]{j, currentCost};
        }
      }
    }
    return Math.min(dp[n-1][0][1], dp[n-1][1][1]);
  }
}
