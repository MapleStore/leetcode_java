package darren.gong.leetcode;

import java.util.Arrays;

public class GetLengthOfOptimalCompression_1531 {
  public int getLengthOfOptimalCompression(String s, int k) {
    int length = s.length();
    // 前i个字符 删除j个字符的情况下可以得到的最短压缩字符数量
    int[][] dp = new int[length+1][k+1];
    for (int[] oneDp : dp) {
      Arrays.fill(oneDp, Integer.MAX_VALUE>>>1);
    }
    dp[0][0] = 0;
    for (int i = 1; i <= length; i++) {
      for (int j = 0; j <= k && j <= i; j++) {
        if (j > 0) {
          dp[i][j] = dp[i-1][j-1];
        }
        int same = 0;
        int delete = 0;
        for (int pre = i; pre >= 1 && delete <= j; pre--) {
          if (s.charAt(pre-1) == s.charAt(i-1)) {
            same++;
          } else {
            delete++;
          }
          if (delete <= j) {
            dp[i][j] = Math.min(dp[i][j], dp[pre-1][j-delete]+same(same));
          }
        }

      }
    }
    return dp[length][k];
  }
  private int same(int val) {
    if (val <= 1) {
      return 1;
    }
    if (val < 10) {
      return 2;
    }
    if (val < 100) {
      return 3;
    }
    return 4;
  }
}
