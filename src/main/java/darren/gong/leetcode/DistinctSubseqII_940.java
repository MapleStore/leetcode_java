package darren.gong.leetcode;

import java.util.Arrays;

public class DistinctSubseqII_940 {
  public static void main(String[] args) {
    DistinctSubseqII_940 distinctSubseqII_940 = new DistinctSubseqII_940();
    distinctSubseqII_940.distinctSubseqII("aba");
  }
  private final int MOD = 1000000007;
  public int distinctSubseqII(String s) {
    int length = s.length();
    //  最多到j index 能构成几种i个字母的子序列
    long[][] dp = new long[length+1][length];

    int[] indexs = new int[26];
    Arrays.fill(indexs, -1);
    int[][] preWork = new int[length][];
    for (int i = 0; i < length; i++) {
      dp[1][i] = i == 0 ? 0 : dp[1][i-1];
      if (indexs[s.charAt(i)-'a'] == -1) {
        dp[1][i]++;
      }
      indexs[s.charAt(i)-'a'] = i;
      preWork[i] = Arrays.copyOf(indexs, indexs.length);
    }
    for (int i = 2; i <= length; i++) {
      for (int j = i-1; j < length; j++) {
        if (i-1 == j) {
          dp[i][j] = 1;
          continue;
        }
        dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
        int preIndex = preWork[j-1][s.charAt(j)-'a'];
        if (preIndex > 0) {
          dp[i][j] -= dp[i-1][preIndex-1];
        }
        dp[i][j] %= MOD;
      }
    }

    int result = 0;
    for (int i = 1; i <= length; i++) {
      result += dp[i][length-1];
      result %= MOD;
    }
    return result;
  }
}
