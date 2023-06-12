package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SwimInWater_778 {
  private int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
  private int maxX;
  private int maxY;
  private int[][] grid;
  public int swimInWater(int[][] grid) {
    maxX = grid.length;
    maxY = grid[0].length;
    this.grid = grid;
    int left = 0;
    int right = 0;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        right = Math.max(right, grid[i][j]);
      }
    }
    while (left < right) {
      int mid = (left+right)>>1;
      if (checkValid(mid)) {
        right = mid;
      } else {
        left = mid+1;
      }
    }
    return right;
  }
  private boolean checkValid(int time) {
    if (time < grid[0][0]) {
      return false;
    }
    boolean[][] visited = new boolean[maxX][maxY];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0,0});
    visited[0][0] = true;
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      for (int[] direction : directions) {
        int nextX = current[0]+direction[0];
        int nextY = current[1]+direction[1];
        if (nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY || visited[nextX][nextY]) {
          continue;
        }
        visited[nextX][nextY] = true;
        if (grid[nextX][nextY] > time) {
          continue;
        }
        if (nextX == maxX-1 && nextY == maxY-1) {
          return true;
        }
        queue.add(new int[]{nextX, nextY});
      }
    }
    return false;
  }
}
