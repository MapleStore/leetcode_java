package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinReorder1466 {
  public int minReorder(int n, int[][] connections) {
    Map<Integer, List<Integer>> from = new HashMap<>();
    Map<Integer, List<Integer>> to = new HashMap<>();
    for (int[] connection : connections) {
      from.putIfAbsent(connection[1], new ArrayList<>());
      from.get(connection[1]).add(connection[0]);

      to.putIfAbsent(connection[0], new ArrayList<>());
      to.get(connection[0]).add(connection[1]);
    }

    int result = 0;
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    visited[0] = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int current = queue.poll();
        for (int fromInteger : from.getOrDefault(current, new ArrayList<>())) {
          if (!visited[fromInteger]) {
            queue.add(fromInteger);
            visited[fromInteger] = true;
          }
        }
        for (int toInteger : to.getOrDefault(current, new ArrayList<>())) {
          if (!visited[toInteger]) {
            result++;
            queue.add(toInteger);
            visited[toInteger] = true;
          }
        }
      }
    }
    return result;
  }
}
