package darren.gong.leetcode;

public class IsMatch10 {
  public static void main(String[] args) {
    IsMatch10 isMatch10 = new IsMatch10();
    isMatch10.isMatch("aaa",
        "ab*a*c*a");
  }
  public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      return false;
    }
    int sLength = s.length();
    int pLength = p.length();
    boolean[][] dp = new boolean[sLength+1][pLength+1];
    dp[0][0] = true;
    for (int i = 0; i <= sLength; i++) {
      for (int j = 1; j <= pLength; j++) {
        if (p.charAt(j-1) == '*') {
          if (j-2 < 0) {
            dp[i][j] = false;
            continue;
          }
          dp[i][j] = dp[i][j-2];
          if (p.charAt(j-2) == '.') {
            for (int k = 0; k <= i; k++) {
              dp[i][j] = dp[i][j] || dp[k][j-2];
            }
            continue;
          }
          if (i-1 >= 0 && p.charAt(j-2) == s.charAt(i-1)) {
            dp[i][j] = dp[i][j] || dp[i-1][j];
            continue;
          }
        } else {
          if (i == 0) {
            dp[i][j] = false;
          } else if (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)) {
            dp[i][j] = dp[i-1][j-1];
          }
        }
      }
    }
    return dp[sLength][pLength];
  }
}
