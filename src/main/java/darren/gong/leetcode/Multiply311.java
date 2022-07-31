package darren.gong.leetcode;

public class Multiply311 {
  public int[][] multiply(int[][] A, int[][] B) {
    if (A == null || A.length == 0 || B == null || B.length == 0 || B[0].length == 0) {
      return new int[0][0];
    }
    int AMaxX = A.length;
    int AMaxY = A[0].length;
    int BMaxY = B[0].length;
    int[][] result = new int[AMaxX][BMaxY];
    for (int i = 0; i < AMaxX; i++) {
      for (int j = 0; j < BMaxY; j++) {
        int sum = 0;
        for (int k = 0; k < AMaxY; k++) {
          sum += A[i][k]*B[k][j];
        }
        result[i][j] = sum;
      }
    }
    return result;
  }
}
