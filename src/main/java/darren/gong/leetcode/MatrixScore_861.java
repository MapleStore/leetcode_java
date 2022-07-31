package darren.gong.leetcode;

public class MatrixScore_861 {
  // 861. 翻转矩阵后的得分
  public int matrixScore(int[][] grid) {
    // 先用行反转把第一列变为全1 等价于 先用行反转把第一列变为全0，再对第一列进行反转
    int maxX = grid.length;
    int maxY = grid[0].length;
    for (int i = 0; i < maxX; i++) {
      if (grid[i][0] == 1) {
        continue;
      }
      for (int j = 0; j < maxY; j++) {
        grid[i][j] = 1-grid[i][j];
      }
    }

    for (int j = 0; j < maxY; j++) {
      int count = 0;
      for (int i = 0; i < maxX; i++) {
        if (grid[i][j] == 0) {
          count++;
        }
      }
      if (count <= (maxX>>>1)) {
        continue;
      }
      for (int i = 0; i < maxX; i++) {
        grid[i][j] = 1-grid[i][j];
      }
    }
    int result = 0;
    for (int[] line : grid) {
      result += getValue(line);
    }
    return result;
  }
  private int getValue(int[] line) {
    int result = 0;
    for (int num : line) {
      result = (result<<1)+num;
    }
    return result;
  }
}
