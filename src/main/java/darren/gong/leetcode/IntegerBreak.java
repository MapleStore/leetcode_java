package darren.gong.leetcode;

public class IntegerBreak {
    public int integerBreak(int n) {
        int []dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i] = Math.max(dp[i], Math.max((i-j)*j, dp[i-j]*j));
            }
        }
        return 0;
    }
}
