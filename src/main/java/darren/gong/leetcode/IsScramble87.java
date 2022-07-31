package darren.gong.leetcode;

public class IsScramble87 {
  public static void main(String[] args) {
    IsScramble87 isScramble87 = new IsScramble87();
    isScramble87.isScramble("abcd","cdab");
  }
  public boolean isScramble(String s1, String s2) {
    int length = s1.length();
    // dp[i][j][k] 表示 s1 i到j 的字符 是否满足 s2 k开始同样长度的字符Scramble
    boolean[][][] dp = new boolean[length][length][length];
    for (int size = 0; size < length; size++) {
      for (int i = 0; i+size < length; i++) {
        int j = i+size;
        for (int k = 0; k+size < length; k++) {
          if (size == 0) {
            dp[i][j][k] = s1.charAt(i) == s2.charAt(k);
            continue;
          }
          for (int mid = 0; mid <= size; mid++) {
            dp[i][j][k] = dp[i][j][k] | (dp[i][i+mid][k]&&dp[i+mid+1][j][k+mid+1]) | (dp[i][i+mid][k+size-mid]&&dp[i+mid+1][j][k]);
            if (dp[i][j][k]) {
              break;
            }
          }
        }
      }
    }
    return dp[0][length-1][0];
  }
}
