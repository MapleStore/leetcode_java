package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidTree261 {
  public boolean validTree(int n, int[][] edges) {
    if (edges == null) {
      return false;
    }
    int edgeNum = edges.length;
    if (edgeNum != n-1) {
      return false;
    }
    ArrayList<Integer>[] map = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      map[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      if (edge[0] == edge[1]) {
        return false;
      }
      map[edge[0]].add(edge[1]);
      map[edge[1]].add(edge[0]);
    }
    boolean[] visited = new boolean[n];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0});
    visited[0] = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] current = queue.poll();
        for (int next : map[current[1]]) {
          if (next == current[0]) {
            continue;
          }
          if (visited[next]) {
            return false;
          }
          visited[next] = true;
          queue.add(new int[]{current[1], next});
        }
      }
    }
    for (boolean isVisit : visited) {
      if (!isVisit) {
        return false;
      }
    }
    return true;
  }
}
