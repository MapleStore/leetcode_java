package darren.gong.leetcode;

public class LongestValidParentheses32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length];
        char[] charArr = s.toCharArray();
        int result = 0;
        for (int i = 1; i < length; i++) {
            if (charArr[i] == ')') {
                if (charArr[i-1] == '(') {
                    dp[i] = i-2 >= 0 ? dp[i-2] + 2 : 2;
                } else if (i-dp[i-1]-1 >= 0 && charArr[i-dp[i-1]-1] == '(') {
                    dp[i] = dp[i-1]+2+(i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0);
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }
}
