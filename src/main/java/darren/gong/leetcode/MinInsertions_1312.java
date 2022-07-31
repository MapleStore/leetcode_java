package darren.gong.leetcode;

public class MinInsertions_1312 {
  public int minInsertions(String s) {
    StringBuilder s1 = new StringBuilder(s);
    StringBuilder s2 = new StringBuilder(s).reverse();
    int length = s.length();
    // 计算两个s最大相同子序列长度，原长度-子序列长度为答案
    int[][] dp = new int[length+1][length+1];
    for (int i = 1; i <= length; i++) {
      for (int j = 1; j <= length; j++) {
        if (s1.charAt(i-1) == s2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1]+1;
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    return length-dp[length][length];
  }
}
