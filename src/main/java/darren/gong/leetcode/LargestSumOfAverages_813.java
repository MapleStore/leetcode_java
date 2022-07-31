package darren.gong.leetcode;

public class LargestSumOfAverages_813 {
  public static void main(String[] args) {
    LargestSumOfAverages_813 largestSumOfAverages_813 = new LargestSumOfAverages_813();
    largestSumOfAverages_813.largestSumOfAverages(new int[]{9,1,2,3,9}, 3);
  }
  // 813. 最大平均值和的分组
  public double largestSumOfAverages(int[] A, int K) {
    int length = A.length;
    for (int i = 1; i < length; i++) {
      A[i] += A[i-1];
    }
    double[][] dp = new double[length+1][K+1];
    // 前i个数 分为k个数组 得到的最大平均值和
    for (int i = 1; i <= length; i++) {
      for (int j = 1; j <= K; j++) {
        if (j == 1) {
          dp[i][j] = (double)A[i-1]/(double)i;
          continue;
        }
        for (int k = i-1; k >= j-1; k--) {
          dp[i][j] = Math.max(dp[i][j], (double)(A[i-1]-A[k-1])/(double)(i-k)+dp[k][j-1]);
        }
      }
    }
    return dp[length][K];
  }
}
