package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxProbability_1514 {
  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    double[] results = new double[n];
    Map<Integer, Double> successProb = new HashMap<>(succProb.length);
    int edgeNum = edges.length;
    Map<Integer, HashSet<Integer>> map = new HashMap<>();
    for (int i = 0; i < edgeNum; i++) {
      int[] edge = edges[i];
      map.computeIfAbsent(edge[0], k->new HashSet<>()).add(edge[1]);
      successProb.put((edge[0]<<14)+edge[1], succProb[i]);
      map.computeIfAbsent(edge[1], k->new HashSet<>()).add(edge[0]);
      successProb.put((edge[1]<<14)+edge[0], succProb[i]);
    }
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    results[start] = 1;
    while (!queue.isEmpty()) {
      int current = queue.poll();
      for (int next : map.getOrDefault(current, new HashSet<>())) {
        double nextProb = results[current]*successProb.getOrDefault((current<<14)+next, 0.0);
        if (nextProb > results[next]) {
          queue.add(next);
          results[next] = nextProb;
        }
      }
    }
    return results[end];
  }
}
