package darren.gong.leetcode;

public class NumMagicSquaresInside_840 {
  public static void main(String[] args) {
    NumMagicSquaresInside_840 numMagicSquaresInside_840 = new NumMagicSquaresInside_840();
    numMagicSquaresInside_840.numMagicSquaresInside(new int[][]
        {   {3,2,9,2,7},
            {6,1,8,4,2},
            {7,5,3,2,7},
            {2,9,4,9,6},
            {4,3,8,2,5}   });
  }
  public int numMagicSquaresInside(int[][] grid) {
    int maxX = grid.length;
    int maxY = grid[0].length;
    int result = 0;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (isValid(i, j, grid)) {
          result++;
        }
      }
    }
    return result;
  }
  private boolean isValid(int startX, int startY, int[][] grid) {
    if (startX < 0 || startX+3 > grid.length) {
      return false;
    }
    if (startY < 0 || startY+3 > grid[0].length) {
      return false;
    }
    if (grid[startX+1][startY+1] != 5) {
      return false;
    }
    boolean[] visited = new boolean[10];
    int[] line = new int[3];
    int[] col = new int[3];
    int down = 0;
    int up = 0;
    for (int i = 0; i < 3; i++) {
      int x = i+startX;
      for (int j = 0; j < 3; j++) {
        int y = j+startY;
        int val = grid[x][y];
        if (val < 1 || val > 9 || visited[val]) {
          return false;
        }
        visited[val] = true;
        line[i] += val;
        col[j] += val;
        if (i == j) {
          down += val;
        }
        if (i == 2-j) {
          up += val;
        }
      }
    }
    for (int i = 0; i < 3; i++) {
      if (line[i] != 15 || col[i] != 15) {
        return false;
      }
    }
    return down == 15 && up == 15;
  }
}
