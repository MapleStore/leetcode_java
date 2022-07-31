package darren.gong.leetcode;

import java.util.Arrays;

public class MincostTickets_983 {
  public int mincostTickets(int[] days, int[] costs) {
    int daysLength = days.length;
    // 0:不买票 1:买1天票 2:买7天票 3:买30天票
    int[][] dp = new int[daysLength][4];
    dp[0][0] = Integer.MAX_VALUE;
    dp[0][1] = costs[0];
    dp[0][2] = costs[1];
    dp[0][3] = costs[2];
    for (int i = 1; i < daysLength; i++) {
      dp[i][0] = Integer.MAX_VALUE;
      int buyIndex = i-1;
      while (buyIndex >= 0 && days[i]-days[buyIndex] < 7) {
        dp[i][0] = Math.min(dp[buyIndex][2], dp[i][0]);
        buyIndex--;
      }
      buyIndex = i-1;
      while (buyIndex >= 0 && days[i]-days[buyIndex] < 30) {
        dp[i][0] = Math.min(dp[buyIndex][3], dp[i][0]);
        buyIndex--;
      }

      dp[i][1] = Integer.MAX_VALUE;
      dp[i][2] = Integer.MAX_VALUE;
      dp[i][3] = Integer.MAX_VALUE;
      for (int choice = 0; choice < 4; choice++) {
        dp[i][1] = Math.min(dp[i][1], dp[i-1][choice]);
        dp[i][2] = Math.min(dp[i][2], dp[i-1][choice]);
        dp[i][3] = Math.min(dp[i][3], dp[i-1][choice]);
      }
      dp[i][1] += costs[0];
      dp[i][2] += costs[1];
      dp[i][3] += costs[2];
    }
    int result = Integer.MAX_VALUE;
    for (int choice = 0; choice < 4; choice++) {
      result = Math.min(result, dp[daysLength-1][choice]);
    }
    return result;
  }
  public int mincostTickets2(int[] days, int[] costs) {
    int daysLength = days.length;
    // 0:不买票 1:买1天票 2:买7天票 3:买30天票
    int[] dp = new int[daysLength];
    Arrays.fill(dp, Integer.MAX_VALUE);
    int min = Math.min(costs[0], Math.min(costs[1], costs[2]));
    for (int i = 0; i < daysLength; i++) {
      int buy7 = (i == 0 ? 0 : dp[i-1])+costs[1];
      int next = i+1;
      while (next < daysLength && days[next]-days[i] < 7) {
        dp[next] = Math.min(dp[next], buy7);
        next++;
      }
      int buy30 = (i == 0 ? 0 : dp[i-1])+costs[2];
      next = i+1;
      while (next < daysLength && days[next]-days[i] < 30) {
        dp[next] = Math.min(dp[next], buy30);
        next++;
      }
      dp[i] = Math.min((i == 0 ? 0 : dp[i-1])+min, dp[i]);
    }
    return dp[daysLength-1];
  }
}
