package darren.gong.leetcode;

import java.util.PriorityQueue;

public class TrapRainWater407 {
  public static void main(String[] args) {
    TrapRainWater407 trapRainWater407 = new TrapRainWater407();
    trapRainWater407.trapRainWater(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}});
  }
  public int trapRainWater(int[][] heightMap) {
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[2]-b[2]);
    int maxX = heightMap.length-1;
    int maxY = heightMap[0].length-1;
    if (maxX < 2 || maxY < 2) {
      return 0;
    }
    boolean[][] visited = new boolean[maxX+1][maxY+1];
    for (int i = 0; i <= maxX; i++) {
      priorityQueue.add(new int[]{i, 0, heightMap[i][0]});
      visited[i][0] = true;
      priorityQueue.add(new int[]{i, maxY, heightMap[i][maxY]});
      visited[i][maxY] = true;
    }
    for (int j = 1; j < maxY; j++) {
      priorityQueue.add(new int[]{0, j, heightMap[0][j]});
      visited[0][j] = true;
      priorityQueue.add(new int[]{maxX, j, heightMap[maxX][j]});
      visited[maxX][j] = true;
    }
    int result = 0;
    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    while (!priorityQueue.isEmpty()) {
      int[] current = priorityQueue.poll();
      for (int[] direction : directions) {
        int nextX = current[0]+direction[0];
        int nextY = current[1]+direction[1];
        if (nextX >= 0 && nextX <= maxX && nextY >= 0 && nextY <= maxY && !visited[nextX][nextY]) {
          if (heightMap[nextX][nextY] < current[2]) {
            result += current[2]-heightMap[nextX][nextY];
            priorityQueue.add(new int[]{nextX, nextY, current[2]});
          } else {
            priorityQueue.add(new int[]{nextX, nextY, heightMap[nextX][nextY]});
          }
          visited[nextX][nextY] = true;
        }
      }
    }
    return result;
  }
}
