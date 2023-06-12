package darren.gong.leetcode;

import java.util.Arrays;

public class DeleteGreatestValue_2500 {
  public int deleteGreatestValue(int[][] grid) {
    for (int[] one : grid) {
      Arrays.sort(one);
    }
    int maxX = grid.length;
    int maxY = grid[0].length;
    int result = 0;
    for (int j = 0; j < maxY; j++) {
      int max = 0;
      for (int i = 0; i < maxX; i++) {
        max = Math.max(max, grid[i][j]);
      }
      result += max;
    }
    return result;
  }
}
