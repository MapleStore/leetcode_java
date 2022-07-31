package darren.gong.leetcode;

import java.util.Arrays;

public class SplitArray410 {
  public static void main(String[] args) {
    SplitArray410 splitArray410 = new SplitArray410();
    splitArray410.splitArray(new int[]{7,2,5,10,8}, 2);
  }
  public int splitArray(int[] nums, int m) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int length = nums.length;
    if (length < m) {
      return Arrays.stream(nums).max().getAsInt();
    }
    for (int i = 1; i < length; i++) {
      nums[i] += nums[i-1];
    }
    // 前i个数 切成j块的各自和的最小值
    int[][] dp = new int[length+1][m+1];
    for (int i = 1; i <= length; i++) {
      for (int j = 1; j <= m && j <= i; j++) {
        if (j == 1) {
          dp[i][j] = nums[i-1];
          continue;
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = j-1; k < i; k++) {
          dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], nums[i-1]-nums[k-1]));
        }
      }
    }
    return dp[length][m];
  }
}
