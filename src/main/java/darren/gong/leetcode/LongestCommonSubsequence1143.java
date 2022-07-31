package darren.gong.leetcode;

import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class LongestCommonSubsequence1143 {
    public static void main(String[] args) {
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return -1;
        }
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                } else {
                    dp[i][j] = Math.max(i-1 >= 0 ? dp[i-1][j] : 0, j-1 >= 0 ? dp[i][j-1] : 0);
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }
}
