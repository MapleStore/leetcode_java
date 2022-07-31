package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PerfectSquares {
    public int numSquares(int n) {
        if (n <= 0) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        int gap = 1;
        for (int i = 1; i <= n; i+=gap) {
            list.add(i);
            gap += 2;
        }

        int []dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int square:list) {
                if (square > i) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i-square]+1);
            }
        }

        return dp[n];
    }
}
