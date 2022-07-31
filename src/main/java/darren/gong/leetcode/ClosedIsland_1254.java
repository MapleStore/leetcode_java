package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ClosedIsland_1254 {
  // 1254. 统计封闭岛屿的数目
  private int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
  public int closedIsland(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
      return 0;
    }
    int maxX = grid.length;
    int maxY = grid[0].length;
    int result = 0;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (grid[i][j] != 0) {
          continue;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = 2;
        boolean isClosed = true;
        while (!queue.isEmpty()) {
          int[] current = queue.poll();
          if (current[0] == maxX-1 || current[0] == 0 || current[1] == maxY-1 || current[1] == 0) {
            isClosed = false;
          }
          for (int[] direction : directions) {
            int nextX = current[0]+direction[0];
            int nextY = current[1]+direction[1];
            if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY && grid[nextX][nextY] == 0) {
              grid[nextX][nextY] = 2;
              queue.add(new int[]{nextX, nextY});
            }
          }
        }
        if (isClosed) {
          result++;
        }
      }
    }
    return result;
  }
}
