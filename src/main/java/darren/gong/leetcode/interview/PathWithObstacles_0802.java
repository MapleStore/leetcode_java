package darren.gong.leetcode.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathWithObstacles_0802 {
  // [[0,0],[1,0],[2,0],[3,0],[4,0],[4,1],[3,1],[2,1],[2,2],[1,2],[0,2],[0,3],[1,3],[2,3],[3,3],[4,3]]
  // [[0,0,0,0],
  //  [0,1,0,0],
  //  [0,0,0,0],
  //  [0,0,1,0],
  //  [0,0,0,0]]
  private int[][] directions = new int[][]{{-1,0}, {0,-1}};
  private boolean[][] visited;
  private List<List<Integer>>[][] cache;
  private int maxX;
  private int maxY;
  // 面试题 08.02. 迷路的机器人
  public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
    maxX = obstacleGrid.length;
    maxY = obstacleGrid[0].length;
    if (obstacleGrid[maxX-1][maxY-1] == 1) {
      return new ArrayList<>();
    }
    cache = new List[maxX][maxY];
    visited = new boolean[maxX][maxY];
    visited[maxX-1][maxY-1] = true;
    return pathTo(obstacleGrid, maxX-1, maxY-1);
  }
  private List<List<Integer>> pathTo(int[][] obstacleGrid, int currentX, int currentY) {
    if (cache[currentX][currentY] != null) {
      return cache[currentX][currentY];
    }
    List<List<Integer>> result = new LinkedList<>();
    List<Integer> current = new LinkedList<>();
    current.add(currentX);
    current.add(currentY);
    if (currentX == 0 && currentY == 0) {
      result.add(current);
      cache[currentX][currentY] = result;
      return result;
    }


    for (int[] direction : directions) {
      int lastX = currentX+direction[0];
      int lastY = currentY+direction[1];

      if (lastX >= 0 && lastX < maxX && lastY >= 0 && lastY < maxY && obstacleGrid[lastX][lastY] != 1 && !visited[lastX][lastY]) {
        visited[lastX][lastY] = true;
        List<List<Integer>> lastResult = pathTo(obstacleGrid, lastX, lastY);
        visited[lastX][lastY] = false;
        if (!lastResult.isEmpty()) {
          result.addAll(lastResult);
          result.add(current);
          cache[currentX][currentY] = result;
          return result;
        }
      }
    }
    cache[currentX][currentY] = result;
    return result;
  }
}
