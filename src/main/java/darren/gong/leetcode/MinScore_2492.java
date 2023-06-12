package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinScore_2492 {
  public int minScore(int n, int[][] roads) {
    Map<Integer, List<int[]>> tos = new HashMap<>();
    for (int[] road : roads) {
      tos.computeIfAbsent(road[0], k->new ArrayList<>()).add(new int[]{road[1], road[2]});
      tos.computeIfAbsent(road[1], k->new ArrayList<>()).add(new int[]{road[0], road[2]});
    }
    int min = Integer.MAX_VALUE;
    Set<Long> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    while (!queue.isEmpty()) {
      int current = queue.poll();
      for (int[] road : tos.getOrDefault(current, new ArrayList<>())) {
        if (visited.contains(getVal(current, road[0]))) {
          continue;
        }
        visited.add(getVal(current, road[0]));
        visited.add(getVal(road[0], current));
        min = Math.min(min, road[1]);
        queue.add(road[0]);
      }
    }
    return min;
  }
  private long getVal(int from, int to) {
    return ((long)from<<32)+to;
  }
}
