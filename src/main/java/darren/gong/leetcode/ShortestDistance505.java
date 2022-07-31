package darren.gong.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance505 {
  public static void main(String[] args) {
    ShortestDistance505 shortestDistance505 = new ShortestDistance505();
    shortestDistance505.shortestDistance(new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}},
    new int[]{0,4},
    new int[]{4,4});
  }
  private static int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
  public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    if (start[0] == destination[0] && start[1] == destination[1]) {
      return 0;
    }
    int maxX = maze.length;
    int maxY = maze[0].length;
    int[][] visited = new int[maxX][maxY];
    for (int i = 0; i < maxX; i++) Arrays.fill(visited[i], Integer.MAX_VALUE);

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{start[0], start[1], 0});
    visited[start[0]][start[1]] = 0;
    int result = Integer.MAX_VALUE;

    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] current = queue.poll();
        for (int[] direction : directions) {
          int[] next = new int[]{current[0], current[1], current[2]};
          int dis = 0;
          int tempX = current[0];
          int tempY = current[1];
          while ((tempX = tempX+direction[0]) >= 0 && (tempX < maxX) &&
              (tempY = tempY+direction[1]) >= 0 && (tempY < maxY) &&
              maze[tempX][tempY] != 1) {
            next[0] = tempX;
            next[1] = tempY;
            dis++;
          }
          next[2] = current[2]+dis;
          if (visited[next[0]][next[1]] <= next[2]) {
            continue;
          }
          if (next[0] == destination[0] && next[1] == destination[1]) {
            result = Math.min(result, next[2]);
            continue;
          }
          visited[next[0]][next[1]] = next[2];
          queue.add(next);
        }
      }
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
