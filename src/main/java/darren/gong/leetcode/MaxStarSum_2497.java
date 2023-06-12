package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxStarSum_2497 {
  public int maxStarSum(int[] vals, int[][] edges, int k) {
    if (k == 0) {
      return 0;
    }
    Map<Integer, List<Integer>> tos = new HashMap<>();
    for (int[] edge : edges) {
      tos.computeIfAbsent(edge[0], c->new ArrayList<>()).add(edge[1]);
      tos.computeIfAbsent(edge[1], c->new ArrayList<>()).add(edge[0]);
    }
    PriorityQueue<Integer> points = new PriorityQueue<>((a,b)->{
/*
      if (vals[a] == vals[b]) {
        return a-b;
      }
*/
      return vals[b]-vals[a];
    });
    for (int i = 0; i < vals.length; i++) {
      points.add(i);
    }
    int[] counts = new int[vals.length];
    int[] results = Arrays.copyOf(vals, vals.length);
    while (!points.isEmpty()) {
      int point = points.poll();
      List<Integer> nexts = tos.getOrDefault(point, new ArrayList<>());
      for (int next : nexts) {
        if (counts[next] < k && vals[point] > 0) {
          counts[next]++;
          results[next] += vals[point];
        }
      }
    }
    return Arrays.stream(results).max().getAsInt();
  }
}
