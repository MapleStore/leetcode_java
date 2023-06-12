package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BeautifulPartitions_2478 {
  public static void main(String[] args) {
    BeautifulPartitions_2478 beautifulPartitions_2478 = new BeautifulPartitions_2478();
    beautifulPartitions_2478.beautifulPartitions("23542185131", 3, 2);
  }
  private int MOD = 1000000007;
  public int beautifulPartitions(String s, int k, int minLength) {
    Set<Character> valid = new HashSet<>(Arrays.asList('2','3','5','7'));
    int length = s.length();
    long[][] cache = new long[length][k+1];
    long[][] dp = new long[length][k+1];
    for (int i = minLength-1; i < length; i++) {
      for (int size = 1; size <= k; size++) {
        if (!valid.contains(s.charAt(i))) {
          if (size == 1) {
            dp[i][size] = valid.contains(s.charAt(0)) ? 1 : 0;
          } else {
            dp[i][size] = i-minLength < 0 ? 0 :cache[i-minLength][size-1];
          }
        }

        cache[i][size] = i-1 < 0 ? 0 : cache[i-1][size];
        if (i < length-1 && valid.contains(s.charAt(i+1))) {
          cache[i][size] += dp[i][size];
          cache[i][size] %= MOD;
        }
      }
    }
    return (int)dp[length-1][k];
  }
}
