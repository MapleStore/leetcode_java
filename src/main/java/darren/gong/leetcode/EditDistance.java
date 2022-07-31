package darren.gong.leetcode;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        int [][]dp = new int[word1Length+1][word2Length+1];
        for (int i = 1; i <= word1Length; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2Length; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1Length; i++) {
            for (int j = 1; j <= word2Length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
            }
        }
        return dp[word1Length][word2Length];
    }
}
