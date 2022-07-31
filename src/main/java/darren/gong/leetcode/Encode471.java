package darren.gong.leetcode;

public class Encode471 {
  public String encode(String s) {
    int length = s.length();
    String[][] dp = new String[length][length];
    for (int range = 1; range <= length; range++) {
      int right;
      for (int left = 0; (right = left+range-1) < length; left++) {
        if (range == 1) {
          dp[left][right] = s.charAt(left)+"";
        }
        String subString = s.substring(left, right+1);
        dp[left][right] = subString;
        int position = (subString+subString).indexOf(subString, 1);
        if (position != -1) {
          String repeat = subString.substring(0, position);
          dp[left][right] = dp[left][right].length() < repeat.length()+3 ?
              dp[left][right] : subString.length()/position + "[" + dp[left][left+position-1] + "]";
        }

        for (int mid = left; mid < right; mid++) {
          if (dp[left][mid].length()+dp[mid+1][right].length() < dp[left][right].length()) {
            dp[left][right] = dp[left][mid]+dp[mid+1][right];
          }
        }
      }
    }
    return dp[0][length-1];
  }
}
