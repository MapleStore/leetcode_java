package darren.gong.leetcode.race;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CanMouseWin {
  public static void main(String[] args) {
    CanMouseWin canMouseWin = new CanMouseWin();
    canMouseWin.canMouseWin(new String[]{
        "........",
        "F...#C.M",
        "........"}, 1 , 3);
  }
  private static class Position {
    boolean isCat;
    int x;
    int y;
    Position(boolean isCat, int x, int y) {
      this.isCat = isCat;
      this.x = x;
      this.y = y;
    }
  }
  private int[][] directions = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
  private int lineNum;
  private int maxY;
  private char[][] graph;
  public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
    lineNum = grid.length;
    graph = new char[lineNum][];
    for (int i = 0; i < lineNum; i++) {
      graph[i] = grid[i].toCharArray();
    }
    maxY = graph[0].length;
    boolean[][] catVisited = new boolean[lineNum][maxY];
    boolean[][] mouseVisited = new boolean[lineNum][maxY];

    Queue<Position> queue = new LinkedList<>();
    int[] food = new int[2];
    int[] cat = new int[2];
    int[] mouse = new int[2];
    for (int i = 0; i < lineNum; i++) {
      for (int j = 0; j < maxY; j++) {
        if (graph[i][j] == 'C') {
          cat = new int[]{i, j};
        } else if (graph[i][j] == 'M') {
          mouse = new int[]{i, j};
        } else if (graph[i][j] == 'F') {
          food = new int[]{i, j};
        }
      }
    }

    if (cat[0] == mouse[0] && cat[1] == mouse[1]) {
      return true;
    } else if (cat[0] == food[0] && cat[1] == food[1]) {
      return true;
    } else if (mouse[0] == food[0] && mouse[1] == food[1]){
      return false;
    }

    Set<Integer> catCurVisited = new HashSet<>();
    catCurVisited.add(cat[0]*10000+cat[1]);
    addNextVisited(catCurVisited, cat[0], cat[1], catJump);
    queue.add(new Position(false, mouse[0], mouse[1]));
    queue.add(new Position(true, cat[0], cat[1]));
    boolean init = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        Position position = queue.poll();
        for (int[] direction : directions) {
          if (position.isCat) {
            if (init) {
              catCurVisited = new HashSet<>();
              init = false;
            }
            for (int nowJump = 1; nowJump <= catJump; nowJump++) {
              int nextX = position.x+direction[0]*nowJump;
              int nextY = position.y+direction[1]*nowJump;
              if (nextX >= 0 && nextX < lineNum && nextY >= 0 && nextY < maxY && graph[nextX][nextY] == '#') {
                break;
              }
              if (nextX == food[0] && nextY == food[1]) {
                return false;
              }
              if (nextX >= 0 && nextX < lineNum && nextY >= 0 && nextY < maxY && !catVisited[nextX][nextY]) {
                catVisited[nextX][nextY] = true;

                catCurVisited.add(nextX*10000+nextY);
                addNextVisited(catCurVisited, nextX, nextY, catJump);

                queue.add(new Position(true, nextX, nextY));
              }
            }
          } else {
            init = true;
            if (!catCurVisited.contains(position.x*10000+position.y)) {
              queue.add(position);
            }

            for (int nowJump = 1; nowJump <= mouseJump; nowJump++) {
              int nextX = position.x+direction[0]*nowJump;
              int nextY = position.y+direction[1]*nowJump;
              if (nextX >= 0 && nextX < lineNum && nextY >= 0 && nextY < maxY && graph[nextX][nextY] == '#') {
                break;
              }
              if (nextX == food[0] && nextY == food[1]) {
                return true;
              }
              if (catCurVisited.contains(nextX*10000+nextY)) {
                continue;
              }
              if (nextX >= 0 && nextX < lineNum && nextY >= 0 && nextY < maxY && !mouseVisited[nextX][nextY]) {
                mouseVisited[nextX][nextY] = true;
                queue.add(new Position(false, nextX, nextY));
              }
            }
          }
        }
      }
    }
    return false;
  }

  private void addNextVisited(Set<Integer> catVisited, int currentX, int currentY, int catJump) {
    for (int[] direction : directions) {
      for (int nowJump = 1; nowJump <= catJump; nowJump++) {
        int nextX = currentX+direction[0]*nowJump;
        int nextY = currentY+direction[1]*nowJump;
        if (nextX >= 0 && nextX < lineNum && nextY >= 0 && nextY < maxY && graph[nextX][nextY] == '#') {
          break;
        }
        if (nextX >= 0 && nextX < lineNum && nextY >= 0 && nextY < maxY && graph[nextX][nextY] != '#') {
          catVisited.add(nextX*10000+nextY);
        }
      }
    }
  }
}
