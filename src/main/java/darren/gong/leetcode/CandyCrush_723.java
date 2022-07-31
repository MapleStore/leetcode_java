package darren.gong.leetcode;

public class CandyCrush_723 {
  // 723. 粉碎糖果
  public int[][] candyCrush(int[][] board) {
    int maxX = board.length;
    int maxY = board[0].length;
    boolean needClean = true;
    while (needClean) {
      needClean = false;
      int[][] left = new int[maxX][maxY];
      for (int i = 0; i < maxX; i++) {
        for (int j = 0; j < maxY; j++) {
          if (j == 0) {
            left[i][j] = board[i][j] == 0 ? 0 : 1;
            continue;
          }
          if (board[i][j] == 0) {
            left[i][j] = 0;
            continue;
          }
          left[i][j] = board[i][j] == board[i][j-1] ? left[i][j-1]+1 : 1;
        }
      }
      int[][] next = new int[maxX][maxY];
      for (int i = 0; i < maxX; i++) {
        for (int j = 0; j < maxY; j++) {
          next[i][j] = board[i][j];
          if (left[i][j] >= 3) {
            needClean = true;
            next[i][j] = next[i][j-1] = next[i][j-2] = 0;
          }
        }
      }

      int[][] up = new int[maxX][maxY];
      for (int i = 0; i < maxX; i++) {
        for (int j = 0; j < maxY; j++) {
          if (i == 0) {
            up[i][j] = board[i][j] == 0 ? 0 : 1;
            continue;
          }
          if (board[i][j] == 0) {
            up[i][j] = 0;
            continue;
          }
          up[i][j] = board[i][j] == board[i-1][j] ? up[i-1][j]+1 : 1;
        }
      }
      for (int i = 0; i < maxX; i++) {
        for (int j = 0; j < maxY; j++) {
          if (up[i][j] >= 3) {
            needClean = true;
            next[i][j] = next[i-1][j] = next[i-2][j] = 0;
          }
        }
      }
      clean(next);
      board = next;
    }
    return board;
  }

  private void clean(int[][] board) {
    int maxX = board.length;
    int maxY = board[0].length;
    for (int j = 0; j < maxY; j++) {
      int index = maxX-1;
      for (int i = maxX-1; i >= 0; i--) {
        if (board[i][j] != 0) {
          board[index--][j] = board[i][j];
        }
      }
      while (index >= 0) {
        board[index][j] = 0;
        index--;
      }
    }
  }
}
