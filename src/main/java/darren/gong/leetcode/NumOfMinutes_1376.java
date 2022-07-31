package darren.gong.leetcode;

import java.util.Arrays;

public class NumOfMinutes_1376 {
  private int[] min;
  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    min = new int[n];
    Arrays.fill(min, Integer.MAX_VALUE);
    min[headID] = 0;
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      result = Math.max(result, countMin(i, manager, informTime));
    }
    return result;
  }
  private int countMin(int n, int[] manager, int[] informTime) {
    if (min[n] != Integer.MAX_VALUE) {
      return min[n];
    }
    min[n] = informTime[manager[n]]+countMin(manager[n], manager, informTime);
    return min[n];
  }
}
