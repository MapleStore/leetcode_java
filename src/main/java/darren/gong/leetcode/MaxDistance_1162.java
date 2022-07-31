package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDistance_1162 {
  private int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
  public int maxDistance(int[][] grid) {
    Queue<int[]> queue = new LinkedList<>();
    int maxX = grid.length;
    int maxY = grid[0].length;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (grid[i][j] == 1) {
          queue.add(new int[]{i, j});
        }
      }
    }
    if (queue.isEmpty()) {
      return -1;
    }
    int distance = -1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] current = queue.poll();
        for (int[] direction : directions) {
          int nextX = current[0]+direction[0];
          int nextY = current[1]+direction[1];
          if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY && grid[nextX][nextY] == 0) {
            grid[nextX][nextY] = 1;
            queue.add(new int[]{nextX, nextY});
          }
        }
      }
      distance++;
    }
    return distance == 0 ? -1 : distance;
  }
}
