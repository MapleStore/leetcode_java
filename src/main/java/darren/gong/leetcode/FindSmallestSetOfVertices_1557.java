package darren.gong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindSmallestSetOfVertices_1557 {
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    int[] points = new int[n];
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (List<Integer> edge : edges) {
      int from = edge.get(0);
      int to = edge.get(1);
      points[from]++;
      Set<Integer> parents = map.computeIfAbsent(to, k->new HashSet<>());
      parents.add(from);
    }

    List<Integer> result = new LinkedList<>();
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (points[i] == 0) {
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      int current = queue.poll();
      Set<Integer> parents = map.get(current);
      if (parents == null || parents.size() == 0) {
        result.add(current);
        continue;
      }
      for (int parent : parents) {
        points[parent]--;
        if (points[parent] == 0) {
          queue.add(parent);
        }
      }
    }
    return result;
  }
}
