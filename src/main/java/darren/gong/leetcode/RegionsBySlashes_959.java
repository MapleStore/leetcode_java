package darren.gong.leetcode;

public class RegionsBySlashes_959 {
  // 959. 由斜杠划分区域
  private int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
  private int length;
  public int regionsBySlashes(String[] grid) {
    length = 3*grid.length;
    int[][] newGrid = getNewGrid(grid);
    int result = 0;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if (newGrid[i][j] == 0) {
          result++;
          dfs(newGrid, i, j);
        }
      }
    }
    return result;
  }

  private void dfs(int[][] grid, int x, int y) {
    grid[x][y] = 1;
    for (int[] direction : directions) {
      int nextX = x+direction[0];
      int nextY = y+direction[1];
      if (nextX >= 0 && nextX < length && nextY >= 0 && nextY < length && grid[nextX][nextY] == 0) {
        dfs(grid, nextX, nextY);
      }
    }
  }

  private int[][] getNewGrid(String[] grid) {
    int length = 3*grid.length;
    int[][] newGrid = new int[length][length];
    for (int i = 0; i < grid.length; i++) {
      int fillX = 3*i;
      for (int j = 0; j < grid[i].length(); j++) {
        int fillY = 3*j;
        char current = grid[i].charAt(j);
        if (current == '/') {
          newGrid[fillX][fillY+2] = 1;
          newGrid[fillX+1][fillY+1] = 1;
          newGrid[fillX+2][fillY] = 1;
        } else if (current == '\\') {
          newGrid[fillX][fillY] = 1;
          newGrid[fillX+1][fillY+1] = 1;
          newGrid[fillX+2][fillY+2] = 1;
        }
      }
    }
    return newGrid;
  }
}
