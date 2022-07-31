package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsSourceTarget797 {
  private int target;
  private int length;
  private List<List<Integer>> result = new ArrayList<>();
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    length = graph.length;
    target = length-1;
    List<Integer> oneResult = new ArrayList<>();
    oneResult.add(0);
    dfs(graph, oneResult, 0);
    return result;
  }
  private void dfs(int[][] graph, List<Integer> oneResult, int current) {
    if (current == target) {
      result.add(new LinkedList<>(oneResult));
    }
    for (int next : graph[current]) {
      oneResult.add(next);
      dfs(graph, oneResult, next);
      oneResult.remove(oneResult.size()-1);
    }
  }
}
