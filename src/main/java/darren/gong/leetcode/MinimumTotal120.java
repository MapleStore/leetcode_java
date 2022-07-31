package darren.gong.leetcode;

import java.util.List;

public class MinimumTotal120 {
    public static void main(String[] args) {
        MinimumTotal120 minimumTotal120 = new MinimumTotal120();
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        dp[1][1] = triangle.get(0).get(0);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= triangle.get(i-1).size(); j++) {
                if (j == 1) {
                    dp[i][j] = dp[i-1][j]+triangle.get(i-1).get(j-1);
                } else if (j == triangle.get(i-1).size()) {
                    dp[i][j] = dp[i-1][j-1]+triangle.get(i-1).get(j-1);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1])+triangle.get(i-1).get(j-1);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            result = Math.min(result, dp[n][i]);
        }
        return result;
    }
}
