package darren.gong.leetcode.offer;

public class MaxValue_47 {
  public int maxValue(int[][] grid) {
    int maxX = grid.length;
    int maxY = grid[0].length;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        int left = j == 0 ? 0 : grid[i][j-1];
        int up = i == 0 ? 0 : grid[i-1][j];
        grid[i][j] += Math.max(left, up);
      }
    }
    return grid[maxX-1][maxY-1];
  }
}
