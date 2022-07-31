package darren.gong.leetcode;

public class MinCostClimbingStairs746 {
  public int minCostClimbingStairs(int[] cost) {
    if (cost == null) {
      return -1;
    }
    int length = cost.length;
    if (length <= 2) {
      return 0;
    }
    int[] dp = new int[length+1];
    for (int i = 2; i <= length; i++) {
      dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
    }
    return dp[length];
  }
}
