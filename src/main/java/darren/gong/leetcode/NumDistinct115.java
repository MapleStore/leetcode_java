package darren.gong.leetcode;

public class NumDistinct115 {
  public int numDistinct(String s, String t) {
    if (s.isEmpty() && !t.isEmpty()) {
      return 0;
    }
    if (t.isEmpty()) {
      return 1;
    }
    int sLength = s.length();
    int tLength = t.length();
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();
    int[][] dp = new int[sLength][tLength];
    for (int i = 0; i < sLength; i++) {
      for (int j = 0; j < tLength && j <= i; j++) {
        if (i == 0 && j == 0 && sChars[0] == tChars[0]) {
          dp[i][j] = 1;
          continue;
        }
        for (int k = j; k <= i; k++) {
          if (tChars[j] == sChars[k]) {
            if (j == 0) {
              dp[i][j] = dp[i][j]+1;
            } else {
              dp[i][j] = dp[i][j]+dp[k-1][j-1];
            }
          }
        }
      }
    }
    return dp[sLength-1][tLength-1];
  }
}
