package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfDistancesInTree_834 {
  public static void main(String[] args) {
    SumOfDistancesInTree_834 sumOfDistancesInTree_834 = new SumOfDistancesInTree_834();
    sumOfDistancesInTree_834.sumOfDistancesInTree(6, new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}});
  }
  private int[] childDistances;
  private int[] countNodeNums;
  private int[] answer;
  public int[] sumOfDistancesInTree(int n, int[][] edges) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
      map.computeIfAbsent(edge[0], k->new ArrayList<>()).add(edge[1]);
      map.computeIfAbsent(edge[1], k->new ArrayList<>()).add(edge[0]);
    }
    childDistances = new int[n];
    countNodeNums = new int[n];
    answer = new int[n];
    preDfs(0, map, -1);
    answer[0] = childDistances[0];
    dfs(0, map, -1);
    return answer;
  }
  private void preDfs(int current, Map<Integer, List<Integer>> edges, int parent) {
    int countNodeNum = 0;
    int distance = 0;
    for (int child : edges.getOrDefault(current, new ArrayList<>())) {
      if (child == parent) {
        continue;
      }
      preDfs(child, edges, current);
      distance += childDistances[child]+countNodeNums[child];
      countNodeNum += countNodeNums[child];
    }
    countNodeNum++;
    childDistances[current] = distance;
    countNodeNums[current] = countNodeNum;
  }
  private void dfs(int current, Map<Integer, List<Integer>> edges, int parent) {
    if (current != 0) {
      int result = answer[parent];
      result += countNodeNums[0]-countNodeNums[current]-1;
      result -= countNodeNums[current]-1;
      answer[current] = result;
    }
    for (int child : edges.getOrDefault(current, new ArrayList<>())) {
      if (child == parent) {
        continue;
      }
      dfs(child, edges, current);
    }
  }
}
