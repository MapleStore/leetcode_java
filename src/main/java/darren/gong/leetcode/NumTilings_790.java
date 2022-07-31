package darren.gong.leetcode;

public class NumTilings_790 {
  // 790. 多米诺和托米诺平铺
  public static void main(String[] args) {
    NumTilings_790 numTilings_790 = new NumTilings_790();
    numTilings_790.numTilings(3);
  }
  public int numTilings(int N) {
    int[][] dp = new int[N+1][4];
    dp[1][0] = 1;
    dp[1][3] = 1;
    for (int i = 2; i <= N; i++) {
      dp[i][0] = dp[i-1][3]%1000000007;

      dp[i][1] = (dp[i-1][0]+dp[i-1][2])%1000000007;

      dp[i][2] = (dp[i-1][0]+dp[i-1][1])%1000000007;

      dp[i][3] = (((dp[i-1][0]+dp[i-1][1])%1000000007+dp[i-1][2])%1000000007+dp[i-1][3])%1000000007;
    }
    return dp[N][3];
  }
}
