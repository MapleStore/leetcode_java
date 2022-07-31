package darren.gong.leetcode;

public class MaxIncreaseKeepingSkyline_807 {
  // 807. 保持城市天际线
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int length = grid.length;
    int[] rows = new int[length];
    int[] cols = new int[length];
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        rows[i] = Math.max(rows[i], grid[i][j]);
        cols[j] = Math.max(cols[j], grid[i][j]);
      }
    }
    int result = 0;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        result += Math.min(rows[i], cols[j])-grid[i][j];
      }
    }
    return result;
  }
}
