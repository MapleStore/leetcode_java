package darren.gong.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindRedundantDirectedConnection_685 {
  public int[] findRedundantDirectedConnection(int[][] edges) {
    int[] result = null;
    for (int i = 0; i < edges.length; i++) {
      if (check(i, edges)) {
        result = edges[i];
      }
    }
    return result;
  }
  private boolean check(int index, int[][] edges) {
    int length = edges.length;
    int[] parents = new int[length+1];
    for (int i = 1; i <= length; i++) {
      parents[i] = i;
    }
    for (int i = 0; i < length; i++) {
      if (i == index) {
        continue;
      }
      if (getParent(edges[i][1], parents) == getParent(edges[i][0], parents)) {
        return false;
      }
      parents[edges[i][1]] = edges[i][0];
    }
    Set<Integer> root = new HashSet<>();
    for (int i = 1; i <= length; i++) {
      root.add(getParent(i, parents));
    }
    return root.size() == 1;
  }
  private int getParent(int child, int[] parents) {
    if (parents[child] == child) {
      return parents[child];
    }
    parents[child] = getParent(parents[child], parents);
    return parents[child];
  }
}
