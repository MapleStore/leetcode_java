package darren.gong.leetcode;

public class Tictactoe1275 {
  public String tictactoe(int[][] moves) {
    int[][] xNum = new int[2][3];
    int[][] yNum = new int[2][3];
    // 2 people each 2 line
    int[][] acrossNum = new int[2][2];
    int people = 0;
    for (int[] move : moves) {
      int x = move[0];
      int y = move[1];
      if (++xNum[people][x] == 3) {
        return people == 0 ? "A" : "B";
      }
      if (++yNum[people][y] == 3) {
        return people == 0 ? "A" : "B";
      }
      if (x == y && ++acrossNum[people][0] == 3) {
        return people == 0 ? "A" : "B";
      }
      if (2-x == y && ++acrossNum[people][1] == 3) {
        return people == 0 ? "A" : "B";
      }
      people = 1-people;
    }
    if (moves.length == 9) {
      return "Draw";
    }
    return "Pending";
  }
}
