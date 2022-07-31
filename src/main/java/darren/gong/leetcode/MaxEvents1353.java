package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class MaxEvents1353 {
  public static void main(String[] args) {
    MaxEvents1353 maxEvents1353 = new MaxEvents1353();
    maxEvents1353.maxEvents(new int[][]{{52,79},{7,34}});
  }
  public int maxEvents(int[][] events) {
    TreeMap<Integer, Set<int[]>> map = new TreeMap<>();
    for (int[] event : events) {
      map.putIfAbsent(event[0], new HashSet<>());
      map.get(event[0]).add(event);
    }
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->{
      if (a[1] == b[1]) {
        return a[0]-b[0];
      } else {
        return a[1]-b[1];
      }
    });

    Integer today = 0;
    int result = 0;
    while ((today = map.ceilingKey(today)) != null) {
      queue.addAll(map.get(today));
      while (!queue.isEmpty()) {
        while (!queue.isEmpty() && queue.peek()[1] < today) {
          queue.poll();
        }
        if (queue.isEmpty()) {
          break;
        }
        queue.poll();
        today++;
        result++;
        queue.addAll(map.getOrDefault(today, new HashSet<>()));
      }
    }
    return result;
  }
}
