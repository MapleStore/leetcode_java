package darren.gong.leetcode;

public class MaxUncrossedLines_1035 {
  // 1035. 不相交的线
  public static void main(String[] args) {
    MaxUncrossedLines_1035 maxUncrossedLines_1035 = new MaxUncrossedLines_1035();
    maxUncrossedLines_1035.maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4});
  }
  public int maxUncrossedLines(int[] A, int[] B) {
    int aLength = A.length;
    int bLength = B.length;
    int[][] dp = new int[aLength+1][bLength+1];
    for (int i = 1; i <= aLength; i++) {
      for (int j = 1; j <= bLength; j++) {
        if (A[i - 1] == B[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[aLength][bLength];
  }
}
