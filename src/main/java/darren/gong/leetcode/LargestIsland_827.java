package darren.gong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestIsland_827 {
  private int[][] directions = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
  private int maxX;
  private int maxY;
  public int largestIsland(int[][] grid) {
    maxX = grid.length;
    maxY = grid[0].length;
    int islandNum = 2;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (grid[i][j] != 1) {
          continue;
        }
        int result = dfs(grid, i, j, islandNum);
        map.put(islandNum, result);
        islandNum++;
      }
    }
    int result = 0;
    for (int currentX = 0; currentX < maxX; currentX++) {
      for (int currentY = 0; currentY < maxY; currentY++) {
        if (grid[currentX][currentY] != 0) {
          continue;
        }
        int currentResult = 1;
        Set<Integer> visited = new HashSet<>();
        for (int[] direction : directions) {
          int nextX = currentX+direction[0];
          int nextY = currentY+direction[1];
          if (nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY) {
            continue;
          }
          int island = grid[nextX][nextY];
          if (!visited.contains(island)) {
            currentResult += map.getOrDefault(island, 0);
            visited.add(island);
          }
        }
        result = Math.max(result, currentResult);
      }
    }
    return result == 0 ? maxY*maxY : result;
  }
  private int dfs(int[][] grid, int currentX, int currentY, int index) {
    grid[currentX][currentY] = index;
    int result = 1;
    for (int[] direction : directions) {
      int nextX = currentX+direction[0];
      int nextY = currentY+direction[1];
      if (nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY || grid[nextX][nextY] != 1) {
        continue;
      }
      result += dfs(grid, nextX, nextY, index);
    }
    return result;
  }
}
