package darren.gong.leetcode;

public class MaximalNetworkRank1615 {
  public int maximalNetworkRank(int n, int[][] roads) {
    boolean[][] havePath = new boolean[n][n];
    int[] value = new int[n];
    for (int[] road : roads) {
      value[road[0]]++;
      value[road[1]]++;
      havePath[Math.min(road[0], road[1])][Math.max(road[0], road[1])] = true;
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n; j++) {
        int currentValue = value[i]+value[j];
        if (havePath[i][j]) {
          currentValue -= 1;
        }
        result = Math.max(currentValue, result);
      }
    }
    return result;
  }
}
