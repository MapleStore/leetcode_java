package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IsPossible_2508 {
  public boolean isPossible(int n, List<List<Integer>> edges) {
    int[] counts = new int[n+1];
    Map<Integer, Set<Integer>> tos = new HashMap<>();
    for (List<Integer> edge : edges) {
      tos.computeIfAbsent(edge.get(0), k->new HashSet<>()).add(edge.get(1));
      tos.computeIfAbsent(edge.get(1), k->new HashSet<>()).add(edge.get(0));
      counts[edge.get(0)]++;
      counts[edge.get(1)]++;
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (counts[i]%2 != 0) {
        list.add(i);
      }
    }
    if (list.size()%2 != 0 || list.size() > 4) {
      return false;
    }
    if (list.size() == 0) {
      return true;
    }
    if (list.size() == 2) {
      for (int i = 1; i <= n; i++) {
        if (!tos.getOrDefault(i, new HashSet<>()).contains(list.get(1))
            && !tos.getOrDefault(i, new HashSet<>()).contains(list.get(0))) {
          return true;
        }
      }
      return false;
    }
    for (int j = 1; j < 4; j++) {
      if (tos.getOrDefault(list.get(0), new HashSet<>()).contains(list.get(j))) {
        continue;
      }
      if (j == 1 && !tos.getOrDefault(list.get(2), new HashSet<>()).contains(list.get(3))) {
        return true;
      }
      if (j == 2 && !tos.getOrDefault(list.get(1), new HashSet<>()).contains(list.get(3))) {
        return true;
      }
      return !tos.getOrDefault(list.get(1), new HashSet<>()).contains(list.get(2));
    }
    return false;
  }
}
