package darren.gong.leetcode;

public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxX = matrix.length;
        int maxY = matrix[0].length;
        int[][] dp = new int[maxX+1][maxY+1];
        for (int i = 1; i <= maxX; i++) {
            for (int j = 1; j <= maxY; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= maxX; i++) {
            for (int j = 1; j <= maxY; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }
        return result*result;
    }
}
