package darren.gong.leetcode;

import java.util.Arrays;

public class MaximumWealth1672 {
  public int maximumWealth(int[][] accounts) {
    if (accounts == null || accounts.length == 0) {
      return 0;
    }
    int maxX = accounts.length;
    int maxY = accounts[0].length;
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < maxX; i++) {
      int onePeople = 0;
      for (int j = 0; j < maxY; j++) {
        onePeople += accounts[i][j];
      }
      result = Math.max(result, onePeople);
    }
    return result;
  }
}
