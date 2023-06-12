package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MinCostToSupplyWater_1168 {
  public static void main(String[] args) {
    MinCostToSupplyWater_1168 minCostToSupplyWater_1168 = new MinCostToSupplyWater_1168();
    minCostToSupplyWater_1168.minCostToSupplyWater(5, new int[]{46012,72474,64965,751,33304}, new int[][]{{2,1,6719},{3,2,75312},{5,3,44918}});
  }
  public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
    boolean[] visited = new boolean[n+1];
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[1]-b[1]);

    for (int i = 1; i <= n; i++) {
      priorityQueue.add(new int[]{i, wells[i-1]});
    }
    Map<Integer, List<int[]>> map = new HashMap<>();
    for (int[] pipe : pipes) {
      List<int[]> list1 = map.computeIfAbsent(pipe[0], k->new ArrayList<>());
      list1.add(new int[]{pipe[1], pipe[2]});

      List<int[]> list2 = map.computeIfAbsent(pipe[1], k->new ArrayList<>());
      list2.add(new int[]{pipe[0], pipe[2]});
    }
    int count = 0;
    int result = 0;
    while (!priorityQueue.isEmpty()) {
      int[] current = priorityQueue.poll();
      int index = current[0];
      int cost = current[1];
      if (visited[index]) {
        continue;
      }
      visited[index] = true;
      count++;
      result += cost;
      if (count >= n) {
        break;
      }
      for (int[] next : map.getOrDefault(index, new ArrayList<>())) {
        int nextIndex = next[0];
        priorityQueue.add(new int[]{nextIndex, Math.min(next[1], wells[nextIndex-1])});
      }
    }
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        result += wells[i-1];
      }
    }
    return result;
  }
}
