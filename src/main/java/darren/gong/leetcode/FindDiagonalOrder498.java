package darren.gong.leetcode;

public class FindDiagonalOrder498 {
  public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[0];
    }
    int maxX = matrix.length;
    int maxY = matrix[0].length;
    int index = 0;
    int[] result = new int[maxX*maxY];
    int currentX = 0;
    int currentY = 0;
    boolean up = true;
    while (index < result.length) {
      result[index++] = matrix[currentX][currentY];
      if (up) {
        currentX = currentX-1;
        currentY = currentY+1;
        if (currentY >= maxY) {
          currentX = currentX+2;
          currentY = maxY-1;
          up = false;
        } else if (currentX < 0) {
          currentX = 0;
          up = false;
        }
      } else {
        currentX = currentX+1;
        currentY = currentY-1;
        if (currentX >= maxX) {
          currentY = currentY+2;
          currentX = maxX-1;
          up = true;
        } else if (currentY < 0) {
          currentY = 0;
          up = true;
        }
      }
    }
    return result;
  }
}
