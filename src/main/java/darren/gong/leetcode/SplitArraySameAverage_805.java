package darren.gong.leetcode;

import java.util.Arrays;

public class SplitArraySameAverage_805 {
  public static void main(String[] args) {
    SplitArraySameAverage_805 splitArraySameAverage_805 = new SplitArraySameAverage_805();
    splitArraySameAverage_805.splitArraySameAverage(new int[]{18,10,5,3});
  }
  public static class Fraction {
    int denominator;
    int numerator;
    public Fraction(int numerator, int denominator) {
      this.numerator = numerator;
      this.denominator = denominator;
    }
    public int multi(int val) {
      int newNumerator = val*numerator;
      if (newNumerator % denominator != 0) {
        return -1;
      }
      return newNumerator/denominator;
    }
  }

  public boolean splitArraySameAverage(int[] nums) {
    int length = nums.length;
    if (length <= 1) {
      return false;
    }
    int sum = Arrays.stream(nums).sum();
    Fraction avg = new Fraction(sum, length);
    // 前i个数 选取j个数 和是否可以为k
    boolean[][][] dp = new boolean[length+1][length+1][sum+1];
    dp[0][0][0] = true;
    for (int i = 1; i <= length; i++) {
      int lastNum = nums[i-1];
      for (int j = 0; j <= i; j++) {
        for (int k = 0; k < sum; k++) {
          if (j == 0) {
            dp[i][j][k] = k == 0;
            continue;
          }
          dp[i][j][k] = dp[i-1][j][k];
          if (k >= lastNum) {
            dp[i][j][k] |= dp[i-1][j-1][k-lastNum];
          }
        }
      }
    }
    for (int i = 1; i < length; i++) {
      int val = avg.multi(i);
      if (val == -1) {
        continue;
      }
      // pre个数里选i个数 和是否为val
      for (int pre = i; pre <= length; pre++) {
        if (dp[pre][i][val]) {
          return true;
        }
      }
    }
    return false;
  }
}
