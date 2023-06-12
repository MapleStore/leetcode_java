package darren.gong.leetcode;

import java.util.Arrays;

public class TreeAncestor_1483 {
  private int[][] parents;
  public TreeAncestor_1483(int n, int[] parent) {
    parents = new int[n][32];
    for (int[] oneParents : parents) {
      Arrays.fill(oneParents, -1);
    }
    for (int i = 0; i < n; i++) {
      parents[i][0] = parent[i];
    }
    for (int level = 1; level < 22; level++) {
      for (int i = 0; i < n; i++) {
        int iParentNext = parents[i][level-1];
        if (iParentNext != -1) {
          parents[i][level] = parents[iParentNext][level-1];
        }
      }
    }
  }

  public int getKthAncestor(int node, int k) {
    if (k >= (1<<23)) {
      return -1;
    }
    for (int i = 22; i >= 0; i--) {
      if (((1<<i)&k) == 0) {
        continue;
      }
      node = parents[node][i];
      if (node == -1) {
        return -1;
      }
    }
    return node;
  }
}
