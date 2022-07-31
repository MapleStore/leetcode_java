package darren.gong.leetcode;

public class MaxSubArray_53 {
  // 53. 最大子序和
  // 贪心思想
  public int maxSubArray(int[] nums) {
    if (nums.length <= 0) {
      return 0;
    }
    int maxSum = Integer.MIN_VALUE;
    int sum = 0;
    for (int num : nums) {
      if (sum < 0) {
        sum = 0;
      }
      sum += num;
      maxSum = Math.max(maxSum, sum);
    }
    return maxSum;
  }

  // Kadane算法
  public int maxSubArray2(int[] nums) {
    int length = nums.length;
    int[] dp = new int[length];
    dp[0] = nums[0];
    for (int i = 1; i < length; i++) {
      dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
    }
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < length; i++) {
      result = Math.max(result, dp[i]);
    }
    return result;
  }
}
