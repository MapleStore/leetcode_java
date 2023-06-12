package darren.gong.leetcode;

public class MovesToChessboard_782 {
  public int movesToChessboard(int[][] board) {
    if (!valid(board)) return -1;

    int length = board.length;
    int nextVal = 1;
    int countLine = 0;
    int countCol = 0;
    for (int i = 0; i < length; i++) {
      countLine += Math.abs(nextVal-board[i][0]);
      countCol += Math.abs(nextVal-board[0][i]);
      nextVal = 1-nextVal;
    }

    if (length%2 == 0) {
      return Math.min(countLine, length-countLine)/2+Math.min(countCol, length-countCol)/2;
    } else {
      int result = countLine%2 == 0 ? countLine : length-countLine;
      result += countCol%2 == 0 ? countCol : length-countCol;
      return result>>1;
    }
  }
  private boolean valid(int[][] board) {
    int length = board.length;
    int firstLine = getVal(board[0]);
    int firstLineCount = 0;
    for (int[] line : board) {
      int val = getVal(line);
      if (val == firstLine) {
        firstLineCount++;
      } else if ((val^firstLine) != (1<<length)-1) {
        return false;
      }
    }
    if (Math.abs(firstLineCount-(length-firstLineCount)) > 1) {
      return false;
    }
    int countZero = 0;
    for (int val : board[0]) {
      countZero += 1-val;
    }
    if (Math.abs(countZero-(length-countZero)) > 1) {
      return false;
    }
    return true;
  }
  private int getVal(int[] ints) {
    int val = 0;
    for (int i = 0; i < ints.length; i++) {
      val |= ints[i]<<i;
    }
    return val;
  }
}
