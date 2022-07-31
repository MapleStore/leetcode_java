package darren.gong.leetcode;

import java.util.Arrays;

public class MinimumCost_1135 {
  private int[] parents;
  public int minimumCost(int n, int[][] connections) {
    int cost = 0;
    Arrays.sort(connections, (a,b)->a[2]-b[2]);
    int[] parents = new int[n+1];
    for (int i = 1; i <= n; i++) {
      parents[i] = i;
    }
    this.parents = parents;
    for (int[] connection : connections) {
      int parentA = findParent(connection[0]);
      int parentB = findParent(connection[1]);
      if (parentA == parentB) {
        continue;
      }
      parents[parentA] = parentB;
      cost += connection[2];
    }
    int root = findParent(1);
    for (int i = 2; i <= n; i++) {
      if (root != findParent(i)) {
        return -1;
      }
    }
    return cost;
  }

  private int findParent(int child) {
    if (child == parents[child]) {
      return child;
    }
    int parent = findParent(parents[child]);
    parents[child] = parent;
    return parent;
  }
}
