package darren.gong.leetcode;

public class CountNegatives1351 {
  public int countNegatives(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int maxX = grid.length;
    int maxY = grid[0].length;
    int currentX = 0;
    int currentY = maxY-1;
    int result = 0;
    while (currentX < maxX && currentY >= 0) {
      if (grid[currentX][currentY] < 0) {
        result += maxX-currentX;
        currentY--;
      } else {
        currentX++;
      }
    }
    return result;
  }
}
