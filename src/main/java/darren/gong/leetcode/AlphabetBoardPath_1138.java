package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class AlphabetBoardPath_1138 {
  public static void main(String[] args) {
    AlphabetBoardPath_1138 alphabetBoardPath_1138 = new AlphabetBoardPath_1138();
    alphabetBoardPath_1138.alphabetBoardPath("code");
  }
  private static class Node {
    String sb;
    int[] position;
    public Node(String sb, int[] position) {
      this.sb = sb;
      this.position = position;
    }
  }
  private char[][] graph = new char[6][5];
  private int[][] directions = new int[][]{{0,1,'R'},{0,-1,'L'},{1,0,'D'},{-1,0,'U'}};
  public String alphabetBoardPath(String target) {
    for (int i = 0; i < 26; i++) {
      int x = i/5;
      int y = i%5;
      graph[x][y] = (char)('a'+i);
    }
    String[][] map = new String[26][26];
    for (int i = 0; i < 26; i++) {
      map[i][i] = "!";
      int x = i/5;
      int y = i%5;
      Queue<Node> queue = new LinkedList<>();
      boolean[] visited = new boolean[26];
      queue.add(new Node("", new int[]{x, y}));
      visited[i] = true;
      while (!queue.isEmpty()) {
        Node current = queue.poll();
        int currentX = current.position[0];
        int currentY = current.position[1];

        for (int[] direction : directions) {
          int nextX = currentX+direction[0];
          int nextY = currentY+direction[1];
          int nextIndex = nextX*5+nextY;
          if (nextX < 0 || nextX >= 6 || nextY < 0 || nextY >= 5 || nextIndex < 0 || nextIndex >= 26 || visited[nextIndex]) {
            continue;
          }
          visited[nextIndex] = true;
          String nextSb = current.sb+(char)direction[2];
          map[i][nextIndex] = nextSb+"!";
          Node nextNode = new Node(nextSb, new int[]{nextX, nextY});
          queue.add(nextNode);
        }
      }
    }
    target = "a"+target;
    StringBuilder result = new StringBuilder();
    for (int i = 1; i < target.length(); i++) {
      result.append(map[target.charAt(i-1)-'a'][target.charAt(i)-'a']);
    }
    return result.toString();
  }
}
