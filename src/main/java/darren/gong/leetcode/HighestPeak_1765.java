package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class HighestPeak_1765 {
  public static void main(String[] args) {
    HighestPeak_1765 highestPeak_1765 = new HighestPeak_1765();
    highestPeak_1765.highestPeak(new int[][]{{0,1},{0,0}});
  }
  public int[][] highestPeak(int[][] isWater) {
    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int maxX = isWater.length;
    int maxY = isWater[0].length;
    int[][] result = new int[maxX][maxY];
    boolean[][] visited = new boolean[maxX][maxY];
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (isWater[i][j] == 1) {
          queue.add(new int[]{i, j});
          visited[i][j] = true;
        }
      }
    }
    int high = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] current = queue.poll();
        for (int[] direction : directions) {
          int[] nextPos = new int[]{current[0]+direction[0], current[1]+direction[1]};
          if (nextPos[0]>=0 && nextPos[0]<maxX && nextPos[1]>=0 && nextPos[1]<maxY && !visited[nextPos[0]][nextPos[1]]) {
            visited[nextPos[0]][nextPos[1]] = true;
            result[nextPos[0]][nextPos[1]] = high;
            queue.add(nextPos);
          }
        }
      }
      high++;
    }
    return result;
  }
}
