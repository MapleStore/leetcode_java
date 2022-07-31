package darren.gong.leetcode;

import java.util.Arrays;

public class FindLongestChain646 {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0 || pairs[0] == null || pairs[0].length == 0) {
            return 0;
        }
        int length = pairs.length;
        int[] dp = new int[length+1];
        int max = 0;
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        for (int i = 1; i <= length; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (pairs[i-1][0] > pairs[j-1][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
