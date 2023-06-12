package darren.gong.leetcode.lcp;

public class Domino_04 {
  public static void main(String[] args) {
    Domino_04 domino_04 = new Domino_04();
    domino_04.domino(3, 3, new int[][]{});
  }
  public int domino(int n, int m, int[][] broken) {
    int[] brokens = new int[n];
    for (int[] oneBroken : broken) {
      brokens[oneBroken[0]] |= (1<<oneBroken[1]);
    }
    int[][] dp = new int[n][1<<m];
    for (int i = 0; i < n; i++) {
      for (int mask = 0; mask < 1<<m; mask++) {
        int nextBroken = i+1 >= n ? (1<<m)-1 : brokens[i+1];
        if ((mask&brokens[i]) != 0 || (mask&nextBroken) != 0) {
          continue;
        }
        int count = Integer.bitCount(mask);
        for (int preLineMask = 0; preLineMask < (1<<m); preLineMask++) {
          if (i != 0 && ((preLineMask&brokens[i-1]) != 0 || (preLineMask&brokens[i]) != 0 || (preLineMask&mask) != 0)) {
            continue;
          }
          int current = preLineMask|brokens[i]|mask;
          int zeroCount = 0;
          int fillCount = 0;
          for (int pos = 0; pos < m; pos++) {
            if ((current&(1<<pos)) > 0) {
              fillCount += zeroCount/2;
              zeroCount = 0;
            } else {
              zeroCount++;
            }
          }
          fillCount += zeroCount/2;
          dp[i][mask] = Math.max(dp[i][mask], (i == 0 ? 0 :dp[i-1][preLineMask])+count+fillCount);
        }
      }
    }
    return dp[n-1][0];
  }
}
