package darren.gong.leetcode;

public class IsOneEditDistance161 {
  public static void main(String[] args) {
    IsOneEditDistance161 isOneEditDistance161 = new IsOneEditDistance161();
    isOneEditDistance161.isOneEditDistance("ab", "accb");
  }
  public boolean isOneEditDistance(String s, String t) {
    int[][] dp = new int[s.length()+1][t.length()+1];
    for (int i = 1; i <= s.length(); i++) {
      dp[i][0] = i;
    }
    for (int j = 1; j <= t.length(); j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= t.length(); j++) {
        if (s.charAt(i-1) == t.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1];
        } else {
          dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
        }
      }
    }
    return dp[s.length()][t.length()] == 1;
  }
}
