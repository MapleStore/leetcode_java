package darren.gong.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathLength_847 {
  public static void main(String[] args) {
    ShortestPathLength_847 shortestPathLength_847 = new ShortestPathLength_847();
    shortestPathLength_847.shortestPathLength(new int[][]{{1,2,3},{0},{0},{0}});
  }
  public int shortestPathLength(int[][] graph) {
    int n = graph.length;
    if (n <= 1) {
      return 0;
    }
    int target = (1<<n)-1;

    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      queue.add(new int[]{i, 1<<i, 0});
    }
    Set<Integer> visitedStatus = new HashSet<>();
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int node = current[0];
      int visited = current[1];
      int distance = current[2];
      for (int next : graph[node]) {
        int nextVisited = visited | (1 << next);
        if (nextVisited == target) {
          return distance + 1;
        }
        // 到过哪些 ｜ 当前位置
        int nextStatus = (nextVisited << n) | (1 << next);
        if (visitedStatus.contains(nextStatus)) {
          continue;
        }
        visitedStatus.add(nextStatus);
        queue.add(new int[]{next, nextVisited, distance + 1});
      }
    }
    return -1;
  }
}
