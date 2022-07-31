package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LongestIncreasingPath329 {
  public static void main(String[] args) {
    LongestIncreasingPath329 longestIncreasingPath329 = new LongestIncreasingPath329();
    longestIncreasingPath329.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}});
  }
  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int maxX = matrix.length;
    int maxY = matrix[0].length;
    int[][] outCounts = new int[maxX][maxY];
    int[][] directions = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}};
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        for (int[] direction : directions) {
          int x = i+direction[0];
          int y = j+direction[1];
          if (x >= 0 && x < maxX && y >= 0 && y < maxY && matrix[x][y] > matrix[i][j]) {
            outCounts[i][j]++;
          }
        }
      }
    }

    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (outCounts[i][j] == 0) {
          queue.add(new int[]{i, j});
        }
      }
    }

    if (queue.isEmpty()) {
      return 0;
    }
    int result = 0;
    while (!queue.isEmpty()) {
      result++;
      int size = queue.size();
      while (size-- > 0) {
        int[] current = queue.poll();
        for (int[] direction : directions) {
          int nextX = current[0]+direction[0];
          int nextY = current[1]+direction[1];
          if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY && matrix[nextX][nextY] < matrix[current[0]][current[1]]) {
            outCounts[nextX][nextY]--;
            if (outCounts[nextX][nextY] == 0) {
              queue.offer(new int[]{nextX, nextY});
            }
          }
        }
      }
    }
    return result;
  }
}
