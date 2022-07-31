package darren.gong.leetcode.offer;

public class TranslateNum_41 {
  // 剑指 Offer 46. 把数字翻译成字符串
  public int translateNum(int num) {
    StringBuilder numStr = new StringBuilder(""+num);
    int[] dp = new int[numStr.length()+1];
    dp[numStr.length()] = 1;
    dp[numStr.length()-1] = 1;
    for (int i = numStr.length()-2; i >= 0; i--) {
      dp[i] = dp[i+1];
      char current = numStr.charAt(i);
      char next = numStr.charAt(i+1);
      if (current == '1' || (current == '2' && next >= '0' && next <= '5')) {
        dp[i] += dp[i+2];
      }
    }
    return dp[0];
  }
}
