package darren.gong.leetcode;

public class KnightDialer935 {
    public int knightDialer(int n) {
        int max = (int)Math.pow(10, 9)+7;
        int[][][] dp = new int[n][3][4];
        int[][] directions = new int[][]{{1,2},{1,-2},{-1,2},{-1,-2},{2,-1},{2,1},{-2,-1},{-2,1}};
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                dp[0][j][k] = 1;
            }
        }
        dp[0][1][3] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    if ((j == 0 && k == 3) || (j == 2 && k == 3)) {
                        continue;
                    }
                    for (int[] direction : directions) {
                        int preX = j+direction[0];
                        int preY = k+direction[1];
                        if (preX >= 0 && preX < 3 && preY >= 0 && preY < 4) {
                            dp[i][j][k] += dp[i-1][preX][preY];
                            if (dp[i][j][k] > max) {
                                dp[i][j][k] = dp[i][j][k]%max;
                            }
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                result += dp[n-1][j][k];
                if (result > max) {
                    result = result%max;
                }
            }
        }
        result += dp[n-1][1][3];
        if (result > max) {
            result = result%max;
        }
        return result;
    }
}
