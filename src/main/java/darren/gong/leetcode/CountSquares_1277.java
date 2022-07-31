package darren.gong.leetcode;

public class CountSquares_1277 {
  // 1277. 统计全为 1 的正方形子矩阵
  public static void main(String[] args) {
    CountSquares_1277 countSquares_1277 = new CountSquares_1277();
    countSquares_1277.countSquares(new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}});
  }
  public int countSquares(int[][] matrix) {
    int maxX = matrix.length;
    int maxY = matrix[0].length;
    int[][] left = new int[maxX][maxY];
    int[][] up = new int[maxX][maxY];

    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (i == 0) {
          up[i][j] = matrix[i][j];
          continue;
        }
        up[i][j] = matrix[i][j] == 0 ? 0 : up[i-1][j]+1;
      }
    }
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (j == 0) {
          left[i][j] = matrix[i][j];
          continue;
        }
        left[i][j] = matrix[i][j] == 0 ? 0 : left[i][j-1]+1;
      }
    }

    int result = 0;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (matrix[i][j] == 0) {
          continue;
        }
        int length = 2;
        while (i-length+1 >= 0 && j-length+1 >= 0 && length <= left[i-length+1][j] && length <= up[i][j-length+1]) {
          length++;
        }
        result += length-1;
      }
    }
    return result;
  }

  public int countSquares2(int[][] matrix) {
    int maxX = matrix.length;
    int maxY = matrix[0].length;

    int result = 0;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (matrix[i][j] == 0) {
          continue;
        }
        if (i == 0 || j == 0) {
          matrix[i][j] = 1;
        } else {
          matrix[i][j] = Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]))+1;
        }
        result += matrix[i][j];
      }
    }
    return result;
  }
}
