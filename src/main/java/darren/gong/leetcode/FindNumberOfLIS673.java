package darren.gong.leetcode;

public class FindNumberOfLIS673 {
  public static void main(String[] args) {
    FindNumberOfLIS673 findNumberOfLIS673 = new FindNumberOfLIS673();
    findNumberOfLIS673.findNumberOfLIS(new int[]{1,3,5,4,7});
  }
  public int findNumberOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int length = nums.length;
    int[] dp = new int[length];
    int[] tempResult = new int[length];
    dp[0] = 1;
    tempResult[0] = 1;
    for (int i = 1; i < length; i++) {
      dp[i] = 1;
      tempResult[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          if (dp[j]+1 > dp[i]) {
            dp[i] = dp[j]+1;
            tempResult[i] = tempResult[j];
          } else if (dp[j]+1 == dp[i]) {
            tempResult[i] += tempResult[j];
          }
        }
      }
    }

    int max = 1;
    for (int value : dp) {
      max = Math.max(max, value);
    }
    int result = 0;
    for (int i = 0; i < length; i++) {
      if (dp[i] == max) {
        result += tempResult[i];
      }
    }
    return result;
  }
}
