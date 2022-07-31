package darren.gong.leetcode.interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindWhetherExistsPath_0401 {
  public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] path : graph) {
      List<Integer> to = map.computeIfAbsent(path[0], k->new LinkedList<>());
      to.add(path[1]);
    }
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;
    while (!queue.isEmpty()) {
      int current = queue.poll();
      List<Integer> to = map.get(current);
      if (to == null) {
        continue;
      }
      for (int one : to) {
        if (visited[one]) {
          continue;
        }
        if (one == target) {
          return true;
        }
        queue.add(one);
        visited[one] = true;
      }
    }
    return false;
  }
}
