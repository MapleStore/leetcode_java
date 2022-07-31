package darren.gong.leetcode;

public class PredictTheWinner486 {
  public boolean PredictTheWinner(int[] nums) {
    int length = nums.length;
    // 在i j范围内先手 能获得的最大得分
    int[][] dp = new int[length][length];
    for (int range = 0; range < length; range++) {
      for (int i = 0; i+range < length; i++) {
        int j = i+range;
        if (i == j) {
          dp[i][j] = nums[i];
          continue;
        }

        int choiceI = nums[i]-dp[i+1][j];
        int choiceJ = nums[j]-dp[i][j-1];
        dp[i][j] = Math.max(choiceI, choiceJ);
      }
    }
    return dp[0][length-1] >= 0;
  }
}
