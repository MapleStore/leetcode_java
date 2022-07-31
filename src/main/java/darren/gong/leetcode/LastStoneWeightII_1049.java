package darren.gong.leetcode;

public class LastStoneWeightII_1049 {
  // 1049. 最后一块石头的重量 II
  public static void main(String[] args) {
    LastStoneWeightII_1049 lastStoneWeightII_1049 = new LastStoneWeightII_1049();
    lastStoneWeightII_1049.lastStoneWeightII(new int[]{2,7,4,1,8,1});
  }
  public int lastStoneWeightII(int[] stones) {
    int length = stones.length;
    int sum = 0;
    for (int stone : stones) {
      sum += stone;
    }
    int mid = sum/2;
    // 前i个数 最接近j的和
    int[][] dp = new int[length][mid+1];
    for (int i = 0; i < length; i++) {
      for (int j = 0; j <= mid; j++) {
        if (i == 0) {
          dp[i][j] = j >= stones[i] ? stones[i] : 0;
          continue;
        }

        dp[i][j] = j >= stones[i] ? Math.max(dp[i-1][j-stones[i]]+stones[i], dp[i-1][j]) : dp[i-1][j];
      }
    }
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < length; i++) {
      result = Math.max(result, dp[i][mid]);
    }
    return sum-2*result;
  }
}
