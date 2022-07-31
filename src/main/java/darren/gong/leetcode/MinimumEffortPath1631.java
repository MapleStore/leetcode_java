package darren.gong.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumEffortPath1631 {
  // 1631. 最小体力消耗路径
  public int minimumEffortPath(int[][] heights) {
    int maxX = heights.length;
    int maxY = heights[0].length;
    int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    int[][] min = new int[maxX][maxY];
    for (int i = 0; i < maxX; i++) {
      Arrays.fill(min[i], Integer.MAX_VALUE);
    }
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0});
    min[0][0] = 0;
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int currentX = current[0];
      int currentY = current[1];
      for (int[] direction : directions) {
        int nextX = current[0]+direction[0];
        int nextY = current[1]+direction[1];
        if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY &&
            Math.max(min[currentX][currentY], Math.abs(heights[currentX][currentY]-heights[nextX][nextY])) < min[nextX][nextY]) {
          min[nextX][nextY] = Math.max(min[currentX][currentY], Math.abs(heights[currentX][currentY]-heights[nextX][nextY]));
          queue.add(new int[]{nextX, nextY});
        }
      }
    }
    return min[maxX-1][maxY-1];
  }
}
