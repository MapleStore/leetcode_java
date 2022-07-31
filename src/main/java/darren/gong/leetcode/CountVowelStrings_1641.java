package darren.gong.leetcode;

public class CountVowelStrings_1641 {
  // 1641. 统计字典序元音字符串的数目
  public int countVowelStrings(int n) {
    // 长度为i时 结尾字母分别为a e i o u的字符串数量
    int[][] dp = new int[n+1][5];
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < 5; j++) {
        if (i == 1) {
          dp[i][j] = 1;
          continue;
        }
        for (int k = 0; k <= j; k++) {
          dp[i][j] += dp[i-1][k];
        }
      }
    }
    return dp[n][0]+dp[n][1]+dp[n][2]+dp[n][3]+dp[n][4];
  }
}
