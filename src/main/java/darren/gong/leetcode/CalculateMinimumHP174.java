package darren.gong.leetcode;

import java.util.Arrays;

public class CalculateMinimumHP174 {
  public static void main(String[] args) {
    CalculateMinimumHP174 calculateMinimumHP174 = new CalculateMinimumHP174();
    calculateMinimumHP174.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}});
  }
  public int calculateMinimumHP(int[][] dungeon) {
    int maxX = dungeon.length;
    int maxY = dungeon[0].length;
    // dp i j 表示i j至少需要多少勇气能到最后
    for (int i = maxX-1; i >= 0; i--) {
      for (int j = maxY-1; j >= 0; j--) {
        if (i == maxX-1 && j == maxY-1) {
          dungeon[i][j] = Math.max(-dungeon[i][j]+1, 1);
        } else if (i == maxX-1) {
          dungeon[i][j] = Math.max(dungeon[i][j+1]-dungeon[i][j], 1);
        } else if (j == maxY-1) {
          dungeon[i][j] = Math.max(dungeon[i+1][j]-dungeon[i][j], 1);
        } else {
          dungeon[i][j] = Math.max(Math.min(dungeon[i+1][j], dungeon[i][j+1])-dungeon[i][j], 1);
        }
      }
    }
    return dungeon[0][0];
  }
/*
  public int calculateMinimumHP(int[][] dungeon) {
    int n = dungeon.length, m = dungeon[0].length;
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; ++i) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    dp[n][m - 1] = dp[n - 1][m] = 1;
    for (int i = n - 1; i >= 0; --i) {
      for (int j = m - 1; j >= 0; --j) {
        int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
        dp[i][j] = Math.max(minn - dungeon[i][j], 1);
      }
    }
    return dp[0][0];
  }
*/
}
