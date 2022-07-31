package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders909 {
  public static void main(String[] args) {
    SnakesAndLadders909 snakesAndLadders909 = new SnakesAndLadders909();
    snakesAndLadders909.snakesAndLadders(new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}});
  }
  public int snakesAndLadders(int[][] board) {
    int length = board.length;
    int target = length*length-1;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    int result = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int index = queue.poll();
        for (int i = index+1; i <= index+6; i++) {
          if (i == target) {
            return result;
          }
          int[] nextPos = getPosition(i, length);
          int x = nextPos[0];
          int y = nextPos[1];
          if (board[x][y] == -2) {
            continue;
          }
          if (board[x][y] != -1) {
            if (board[x][y]-1 == target) {
              return result;
            }
            queue.add(board[x][y]-1);
            board[x][y] = -2;
          } else {
            queue.add(i);
            board[x][y] = -2;
          }
        }
      }
      result++;
    }
    return -1;
  }
  private int[] getPosition(int num, int length) {
    int line = num/length;
    int x = length-line-1;
    int y = line%2 == 0 ? num%length : length-1-(num%length);
    return new int[]{x, y};
  }
}
