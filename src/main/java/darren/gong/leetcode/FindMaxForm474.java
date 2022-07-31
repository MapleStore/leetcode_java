package darren.gong.leetcode;

public class FindMaxForm474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        // 前i个str 最多可以被j个0 k个1拼出多少个
        int strLength = strs.length;
        int[][][] dp = new int[strLength+1][m+1][n+1];
        for (int i = 1; i <= strLength; i++) {
            int numOf0 = 0;
            int numOf1 = 0;
            for (char oneChar : strs[i-1].toCharArray()) {
                if (oneChar == '0') {
                    numOf0++;
                }
                if (oneChar == '1') {
                    numOf1++;
                }
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (numOf0 <= j && numOf1 <= k) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-numOf0][k-numOf1]+1);
                    } else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[strLength][m][n];
    }
}
