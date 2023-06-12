package darren.gong.leetcode;

import java.util.Arrays;

public class MinDifficulty_1335 {
  public int minDifficulty(int[] jobDifficulty, int d) {
    if (d > jobDifficulty.length) {
      return -1;
    }
    int length = jobDifficulty.length;
    int[][] dp = new int[d+1][length+1];
    Arrays.fill(dp[0], Integer.MAX_VALUE>>2);
    for (int dCount = 1; dCount <= d; dCount++) {
      for (int jobCount = dCount; jobCount <= length; jobCount++) {
        int max = Integer.MIN_VALUE;
        dp[dCount][jobCount] = Integer.MAX_VALUE;
        for (int lastDayStart = jobCount-1; lastDayStart >= dCount-1; lastDayStart--) {
          max = Math.max(max, jobDifficulty[lastDayStart]);
          if (dCount == 1) {
            dp[dCount][jobCount] = max;
          } else {
            dp[dCount][jobCount] = Math.min(dp[dCount][jobCount], dp[dCount-1][lastDayStart]+max);
          }
        }
      }
    }
    return dp[d][length];
  }
}
