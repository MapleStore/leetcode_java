package darren.gong.leetcode;

public class Largest1BorderedSquare_1139 {
  // 1139. 最大的以 1 为边界的正方形
  // [[1,1,1,1,1,1],
  //  [1,0,1,0,1,1],
  //  [1,1,1,0,1,1],
  //  [1,1,1,1,1,1],
  //  [1,1,1,1,1,0]]
  public static void main(String[] args) {
    Largest1BorderedSquare_1139 largest1BorderedSquare_1139 = new Largest1BorderedSquare_1139();
    largest1BorderedSquare_1139.largest1BorderedSquare(new int[][]{{1,1,1,1,1,1},{1,0,1,0,1,1},{1,1,1,0,1,1},{1,1,1,1,1,1},{1,1,1,1,1,0}});
  }
  public int largest1BorderedSquare(int[][] grid) {
    int maxX = grid.length;
    int maxY = grid[0].length;
    int[][] xDp = new int[maxX][maxY];
    int[][] yDp = new int[maxX][maxY];

    for (int i = 0; i < maxX; i++) {
      for (int j = maxY-1; j >= 0; j--) {
        if (j == maxY-1) {
          xDp[i][j] = grid[i][j];
          continue;
        }
        xDp[i][j] = grid[i][j] == 0 ? 0 : xDp[i][j+1]+1;
      }
    }

    for (int j = 0; j < maxY; j++) {
      for (int i = maxX-1; i >= 0; i--) {
        if (i == maxX-1) {
          yDp[i][j] = grid[i][j];
          continue;
        }
        yDp[i][j] = grid[i][j] == 0 ? 0 : yDp[i+1][j]+1;
      }
    }

    int max = 0;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        int current = xDp[i][j];
        while (current > max) {
          if (i+current-1 >= maxX || i+current-1 < 0 || j+current-1 >= maxY || j+current-1 < 0) {
            current--;
            continue;
          }
          if (xDp[i+current-1][j] >= current && yDp[i][j] >= current && yDp[i][j+current-1] >= current) {
            max = current;
          }
          current--;
        }
      }
    }
    return max*max;
  }
}
