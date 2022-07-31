package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanVisitAllRooms_841 {
  // 841. 钥匙和房间
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int length = rooms.size();
    boolean[] visited = new boolean[length];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    while (!queue.isEmpty()) {
      int current = queue.poll();
      if (visited[current]) {
        continue;
      }
      visited[current] = true;
      for (int next : rooms.get(current)) {
        if (!visited[next]) {
          queue.add(next);
        }
      }
    }
    for (boolean visit : visited) {
      if (!visit) {
        return false;
      }
    }
    return true;
  }
}
