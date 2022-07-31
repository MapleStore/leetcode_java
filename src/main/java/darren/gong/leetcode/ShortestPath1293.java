package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath1293 {
  public int shortestPath(int[][] grid, int k) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int maxX = grid.length;
    int maxY = grid[0].length;
    // 起始和末尾不为障碍,障碍数最多为maxX+maxY-3
    if (k >= maxX+maxY-3) {
      return maxX+maxY-2;
    }
    int[][] directions = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
    Queue<int[]> queue = new LinkedList<>();
    boolean[][][] visited = new boolean[maxX][maxY][k+1];
    queue.add(new int[]{0, 0, k});
    visited[0][0][k] = true;
    int result = 0;
    while (!queue.isEmpty()) {
      result++;
      int size = queue.size();
      while (size-- > 0) {
        int[] current = queue.poll();
        int currentX = current[0];
        int currentY = current[1];
        int rest = current[2];
        for (int[] direction : directions) {
          int nextX = currentX+direction[0];
          int nextY = currentY+direction[1];
          if (nextX == maxX-1 && nextY == maxY-1) {
            return result;
          }
          if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY) {
            if (grid[nextX][nextY] == 1 && rest > 0 && !visited[nextX][nextY][rest-1]) {
              visited[nextX][nextY][rest-1] = true;
              queue.add(new int[]{nextX, nextY, rest-1});
              continue;
            }
            if (grid[nextX][nextY] == 0 && !visited[nextX][nextY][rest]) {
              visited[nextX][nextY][rest] = true;
              queue.add(new int[]{nextX, nextY, rest});
              continue;
            }
          }
        }
      }
    }
    return -1;
  }
}
