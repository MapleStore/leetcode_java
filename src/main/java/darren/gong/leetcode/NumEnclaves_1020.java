package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumEnclaves_1020 {
  public static void main(String[] args) {
    NumEnclaves_1020 numEnclaves_1020 = new NumEnclaves_1020();
    numEnclaves_1020.numEnclaves(new int[][]{{0,1,1,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}});
  }
  public int numEnclaves(int[][] grid) {
    int maxX = grid.length;
    int maxY = grid[0].length;

    boolean[][] visited = new boolean[maxX][maxY];
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (!(i == 0 || j == 0 || i == maxX-1 || j == maxY-1)) {
          continue;
        }
        if (grid[i][j] == 0 || visited[i][j]) {
          continue;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
          int[] current = queue.poll();
          for (int[] direction : directions) {
            int nextX = current[0] + direction[0];
            int nextY = current[1] + direction[1];
            if (nextX >= maxX || nextX < 0 || nextY < 0 || nextY >= maxY || visited[nextX][nextY]) {
              continue;
            }
            if (grid[nextX][nextY] == 0) {
              continue;
            }
            queue.add(new int[]{nextX, nextY});
            visited[nextX][nextY] = true;
          }
        }
      }
    }
    int result = 0;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          result++;
        }
      }
    }
    return result;
  }
}
