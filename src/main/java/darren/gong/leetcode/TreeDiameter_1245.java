package darren.gong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TreeDiameter_1245 {
  // 1245. 树的直径
  public int treeDiameter(int[][] edges) {
    int length = edges.length;
    if (length == 0) {
      return 0;
    }
    // 点id 从另一个点id 来的最长距离
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i <= length; i++) {
      map.put(i, new HashSet<>());
    }
    for (int[] edge : edges) {
      map.get(edge[0]).add(edge[1]);
      map.get(edge[1]).add(edge[0]);
    }
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[length+1];
    queue.add(0);
    visited[0] = true;
    int furthest = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int current = queue.poll();
        furthest = current;
        for (int next : map.get(current)) {
          if (visited[next]) {
            continue;
          }
          queue.add(next);
          visited[next] = true;
        }
      }
    }
    visited = new boolean[length+1];
    queue.add(furthest);
    visited[furthest] = true;
    int result = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int current = queue.poll();
        for (int next : map.get(current)) {
          if (visited[next]) {
            continue;
          }
          queue.add(next);
          visited[next] = true;
        }
      }
      result++;
    }
    return result-1;
  }
}
