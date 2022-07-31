package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class OpenLock752 {
  public static void main(String[] args) {
    OpenLock752 openLock752 = new OpenLock752();
    openLock752.openLock(new String[]{}, "8888");
  }
  private static int[] indexToValue = new int[]{0,1,2,3,4,5,6,7,8,9};
  public int openLock(String[] deadends, String target) {
    if (target == null || target.length() < 4) {
      return -1;
    }
    int[][] directions = new int[][]{{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1},{-1,0,0,0},{0,-1,0,0},{0,0,-1,0},{0,0,0,-1}};
    int targetValue = Integer.parseInt(target);
    if (targetValue == 0) {
      return 0;
    }

    boolean[] visited = new boolean[10000];
    for (String dead : deadends) {
      visited[Integer.parseInt(dead)] = true;
    }

    int result = 1;
    Queue<int[]> queue = new LinkedList<>();
    if (!visited[0]) {
      queue.add(new int[]{0,0,0,0});
    }
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] currentIndex = queue.poll();
        for (int[] direction : directions) {
          int[] nextIndex = getNextIndex(currentIndex, direction);
          int nextValue = indexToValue(nextIndex);
          if (nextValue == targetValue) {
            return result;
          }
          if (!visited[nextValue]) {
            queue.add(nextIndex);
            visited[nextValue] = true;
          }
        }
      }
      result++;
    }
    return -1;
  }

  private int indexToValue(int[] index) {
    int value = 0;
    for (int i = 0; i < 4; i++) {
      value = value*10 + indexToValue[index[i]];
    }
    return value;
  }
  private int[] getNextIndex(int[] index, int[] direction) {
    int[] nextIndex = new int[]{0,0,0,0};
    for (int i = 0; i < 4; i++) {
      nextIndex[i] = (10+index[i]+direction[i])%10;
    }
    return nextIndex;
  }

}
