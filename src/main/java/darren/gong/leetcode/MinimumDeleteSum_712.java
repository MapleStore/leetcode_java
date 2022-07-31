package darren.gong.leetcode;

public class MinimumDeleteSum_712 {
  public int minimumDeleteSum(String s1, String s2) {
    // max ascii sum
    int[][] dp = new int[s1.length()+1][s2.length()+1];
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        char s1Char = s1.charAt(i-1);
        char s2Char = s2.charAt(j-1);
        if (s1Char == s2Char) {
          dp[i][j] = s1Char+s2Char+dp[i-1][j-1];
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
        max = Math.max(max, dp[i][j]);
      }
    }
    for (char oneChar : s1.toCharArray()) {
      sum += oneChar;
    }
    for (char oneChar : s2.toCharArray()) {
      sum += oneChar;
    }
    return sum-max;
  }
}
