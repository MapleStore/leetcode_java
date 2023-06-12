package darren.gong.leetcode;

public class MaxSumOfThreeSubarrays_689 {
  public static void main(String[] args) {
    MaxSumOfThreeSubarrays_689 maxSumOfThreeSubarrays_689 = new MaxSumOfThreeSubarrays_689();
    maxSumOfThreeSubarrays_689.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2);
  }
  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int length = nums.length;
    int[] preSum = new int[length];
    preSum[0] = nums[0];
    for (int i = 1; i < length; i++) {
      preSum[i] = preSum[i-1]+nums[i];
    }
    int[][] results = new int[4][length];
    int[][] dp = new int[4][length];
    for (int splitNum = 1; splitNum <= 3; splitNum++) {
      for (int index = splitNum*k-1; index < nums.length; index++) {
        if (index+1 == splitNum*k) {
          dp[splitNum][index] = preSum[index];
          results[splitNum][index] = index-k+1;
          continue;
        }
        dp[splitNum][index] = dp[splitNum][index-1];
        results[splitNum][index] = results[splitNum][index-1];

        if (dp[splitNum-1][index-k]+preSum[index]-preSum[index-k] > dp[splitNum][index]) {
          dp[splitNum][index] = dp[splitNum-1][index-k]+preSum[index]-preSum[index-k];
          results[splitNum][index] = index-k+1;
        }
      }
    }
    int[] result = new int[3];
    result[2] = results[3][length-1];
    result[1] = results[2][result[2]-1];
    result[0] = results[1][result[1]-1];
    return result;
  }
}
