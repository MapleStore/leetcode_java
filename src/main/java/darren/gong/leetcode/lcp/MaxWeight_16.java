package darren.gong.leetcode.lcp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaxWeight_16 {
  public static void main(String[] args) {
    MaxWeight_16 maxWeight_16 = new MaxWeight_16();
    maxWeight_16.maxWeight(new int[][]{{3,8},{4,7},{7,8},{1,3},{4,8},{8,9},{3,9}}, new int[]{7080,5450,4841,8487,8689,8563,281,3794,3916,4946});
  }
  static class Paths {
    int[] points = new int[3];
    Paths() {}

    Paths(Paths another) {
      this.points[0] = another.points[0];
      this.points[1] = another.points[1];
      this.points[2] = another.points[2];
    }
  }
  private List<Paths> list = new ArrayList<>();
  public int maxWeight(int[][] edges, int[] value) {
    int length = edges.length;
    int n = value.length;
    Map<Integer, LinkedList<Integer>> map = new HashMap<>();
    for (int i = 0; i < length; i++) {
      int[] edge = edges[i];
      map.computeIfAbsent(edge[0], k->new LinkedList<>()).add(edge[1]);
      map.computeIfAbsent(edge[1], k->new LinkedList<>()).add(edge[0]);
    }
    int result = 0;
    for (int aPoint : map.keySet()) {
      boolean[] visited = new boolean[n];
      visited[aPoint] = true;
      dfs(aPoint, map, visited, new Paths(), 0);
      result = Math.max(getMaxFavorite(list, value), result);
      list = new ArrayList<>();
    }
    return result;
  }
  private void dfs(int current, Map<Integer, LinkedList<Integer>> map, boolean[] visited, Paths paths, int index) {
    if (index >= 3) {
      return;
    }
    paths.points[index] = current;
    LinkedList<Integer> nexts = map.get(current);
    for (int next : nexts) {
      if (index == 2 && next == paths.points[0]) {
        list.add(new Paths(paths));
      }
      if (visited[next] || (index == 1 && next < current)) {
        continue;
      }
      visited[current] = true;
      dfs(next, map, visited, paths, index+1);
      visited[current] = false;
    }
  }
  private int getMaxFavorite(List<Paths> list, int[] values) {
    int length = list.size();
    if (length == 1) {
      Paths paths = list.get(0);
      return values[paths.points[0]]+values[paths.points[1]]+values[paths.points[2]];
    }
    int max = Integer.MIN_VALUE;
    Set<Paths> top3 = new HashSet<>();
    Paths target1 = getMaxPathsInList(list, top3, values);
    if (target1 != null) {
      top3.add(target1);
      max = getMaxFavoriteValueWithOnePath(list, target1, values);
    }
    Paths target2 = getMaxPathsInList(list, top3, values);
    if (target2 != null) {
      top3.add(target2);
      max = Math.max(max, getMaxFavoriteValueWithOnePath(list, target2, values));
    }
    Paths target3 = getMaxPathsInList(list, top3, values);
    if (target3 != null) {
      top3.add(target3);
      max = Math.max(max, getMaxFavoriteValueWithOnePath(list, target3, values));
    }
    return max;
  }
  private Paths getMaxPathsInList(List<Paths> list, Set<Paths> top3, int[] values) {
    int max = Integer.MIN_VALUE;
    Paths target = null;
    for (Paths paths : list) {
      if (top3.contains(paths)) {
        continue;
      }
      int value = getPathsValue(paths, values);
      if (value > max) {
        max = value;
        target = paths;
      }
    }
    return target;
  }
  private int getMaxFavoriteValueWithOnePath(List<Paths> list, Paths paths, int[] values) {
    int max = Integer.MIN_VALUE;
    for (Paths anotherPaths : list) {
      max = Math.max(max, getTwoPathValue(paths, anotherPaths, values));
    }
    return max;
  }
  private int getTwoPathValue(Paths paths2, Paths paths1, int[] values) {
    int value = values[paths1.points[0]]+values[paths1.points[1]]+values[paths1.points[2]];
    if (paths2.points[1] != paths1.points[1] && paths2.points[1] != paths1.points[2]) {
      value += values[paths2.points[1]];
    }
    if (paths2.points[2] != paths1.points[1] && paths2.points[2] != paths1.points[2]) {
      value += values[paths2.points[2]];
    }
    return value;
  }
  private int getPathsValue(Paths paths, int[] values) {
    return values[paths.points[1]]+values[paths.points[2]];
  }
}
