package darren.gong.leetcode;

public class MinSwaps_1536 {
  // 1536. 排布二进制网格的最少交换次数
  public int minSwaps(int[][] grid) {
    int maxX = grid.length;
    int maxY = grid[0].length;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (j == 0) {
          grid[i][j] = grid[i][j] == 1 ? 0 : 1;
          continue;
        }
        if (grid[i][j] == 0) {
          grid[i][j] = grid[i][j-1]+1;
        } else {
          grid[i][j] = 0;
        }
      }
    }
    int need = maxX-1;
    int result = 0;
    for (int i = 0; i < maxX-1; i++) {
      int current = i;
      while (current < maxX && grid[current][maxY-1] < need) {
        current++;
      }
      if (current == maxX) {
        return -1;
      }
      result += current-i;
      while (current > i) {
        grid[current] = grid[current-1];
        current--;
      }
      need--;
    }
    return result;
  }
}
