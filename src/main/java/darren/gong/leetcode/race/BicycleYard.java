package darren.gong.leetcode.race;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BicycleYard {
  public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
    int maxX = terrain.length;
    int maxY = terrain[0].length;
    int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    List<int[]> result = new LinkedList<>();
    // start
    boolean[][][] visited = new boolean[maxX][maxY][102];
    visited[position[0]][position[1]][1] = true;

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{position[0], position[1], 1});

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int currentX = current[0];
      int currentY = current[1];
      int currentSpeed = current[2];
      int currentHigh = terrain[current[0]][current[1]];
      for (int[] direction : directions) {
        int nextX = currentX+direction[0];
        int nextY = currentY+direction[1];
        if (nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY) {
          continue;
        }
        int nextSpeed = currentSpeed+currentHigh-terrain[nextX][nextY]-obstacle[nextX][nextY];
        if (nextSpeed <= 0 || visited[nextX][nextY][nextSpeed]) {
          continue;
        }
        if (nextSpeed == 1) {
          result.add(new int[]{nextX, nextY});
        }
        visited[nextX][nextY][nextSpeed] = true;
        queue.add(new int[]{nextX, nextY, nextSpeed});
      }
    }
    Collections.sort(result, (a,b)->{
      if (a[0] == b[0]) {
        return a[1]-b[1];
      }
      return a[0]-b[0];
    });
    int[][] realResult = new int[result.size()][];
    return result.toArray(realResult);
  }
}
