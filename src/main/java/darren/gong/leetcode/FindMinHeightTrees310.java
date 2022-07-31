package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindMinHeightTrees310 {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (edges == null || edges.length == 0 || edges[0].length == 0) {
      return new ArrayList<>();
    }
    List<Integer> result = null;
    if (n == 1) {
      result = new LinkedList<>();
      result.add(0);
      return result;
    }

    int[] degrees = new int[n];
    Set<Integer>[] paths = new Set[n];
    for (int i = 0; i < n; i++) {
      paths[i] = new HashSet<>();
    }
    for (int i = 0; i < n-1; i++) {
      int[] edge = edges[i];
      degrees[edge[0]]++;
      degrees[edge[1]]++;
      paths[edge[0]].add(edge[1]);
      paths[edge[1]].add(edge[0]);
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (degrees[i] == 1) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      result = new LinkedList<>(queue);
      int size = queue.size();
      while (size-- > 0) {
        int current = queue.poll();
        degrees[current]--;
        for (int next : paths[current]) {
          degrees[next]--;
          if (degrees[next] == 1) {
            queue.add(next);
          }
        }
      }
    }
    return result;
  }
}
