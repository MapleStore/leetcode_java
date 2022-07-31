package darren.gong.leetcode;

public class MinCost256 {
  public static void main(String[] args) {
    MinCost256 minCost256 = new MinCost256();
    minCost256.minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}});
  }
  public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
      return 0;
    }
    int houseNum = costs.length;
    int[][] dp = new int[houseNum+1][3];
    for (int i = 1; i <= houseNum; i++) {
      for (int color = 0; color < 3; color++) {
        dp[i][color] = Integer.MAX_VALUE;
        for (int lastColor = 0; lastColor < 3; lastColor++) {
          if (lastColor != color) {
            dp[i][color] = Math.min(dp[i][color], dp[i-1][lastColor]+costs[i-1][color]);
          }
        }
      }
    }

    int result = Integer.MAX_VALUE;
    for (int color = 0; color < 3; color++) {
      result = Math.min(result, dp[houseNum][color]);
    }
    return result;
  }
}
