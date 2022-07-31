package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateBoard529 {
  /*
    如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
    如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
    如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
    如果在此次点击中，若无更多方块可被揭露，则返回面板。
   */
  public char[][] updateBoard(char[][] board, int[] click) {
    int[][] directions = new int[][]{{1,0},{-1,0},{1,1},{1,-1},{0,1},{0,-1},{-1,1},{-1,-1}};
    int maxX = board.length;
    int maxY = board[0].length;
    Queue<int[]> queue = new LinkedList<>();
    if (board[click[0]][click[1]] == 'M') {
      board[click[0]][click[1]] = 'X';
      return board;
    }
    queue.add(click);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] current = queue.poll();
        int currentX = current[0];
        int currentY = current[1];
        int mNum = 0;
        for (int[] direction : directions) {
          int nextX = currentX+direction[0];
          int nextY = currentY+direction[1];
          if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY && board[nextX][nextY] == 'M') {
            mNum++;
          }
        }
        if (mNum == 0 && board[currentX][currentY] == 'E') {
          board[currentX][currentY] = 'B';
          for (int[] direction : directions) {
            int nextX = currentX+direction[0];
            int nextY = currentY+direction[1];
            if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY) {
              queue.add(new int[]{nextX, nextY});
            }
          }
        } else if (board[currentX][currentY] == 'E') {
          board[currentX][currentY] = (char)('0'+mNum);
        }
      }
    }
    return board;
  }
}
