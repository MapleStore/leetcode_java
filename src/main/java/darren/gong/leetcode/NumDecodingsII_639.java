package darren.gong.leetcode;

public class NumDecodingsII_639 {
  public static void main(String[] args) {
    NumDecodingsII_639 numDecodingsII_639 = new NumDecodingsII_639();
    numDecodingsII_639.numDecodings("*010");
  }
  private final long MOD = 1000000000+7;
  public int numDecodings(String s) {
    char[] chars = s.toCharArray();
    int length = s.length();
    long[] dp = new long[length];
    for (int i = length-1; i >= 0; i--) {
      char current = chars[i];
      if (current == '*') {
        if (i == length-1) {
          dp[i] = 9;
          continue;
        }
        dp[i] = 9*dp[i+1];
        dp[i] = dp[i]%MOD;
        // 1和后一个凑
        if (chars[i+1] >= '0' && chars[i+1] <= '9') {
          dp[i] += i+2 < length ? dp[i+2] : 1;
        } else {
          dp[i] += i+2 < length ? 9*dp[i+2] : 9;
        }
        dp[i] = dp[i]%MOD;
        // 2和后一个凑
        if (chars[i+1] >= '0' && chars[i+1] <= '6') {
          dp[i] += i+2 < length ? dp[i+2] : 1;
        } else if (chars[i+1] == '*') {
          dp[i] += i+2 < length ? 6*dp[i+2] : 6;
        }
        dp[i] = dp[i]%MOD;
      } else {
        if (current == '0') {
          dp[i] = 0;
          continue;
        }
        if (i == length-1) {
          dp[i] = 1;
          continue;
        }
        // 自己为一个编码
        dp[i] = dp[i+1];
        // 和后面的凑成编码
        if (current == '1') {
          if (chars[i+1] >= '0' && chars[i+1] <= '9') {
            dp[i] += i+2 < length ? dp[i+2] : 1;
          } else {
            dp[i] += i+2 < length ? 9*dp[i+2] : 9;
          }
        } else if (current == '2') {
          if (chars[i+1] >= '0' && chars[i+1] <= '6') {
            dp[i] += i+2 < length ? dp[i+2] : 1;
          } else if (chars[i+1] == '*') {
            dp[i] += i+2 < length ? 6*dp[i+2] : 6;
          }
        }
        dp[i] = dp[i]%MOD;
      }
    }
    return (int) dp[0];
  }
}
