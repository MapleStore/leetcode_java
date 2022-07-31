package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueensAttacktheKing_1222 {
  public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
    boolean[][] board = new boolean[8][8];
    int length = queens.length;
    for (int i = 0; i < length; i++) {
      int[] queen = queens[i];
      board[queen[0]][queen[1]] = true;
    }
    List<List<Integer>> result = new LinkedList<>();
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    for (int[] direction : directions) {
      int step = 1;
      while (true) {
        int x = king[0]+step*direction[0];
        int y = king[1]+step*direction[1];
        if (x < 0 || x >= 8 || y < 0 || y >= 8) {
          break;
        }
        if (board[x][y]) {
          result.add(Arrays.asList(king[0] + step * direction[0], king[1] + step * direction[1]));
          break;
        }
        step++;
      }
    }
    return result;
  }
}
