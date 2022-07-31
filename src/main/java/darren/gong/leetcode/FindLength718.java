package darren.gong.leetcode;

public class FindLength718 {
  public int findLength(int[] A, int[] B) {
    if (A == null || A.length == 0 || B == null || B.length == 0) {
      return 0;
    }
    int aLength = A.length;
    int bLength = B.length;
    int result = 0;
    int[][] dp = new int[aLength+1][bLength+1];
    for (int i = 1; i <= aLength; i++) {
      for (int j = 1; j <= bLength; j++) {
        if (A[i-1] == B[j-1]) {
          dp[i][j] = dp[i-1][j-1]+1;
          result = Math.max(dp[i][j], result);
        }
      }
    }
    return result;
  }
}
