package darren.gong.leetcode;

public class NumPermsDISequence_903 {
  private final int MOD = 1000000007;
  public int numPermsDISequence(String s) {
    // 0-i i+1个数 最后一个数排第j位时 排列的种类数量
    int length = s.length();
    int[][] dp = new int[length+1][length+1];
    dp[0][0] = 1;
    for (int i = 1; i < length+1; i++) {
      for (int j = 0; j <= i; j++) {
        if (s.charAt(i-1) == 'D') {
          for (int k = j; k < i; k++) {
            dp[i][j] += dp[i-1][k];
            dp[i][j] %= MOD;
          }
        } else {
          for (int k = 0; k < j; k++) {
            dp[i][j] += dp[i-1][k];
            dp[i][j] %= MOD;
          }
        }
      }
    }
    int sum = 0;
    for (int val : dp[length]) {
      sum += val;
      sum %= MOD;
    }
    return sum;
  }
}
