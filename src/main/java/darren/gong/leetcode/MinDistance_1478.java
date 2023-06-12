package darren.gong.leetcode;

import java.util.Arrays;

public class MinDistance_1478 {
  public static void main(String[] args) {
    MinDistance_1478 minDistance_1478 = new MinDistance_1478();
    minDistance_1478.minDistance(new int[]{1,4,8,10,20}, 3);
  }
  private int[] houses;
  private int[] postHouses;
  // 可用区间dp预处理中间sum 比此方法更简便
  public int minDistance(int[] houses, int k) {
    Arrays.sort(houses);
    this.houses = houses;
    int length = houses.length;
    int[] preSum = new int[length];
    preSum[0] = houses[0];
    for (int i = 1; i < length; i++) {
      preSum[i] = houses[i]+preSum[i-1];
    }
    postHouses = new int[length];
    for (int i = 0; i < length; i++) {
      postHouses[i] = 10000-houses[i];
    }
    int[] postSum = new int[length];
    postSum[length-1] = postHouses[length-1];
    for (int i = length-2; i >= 0; i--) {
      postSum[i] = postSum[i+1]+postHouses[i];
    }

    int[][] dp = new int[length][k+1];
    for (int i = 0; i < length; i++) {
      for (int num = 1; num <= k; num++) {
        dp[i][num] = 999999999;
        if (i < num) {
          dp[i][num] = 0;
          continue;
        }
        if (num == 1) {
          dp[i][num] = count(0, i, preSum, postSum);
          continue;
        }
        for (int pre = i; pre >= 1; pre--) {
          dp[i][num] = Math.min(dp[i][num], dp[pre-1][num-1]+count(pre, i, preSum, postSum));
        }
      }
    }
    return dp[length-1][k];
  }

  private int count(int from, int to, int[] preSum, int[] postSum) {
    int mid = (from+to)>>1;
    return (preSum[to]-preSum[mid]-(to-mid)*houses[mid])+(postSum[from]-postSum[mid]-(mid-from)*postHouses[mid]);
  }
}
