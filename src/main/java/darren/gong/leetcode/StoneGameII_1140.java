package darren.gong.leetcode;

public class StoneGameII_1140 {
  public static void main(String[] args) {
    StoneGameII_1140 stoneGameII_1140 = new StoneGameII_1140();
    stoneGameII_1140.stoneGameII(new int[]{2,7,9,4,4});
  }
  public int stoneGameII(int[] piles) {
    int length = piles.length;
    for (int i = length-2; i >= 0; i--) {
      piles[i] += piles[i+1];
    }
    int[][] dp = new int[length+1][length+1];
    for (int i = 0; i < length; i++) {
      dp[i][length] = piles[i];
    }
    // 从第i堆开始 最多拿到第j堆(不包含) 可以拿到的最大石子数
    for (int i = length-1; i >= 0; i--) {
      for (int j = Math.min(i+2, length); j <= length; j+=2) {
        // 此次拿到k
        for (int k = i+1; k <= j; k++) {
          dp[i][j] = Math.max(dp[i][j], piles[i]-dp[k][Math.min(length, k+Math.max(j-i, 2*(k-i)))]);
        }
      }
    }
    return dp[0][Math.min(2, length)];
  }

  public int stoneGameII2(int[] piles) {
    int length = piles.length;
    for (int i = length-2; i >= 0; i--) {
      piles[i] += piles[i+1];
    }
    int[][] dp = new int[length+1][length+1];
    // 从第i堆开始 M == j时 可以拿到的最大石子数
    for (int i = length-1; i >= 0; i--) {
      for (int M = 1; M <= length; M++) {
        if (i+2*M >= length) {
          dp[i][M] = piles[i];
        } else {
          for (int k = 1; k <= 2*M; k++) {
            dp[i][M] = Math.max(dp[i][M], piles[i]-dp[i+k][Math.max(M, k)]);
          }
        }
      }
    }
    return dp[0][1];
  }
}
