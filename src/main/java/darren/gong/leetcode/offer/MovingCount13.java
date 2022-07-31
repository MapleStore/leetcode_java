package darren.gong.leetcode.offer;

import java.util.LinkedList;
import java.util.Queue;

public class MovingCount13 {
  public int movingCount(int m, int n, int k) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0});
    int result = 1;
    int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    boolean[][] visited = new boolean[m][n];
    visited[0][0] = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] current = queue.poll();
        for (int[] direction : directions) {
          int nextX = current[0]+direction[0];
          int nextY = current[1]+direction[1];
          if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited[nextX][nextY]) {
            continue;
          }
          if (count(nextX)+count(nextY) > k) {
            continue;
          }
          visited[nextX][nextY] = true;
          queue.add(new int[]{nextX, nextY});
          result++;
        }
      }
    }
    return result;
  }
  private int count(int num) {
    int result = 0;
    while (num > 0) {
      result += num%10;
      num /= 10;
    }
    return result;
  }
}
