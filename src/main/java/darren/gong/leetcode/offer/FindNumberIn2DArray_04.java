package darren.gong.leetcode.offer;

public class FindNumberIn2DArray_04 {
  public boolean findNumberIn2DArray(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return false;
    }
    int maxX = matrix.length;
    int maxY = matrix[0].length;
    int x = 0;
    int y = maxY-1;
    while (x < maxX && y >= 0) {
      if (matrix[x][y] == target) {
        return true;
      }
      if (matrix[x][y] > target) {
        y--;
      } else {
        x++;
      }
    }
    return false;
  }
}
