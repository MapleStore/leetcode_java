package darren.gong.leetcode;

import java.util.Arrays;

public class MinCost_1547 {
  public static void main(String[] args) {
    MinCost_1547 minCost_1547 = new MinCost_1547();
    minCost_1547.minCost(9, new int[]{5,6,1,4,2});
  }
  public int minCost(int n, int[] cuts) {
    Arrays.sort(cuts);
    int length = cuts.length;
    int index = 0;
    int[] values = new int[length+1];
    values[index++] = cuts[0];
    for (int i = 1; i < length; i++) {
      values[index++] = cuts[i]-cuts[i-1];
    }
    values[index++] = n-cuts[cuts.length-1];
    length = values.length;
    int[][] dp = new int[length][length];
    for (int[] oneDp : dp) {
      Arrays.fill(oneDp, Integer.MAX_VALUE);
    }
    for (int i = 0; i < length; i++) {
      dp[i][i] = 0;
    }
    int[] sum = new int[length+1];
    for (int i = 1; i <= length; i++) {
      sum[i] = sum[i-1]+values[i-1];
    }
    for (int distance = 2; distance <= length; distance++) {
      for (int left = 0;; left++) {
        int right = left+distance-1;
        if (right >= length) {
          break;
        }
        for (int i = left; i < right; i++) {
          dp[left][right] = Math.min(dp[left][right], dp[left][i]+dp[i+1][right]);
        }
        dp[left][right] += sum[right+1]-sum[left];
      }
    }
    return dp[0][length-1];
  }
}
