package darren.gong.leetcode;

import java.util.Arrays;

public class NthSuperUglyNumber_313 {
    public static void main(String[] args) {
        NthSuperUglyNumber_313 nthSuperUglyNumber_313 = new NthSuperUglyNumber_313();
        nthSuperUglyNumber_313.nthSuperUglyNumber(12, new int[]{2,7,13,19});
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        int[] targets = new int[primes.length];
        Arrays.fill(targets, 1);
        for (int i = 2; i <= n; i++) {
            int[] temp = new int[primes.length];
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                temp[j] = dp [targets[j]]*primes[j];
                min = Math.min(min, temp[j]);
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (min == dp [targets[j]]*primes[j]) {
                    targets[j]++;
                }
            }
        }
        return dp[n];
    }
}
