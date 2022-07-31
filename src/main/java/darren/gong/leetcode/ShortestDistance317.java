package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance317 {
  public static void main(String[] args) {
    ShortestDistance317 shortestDistance317 = new ShortestDistance317();
    shortestDistance317.shortestDistance(new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}});
  }
  public int shortestDistance(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return -1;
    }
    int maxX = grid.length;
    int maxY = grid[0].length;
    int[][] sum = new int[maxX][maxY];
    int[][] reachNum = new int[maxX][maxY];
    int buildingNum = 0;
    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (grid[i][j] != 1) {
          continue;
        }
        buildingNum++;
        boolean[][] visited = new boolean[maxX][maxY];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int length = 0;
        while (!queue.isEmpty()) {
          length++;
          int size = queue.size();
          while (size-- > 0) {
            int[] current = queue.poll();
            for (int[] direction : directions) {
              int nextX = current[0]+direction[0];
              int nextY = current[1]+direction[1];
              if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                reachNum[nextX][nextY]++;
                sum[nextX][nextY] += length;
                visited[nextX][nextY] = true;
                queue.offer(new int[]{nextX, nextY});
              }
            }
          }
        }
      }
    }
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (reachNum[i][j] == buildingNum) {
          result = Math.min(result, sum[i][j]);
        }
      }
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
