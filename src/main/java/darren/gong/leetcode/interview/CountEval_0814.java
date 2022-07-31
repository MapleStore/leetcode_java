package darren.gong.leetcode.interview;

public class CountEval_0814 {
  // 面试题 08.14. 布尔运算
  public static void main(String[] args) {
    CountEval_0814 countEval_0814 = new CountEval_0814();
    countEval_0814.countEval("1^0|0|1", 0);
  }
  public int countEval(String s, int result) {
    int length = s.length();
    if (length == 0) {
      return 0;
    }
    int[] nums = new int[length/2+1];
    char[] operation = new char[length/2];
    for (int i = 0; i < length; i++) {
      if (i%2 == 0) {
        nums[i/2] = s.charAt(i)-'0';
      } else {
        operation[i/2] = s.charAt(i);
      }
    }
    int numLength = nums.length;
    int[][][] dp = new int[numLength][numLength][2];
    for (int distance = 1; distance <= numLength; distance++) {
      for (int left = 0; left+distance-1 < numLength; left++) {
        int right = left+distance-1;
        if (distance == 1) {
          dp[left][right][0] = nums[left] == 0 ? 1 : 0;
          dp[left][right][1] = nums[left] == 1 ? 1 : 0;
          continue;
        }
        for (int opIndex = left; opIndex < right; opIndex++) {
          if (operation[opIndex] == '|') {
            dp[left][right][0] += dp[left][opIndex][0]*dp[opIndex+1][right][0];

            dp[left][right][1] += dp[left][opIndex][1]*dp[opIndex+1][right][0];
            dp[left][right][1] += dp[left][opIndex][0]*dp[opIndex+1][right][1];
            dp[left][right][1] += dp[left][opIndex][1]*dp[opIndex+1][right][1];
          } else if (operation[opIndex] == '&') {
            dp[left][right][0] += dp[left][opIndex][0]*dp[opIndex+1][right][0];
            dp[left][right][0] += dp[left][opIndex][0]*dp[opIndex+1][right][1];
            dp[left][right][0] += dp[left][opIndex][1]*dp[opIndex+1][right][0];

            dp[left][right][1] += dp[left][opIndex][1]*dp[opIndex+1][right][1];
          } else {
            dp[left][right][1] += dp[left][opIndex][1]*dp[opIndex+1][right][0];
            dp[left][right][1] += dp[left][opIndex][0]*dp[opIndex+1][right][1];

            dp[left][right][0] += dp[left][opIndex][0]*dp[opIndex+1][right][0];
            dp[left][right][0] += dp[left][opIndex][1]*dp[opIndex+1][right][1];
          }
        }
      }
    }
    return dp[0][numLength-1][result];
  }
}
