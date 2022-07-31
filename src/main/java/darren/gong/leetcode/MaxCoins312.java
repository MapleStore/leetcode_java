package darren.gong.leetcode;

import java.util.Arrays;

public class MaxCoins312 {
  public int maxCoins(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int length = nums.length;
    int[] insteadNums = new int[length+2];
    insteadNums[0] = 1;
    insteadNums[length+1] = 1;
    for (int i = 0; i < length; i++) {
      insteadNums[i+1] = nums[i];
    }

    length = length+2;
    int[][] dp = new int[length][length];
    for (int size = 3; size <= length; size++) {
      for (int start = 0; start+size <= length; start++) {
        int end = start+size-1;
        for (int k = start+1; k < end; k++) {
          dp[start][end] = Math.max(dp[start][end], dp[start][k]+dp[k][end]+insteadNums[start]*insteadNums[k]*insteadNums[end]);
        }
      }
    }
    return dp[0][length-1];
  }
}
