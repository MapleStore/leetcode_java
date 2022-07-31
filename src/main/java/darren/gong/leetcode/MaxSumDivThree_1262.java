package darren.gong.leetcode;

public class MaxSumDivThree_1262 {
  // 1262. 可被三整除的最大和
  public static void main(String[] args) {
    MaxSumDivThree_1262 maxSumDivThree_1262 = new MaxSumDivThree_1262();
    maxSumDivThree_1262.maxSumDivThree(new int[]{3,6,5,1,8});
  }
  public int maxSumDivThree(int[] nums) {
    int length = nums.length;
    // 前i个数 mod3的余数为j的最大和
    int[] dp = new int[3];

    for (int i = 0; i < length; i++) {
      int[] newDp = new int[3];
      newDp[0] = dp[0];
      newDp[1] = dp[1];
      newDp[2] = dp[2];
      for (int j = 0; j < 3; j++) {
        int nextPos = (dp[j]+nums[i])%3;
        newDp[nextPos] = Math.max(newDp[nextPos], dp[j]+nums[i]);
      }
      dp = newDp;
    }
    return dp[0];
  }
}
