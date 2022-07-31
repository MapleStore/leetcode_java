package darren.gong.leetcode.race;

public class MaxResult1696 {
  public static void main(String[] args) {
    MaxResult1696 maxResult1696 = new MaxResult1696();
    maxResult1696.maxResult(new int[]{1,-1,-2,4,-7,3}, 2);
  }
  public int maxResult(int[] nums, int k) {
    if (nums.length == 1) {
      return nums[0];
    }
    int length = nums.length;
    int[] dp = new int[length];
    dp[0] = nums[0];
    for (int i = 1; i < length; i++) {
      dp[i] = Integer.MIN_VALUE;
    }
    for (int i = 0; i < length; i++) {
      for (int j = i+1; j < length && j <= i+k; j++) {
        int nextNum = dp[i]+nums[j];
        if (dp[j] < nextNum) {
          dp[j] = nextNum;
        }
        if (dp[j] >= dp[i]) {
          break;
        }
      }
    }
    return dp[length-1];
  }
}
