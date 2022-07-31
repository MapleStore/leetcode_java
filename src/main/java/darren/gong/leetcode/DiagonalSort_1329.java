package darren.gong.leetcode;

public class DiagonalSort_1329 {
  private int maxX;
  private int maxY;
  public int[][] diagonalSort(int[][] mat) {
    maxX = mat.length;
    maxY = mat[0].length;
    for (int y = 0; y < maxY; y++) {
      sort(mat, 0, y);
    }
    for (int x = 1; x < maxX; x++) {
      sort(mat, x, 0);
    }
    return mat;
  }
  private void sort(int[][] mat, int x, int y) {
    int[] count = new int[101];
    int tempX = x;
    int tempY = y;
    while (tempX < maxX && tempY < maxY) {
      count[mat[tempX++][tempY++]]++;
    }
    for (int i = 1; i <= 100; i++) {
      while (count[i]-- > 0) {
        mat[x++][y++] = i;
      }
    }
  }
}
