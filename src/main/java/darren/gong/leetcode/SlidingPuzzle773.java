package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle773 {
  public static void main(String[] args) {
    SlidingPuzzle773 slidingPuzzle773 = new SlidingPuzzle773();
    slidingPuzzle773.slidingPuzzle(new int[][]{{1,2,3},{4,0,5}});
  }
  private static class Entry {
    int[][] board;
    int x;
    int y;
    private Entry(int[][] board, int x, int y) {
      this.board = board;
      this.x = x;
      this.y = y;
    }
  }
  private Set<Integer> visited = new HashSet<>();
  private int[][] directions = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
  public int slidingPuzzle(int[][] board) {
    int x = -1;
    int y = -1;
    for (int i = 0; i < 2 && x == -1; i++) {
      for (int j = 0; j < 3 && x == -1; j++) {
        if (board[i][j] == 0) {
          x = i;
          y = j;
        }
      }
    }
    if (isTarget(board)) {
      return 0;
    }
    Queue<Entry> queue = new LinkedList<>();
    queue.add(new Entry(board, x, y));
    int move = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        Entry current = queue.poll();
        for (int[] direction : directions) {
          Entry next = getNextEntry(current, direction);
          if (next == null) {
            continue;
          }
          if (isTarget(next.board)) {
            return move;
          }
          if (visited(next)) {
            continue;
          }
          queue.add(next);
        }
      }
      move++;
    }
    return -1;
  }

  private Entry getNextEntry(Entry current, int[] direction) {
    int nextX = current.x+direction[0];
    int nextY = current.y+direction[1];
    if (nextX < 0 || nextX >= 2 || nextY < 0 || nextY >= 3) {
      return null;
    }
    int[][] nextBoard = new int[2][3];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        nextBoard[i][j] = current.board[i][j];
      }
    }
    int temp = nextBoard[nextX][nextY];
    nextBoard[nextX][nextY] = 0;
    nextBoard[current.x][current.y] = temp;
    Entry nextEntry = new Entry(nextBoard, nextX, nextY);
    return nextEntry;
  }
  private boolean visited(Entry current) {
    int hash = 0;
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        hash = hash*10+current.board[i][j];
      }
    }
    if (visited.contains(hash)) {
      return true;
    }
    visited.add(hash);
    return false;
  }
  private boolean isTarget(int[][] board) {
    int x = 0;
    int y = 0;
    int value = 1;
    while (value <= 5) {
      if (board[x][y] != value) {
        return false;
      }
      value++;

      y++;
      if (y > 2) {
        x++;
        y = 0;
      }
    }
    return true;
  }
}
