package darren.gong.leetcode;

public class GetMaxLen_1567 {
  public static void main(String[] args) {
    GetMaxLen_1567 getMaxLen_1567 = new GetMaxLen_1567();
    getMaxLen_1567.getMaxLen(new int[]{0,1,-2,-3,-4});
  }
  public int getMaxLen(int[] nums) {
    int length = nums.length;
    // 以i结尾的数  乘积为 0:正数 或者 1:负数 的最长子数组长度
    int[][] dp = new int[length][2];
    int result = dp[0][0] = nums[0] > 0 ? 1 : 0;
    dp[0][1] = nums[0] < 0 ? 1 : 0;
    for (int i = 1; i < length; i++) {
      if (nums[i] == 0) {
        dp[i][0] = dp[i][1] = 0;
        continue;
      }
      dp[i][0] = nums[i] > 0 ? dp[i-1][0]+1 : (dp[i-1][1] == 0 ? 0 : dp[i-1][1]+1);
      dp[i][1] = nums[i] > 0 ? (dp[i-1][1] == 0 ? 0 : dp[i-1][1]+1) : dp[i-1][0]+1;
      result = Math.max(result, dp[i][0]);
    }
    return result;
  }
}
