package darren.gong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class IsEscapePossible_1036 {
  private int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
  public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
    return canOut(blocked, source, target) && canOut(blocked, target, source);
  }
  private boolean canOut(int[][] blocked, int[] source, int[] target) {
    Map<Integer, Set<Integer>> visited = new HashMap<>();
    for (int[] oneBlocked : blocked) {
      visited.computeIfAbsent(oneBlocked[0], k->new HashSet<>()).add(oneBlocked[1]);
    }

    Queue<int[]> queue = new LinkedList<>();
    queue.add(target);
    visited.computeIfAbsent(target[0], k->new HashSet<>()).add(target[1]);
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      for (int[] direction : directions) {
        int nextX = current[0]+direction[0];
        int nextY = current[1]+direction[1];
        if (nextX < 0 || nextY < 0 || nextX >= 1000000 || nextY >= 1000000 || visited.getOrDefault(nextX, new HashSet<>()).contains(nextY)) {
          continue;
        }
        if ((nextX == source[0] && nextY == source[1]) || (Math.abs(nextX-target[0]) > 200 || Math.abs(nextY-target[1]) > 200)) {
          return true;
        }
        queue.add(new int[]{nextX, nextY});
        visited.computeIfAbsent(nextX, k->new HashSet<>()).add(nextY);
      }
    }
    return false;
  }
}
