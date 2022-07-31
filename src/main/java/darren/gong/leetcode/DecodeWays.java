package darren.gong.leetcode;

public class DecodeWays {
    public int numDecodings(String s) {
        int []dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }
            if (s.charAt(i-2) == '0') {
                continue;
            }
            int two = (s.charAt(i-2) - '0')*10 + s.charAt(i-1)-'0';
            if (two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
