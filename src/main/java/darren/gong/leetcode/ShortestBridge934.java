package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge934 {
  // 934. 最短的桥
  public static void main(String[] args) {
    ShortestBridge934 shortestBridge934 = new ShortestBridge934();
    shortestBridge934.shortestBridge(new int[][]{{0,1},{1,0}});
  }
  private int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
  private Queue<int[]> queue = new LinkedList<>();
  private int maxX;
  private int maxY;
  public int shortestBridge(int[][] A) {
    findOneIsland(A);
    int result = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] current = queue.poll();
        for (int[] direction : directions) {
          int nextX = current[0]+direction[0];
          int nextY = current[1]+direction[1];
          if (nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY || A[nextX][nextY] == -1) {
            continue;
          }
          if (A[nextX][nextY] == 1) {
            return result;
          }
          queue.add(new int[]{nextX, nextY});
          A[nextX][nextY] = -1;
        }
      }
      result++;
    }
    return -1;
  }
  private void findOneIsland(int[][] A) {
    maxX = A.length;
    maxY = A[0].length;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (A[i][j] == 1) {
          dfs(A, i, j);
          return;
        }
      }
    }
  }
  private void dfs(int[][] A, int x, int y) {
    queue.add(new int[]{x, y});
    A[x][y] = -1;

    for (int[] direction : directions) {
      int nextX = x+direction[0];
      int nextY = y+direction[1];
      if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY && A[nextX][nextY] == 1) {
        dfs(A, nextX, nextY);
      }
    }
  }
}
