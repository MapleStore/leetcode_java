package darren.gong.leetcode;

public class IslandPerimeter463 {
  public int islandPerimeter(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int maxX = grid.length;
    int maxY = grid[0].length;
    int islandNum = 0;
    int islandClose = 0;
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (grid[i][j] == 1) {
          islandNum++;
          for (int[] direction : directions) {
            int nextX = i+direction[0];
            int nextY = j+direction[1];
            if (nextX >= 0 && nextY >= 0 && nextX < maxX && nextY < maxY && grid[nextX][nextY] == 1) {
              islandClose++;
            }
          }
        }
      }
    }
    return islandNum*4-islandClose;
  }
}
