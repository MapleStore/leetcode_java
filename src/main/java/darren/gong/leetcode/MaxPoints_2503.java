package darren.gong.leetcode;

import java.util.PriorityQueue;

public class MaxPoints_2503 {
  public static void main(String[] args) {
    MaxPoints_2503 maxPoints_2503 = new MaxPoints_2503();
    maxPoints_2503.maxPoints(new int[][]{{1,2,3},{2,5,7},{3,5,1}}, new int[]{5,6,2});
  }
  public int[] maxPoints(int[][] grid, int[] queries) {
    int maxX = grid.length;
    int maxY = grid[0].length;
    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int[] vals = new int[maxX*maxY];
    int[] parents = new int[maxX*maxY];
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[1]-b[1]);
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        int index = i*maxY+j;
        vals[index] = 1;
        parents[index] = index;
        priorityQueue.add(new int[]{index, grid[i][j]});
      }
    }
    PriorityQueue<int[]> queryQueue = new PriorityQueue<>((a,b)->a[1]-b[1]);
    for (int i = 0; i < queries.length; i++) {
      queryQueue.add(new int[]{i, queries[i]});
    }
    int[] results = new int[queries.length];
    while (!queryQueue.isEmpty()) {
      int[] query = queryQueue.poll();
      while (!priorityQueue.isEmpty() && priorityQueue.peek()[1] < query[1]) {
        int index = priorityQueue.poll()[0];
        int x = index/maxY;
        int y = index%maxY;
        for (int[] direction : directions) {
          int nextX = x+direction[0];
          int nextY = y+direction[1];
          if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY && grid[nextX][nextY] < query[1]) {
            merge(nextX*maxY+nextY, index, parents, vals);
          }
        }
      }
      results[query[0]] = grid[0][0] < query[1] ? vals[getParent(0, parents)] : 0;
    }
    return results;
  }
  private int getParent(int child, int[] parents) {
    if (parents[child] == child) {
      return child;
    }
    parents[child] = getParent(parents[child], parents);
    return parents[child];
  }
  private void merge(int one, int two, int[] parents, int[] vals) {
    if (getParent(one, parents) == getParent(two, parents)) {
      return;
    }
    vals[getParent(two, parents)] += vals[getParent(one, parents)];
    parents[getParent(one, parents)] = parents[getParent(two, parents)];
  }
}
