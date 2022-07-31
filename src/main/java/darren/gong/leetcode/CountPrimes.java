package darren.gong.leetcode;

import java.util.Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        for (int i = 2; i < Math.sqrt(n); i++) {
            for (int j = i * i; j <= n; j+=i) {
                primes[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }

}
