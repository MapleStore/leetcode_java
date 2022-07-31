package darren.gong.leetcode.race;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CountRestrictedPaths {
  private static int MOD = (int)Math.pow(10, 9)+7;
  public int countRestrictedPaths(int n, int[][] edges) {
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
      map.putIfAbsent(edge[0], new HashMap<>());
      map.putIfAbsent(edge[1], new HashMap<>());
      map.get(edge[0]).put(edge[1], edge[2]);
      map.get(edge[1]).put(edge[0], edge[2]);
    }
    int[] minDis = new int[n+1];
    Arrays.fill(minDis, Integer.MAX_VALUE);
    minDis[n] = 0;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{n, 0});
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] current = queue.poll();
        int currentId = current[0];
        int currentDis = current[1];
        Map<Integer, Integer> next = map.get(currentId);
        for (Map.Entry<Integer, Integer> entry : next.entrySet()) {
          int nextId = entry.getKey();
          int currentToNext = entry.getValue();
          int nextDis = currentDis+currentToNext;
          if (nextDis < minDis[nextId]) {
            minDis[nextId] = nextDis;
            queue.add(new int[]{nextId, nextDis});
          }
        }
      }
    }
    int[] result = new int[n+1];
    result[n] = 1;
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[1]-b[1]);
    for (int i = 1; i < minDis.length; i++) {
      priorityQueue.add(new int[]{i, minDis[i]});
    }
    while (!priorityQueue.isEmpty()) {
      int[] current = priorityQueue.poll();
      int currentId = current[0];
      int currentMinDis = minDis[currentId];
      Map<Integer, Integer> next = map.get(currentId);
      for (Map.Entry<Integer, Integer> entry : next.entrySet()) {
        int nextId = entry.getKey();
        int nextMinDis = minDis[nextId];
        if (nextMinDis < currentMinDis) {
          result[currentId] += result[nextId];
          result[currentId] %= MOD;
        }
      }
    }
    return result[1];
  }
}
