package darren.gong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinimumSemesters1136 {
  public static void main(String[] args) {
    MinimumSemesters1136 minimumSemesters1136 = new MinimumSemesters1136();
  }
  public int minimumSemesters(int N, int[][] relations) {
    int[] inValue = new int[N+1];
    boolean[] visited = new boolean[N+1];
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] relation : relations) {
      inValue[relation[1]]++;
      map.putIfAbsent(relation[0], new HashSet<>());
      map.get(relation[0]).add(relation[1]);
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      if (inValue[i] == 0) {
        visited[i] = true;
        queue.add(i);
      }
    }

    int result = 0;
    while (!queue.isEmpty()) {
      result++;
      int size = queue.size();
      while (size-- > 0) {
        int currentClass = queue.poll();
        Set<Integer> next = map.get(currentClass);
        if (next == null) {
          continue;
        }
        for (int nextClass : next) {
          inValue[nextClass]--;
        }
      }
      for (int i = 1; i <= N; i++) {
        if (inValue[i] == 0 && !visited[i]) {
          queue.add(i);
          visited[i] = true;
        }
      }
    }
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        return -1;
      }
    }
    return result;
  }
}
