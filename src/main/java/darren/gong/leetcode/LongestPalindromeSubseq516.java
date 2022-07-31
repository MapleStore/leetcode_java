package darren.gong.leetcode;

public class LongestPalindromeSubseq516 {
    public int longestPalindromeSubseq(String s) {
        if (s == null) {
            return -1;
        }
        if (s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = length-1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2 + dp[i+1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[0][length-1];
    }
}
