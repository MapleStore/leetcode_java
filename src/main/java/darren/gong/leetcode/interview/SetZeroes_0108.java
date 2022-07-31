package darren.gong.leetcode.interview;

public class SetZeroes_0108 {
  public void setZeroes(int[][] matrix) {
    int maxX = matrix.length;
    int maxY = matrix[0].length;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (matrix[i][j] != 0) {
          continue;
        }
        for (int k = 0; k < maxY; k++) {
          matrix[i][k] = matrix[i][k] == 0 ? 0 : -9381731;
        }
        break;
      }
    }
    for (int j = 0; j < maxY; j++) {
      for (int i = 0; i < maxX; i++) {
        if (matrix[i][j] != 0) {
          continue;
        }
        for (int k = 0; k < maxX; k++) {
          matrix[k][j] = matrix[k][j] == 0 ? 0 : -9381731;
        }
        break;
      }
    }
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        matrix[i][j] = matrix[i][j] == -9381731 ? 0 : matrix[i][j];
      }
    }
  }
}
