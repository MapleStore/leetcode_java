package darren.gong.leetcode;

public class NumWays_1637 {
  private final int MOD = 1000000007;
  public int numWays(String[] words, String target) {
    int oneWordLength = words[0].length();
    if (target.length() > oneWordLength) {
      return 0;
    }
    long[][] dp = new long[oneWordLength][target.length()];
    int[][] count = new int[oneWordLength][26];
    for (String word : words) {
      for (int i = 0; i < oneWordLength; i++) {
        count[i][word.charAt(i)-'a']++;
      }
    }

    for (int i = 0; i < oneWordLength; i++) {
      for (int j = 0; j < target.length(); j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = count[i][target.charAt(j)-'a'];
          continue;
        }
        if (i == 0) {
          dp[i][j] = 0;
          continue;
        }
        if (j == 0) {
          dp[i][j] = dp[i-1][j]+count[i][target.charAt(j)-'a'];
          continue;
        }
        dp[i][j] = count[i][target.charAt(j)-'a']*dp[i-1][j-1];
        dp[i][j] += dp[i-1][j];
        dp[i][j] %= MOD;
      }
    }
    return (int) (dp[oneWordLength-1][target.length()-1]%MOD);
  }
}
