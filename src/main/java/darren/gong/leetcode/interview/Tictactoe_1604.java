package darren.gong.leetcode.interview;

public class Tictactoe_1604 {
  public String tictactoe(String[] board) {
    int length = board.length;
    int[] xLineCount = new int[length];
    int[] xColCount = new int[length];
    int[] xAcrossCount = new int[2];
    int[] oLineCount = new int[length];
    int[] oColCount = new int[length];
    int[] oAcrossCount = new int[2];
    boolean block = false;

    for (int i = 0; i < length; i++) {
      char[] chars = board[i].toCharArray();
      for (int j = 0; j < length; j++) {
        if (chars[j] == 'O') {
          oLineCount[i]++;
          oColCount[j]++;
          if (i == j) {
            oAcrossCount[0]++;
          }
          if (i == length-1-j) {
            oAcrossCount[1]++;
          }
        } else if (chars[j] == 'X') {
          xColCount[j]++;
          xLineCount[i]++;
          if (i == j) {
            xAcrossCount[0]++;
          }
          if (i == length-1-j) {
            xAcrossCount[1]++;
          }
        } else {
          block = true;
        }
      }
    }
    if (xAcrossCount[0] == length || xAcrossCount[1] == length) {
      return "X";
    }
    if (oAcrossCount[0] == length || oAcrossCount[1] == length) {
      return "O";
    }
    for (int i = 0; i < length; i++) {
      if (xLineCount[i] == length || xColCount[i] == length) {
        return "X";
      }
      if (oLineCount[i] == length || oColCount[i] == length) {
        return "O";
      }
    }
    return block ? "Pending" : "Draw";
  }
}
