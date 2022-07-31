package darren.gong.leetcode.offer;

public class NthUglyNumber_49 {
  // 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数
  public int nthUglyNumber(int n) {
    if (n == 1) {
      return 1;
    }
    int n2Index = 0;
    int n3Index = 0;
    int n5Index = 0;
    int[] dp = new int[n];
    dp[0] = 1;

    for (int i = 1; i < n; i++) {
      int num2 = dp[n2Index]*2;
      int num3 = dp[n3Index]*3;
      int num5 = dp[n5Index]*5;

      int min = Math.min(Math.min(num2, num3), num5);
      if (min == num2) {
        n2Index++;
      }
      if (min == num3) {
        n3Index++;
      }
      if (min == num5) {
        n5Index++;
      }
      dp[i] = min;
    }
    return dp[n-1];
  }
}
