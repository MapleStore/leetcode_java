package darren.gong.leetcode;

public class UniquePathsIII_980 {
  public static void main(String[] args) {
    UniquePathsIII_980 uniquePathsIII_980 = new UniquePathsIII_980();
    uniquePathsIII_980.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}});
  }
  private int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
  private int result = 0;
  private int maxX;
  private int maxY;
  public int uniquePathsIII(int[][] grid) {
    int needCount = 0;
    maxX = grid.length;
    maxY = grid[0].length;
    int[] start = null;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (grid[i][j] == 0) {
          needCount++;
        }
        if (grid[i][j] == 1) {
          start = new int[]{i, j};
        }
      }
    }
    boolean[][] visited = new boolean[maxX][maxY];
    visited[start[0]][start[1]] = true;
    dfs(start, grid, visited, needCount);
    return result;
  }
  private void dfs(int[] current, int[][] grid, boolean[][] visited, int needCount) {
    if (grid[current[0]][current[1]] == 2 && needCount == -1) {
      result++;
      return;
    }
    if (grid[current[0]][current[1]] == 2) {
      return;
    }
    for (int[] direction : directions) {
      int nextX = current[0]+direction[0];
      int nextY = current[1]+direction[1];
      if (nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY || visited[nextX][nextY] || grid[nextX][nextY] == -1) {
        continue;
      }
      visited[nextX][nextY] = true;
      dfs(new int[]{nextX, nextY}, grid, visited, needCount-1);
      visited[nextX][nextY] = false;
    }
  }
}
