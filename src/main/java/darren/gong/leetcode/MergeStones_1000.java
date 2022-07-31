package darren.gong.leetcode;

import java.util.Arrays;

public class MergeStones_1000 {
  public static void main(String[] args) {
    MergeStones_1000 mergeStones_1000 = new MergeStones_1000();
    mergeStones_1000.mergeStones(new int[]{3,2,4,1}, 2);
  }
  public int mergeStones(int[] stones, int k) {
    int length = stones.length;
    if ((length-1)%(k-1) != 0) {
      return -1;
    }

    int[] sum = new int[length+1];
    for (int i = 1; i <= length; i++) {
      sum[i] = stones[i-1]+sum[i-1];
    }
    // 从i-j分piles个堆最小开销
    int[][][] dp = new int[length][length][k+1];
    for (int[][] tempDp : dp) {
      for (int[] val : tempDp) {
        Arrays.fill(val, Integer.MAX_VALUE/3);
      }
    }
    for (int i = 0; i < length; i++) {
      dp[i][i][1] = 0;
    }
    for (int len = 2; len <= length; len++) {
      for (int i = 0; i < length; i++) {
        int j = i+len-1;
        if (j > length-1) {
          break;
        }
        for (int pileNum = 2; pileNum <= len && pileNum <= k; pileNum++) {
          for (int p = i; p < j; p++) {
            dp[i][j][pileNum] = Math.min(dp[i][j][pileNum], dp[i][p][1]+dp[p+1][j][pileNum-1]);
          }
        }
        dp[i][j][1] = dp[i][j][k]+sum[j+1]-sum[i];
      }
    }
    return dp[0][length-1][1];
  }
}
