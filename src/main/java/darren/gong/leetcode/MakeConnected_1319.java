package darren.gong.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MakeConnected_1319 {
  public static void main(String[] args) {
    MakeConnected_1319 makeConnected_1319 = new MakeConnected_1319();
    makeConnected_1319.makeConnected(4,
    new int[][]{{0,1},{0,2},{1,2}});
  }
  private int[] parent;
  private int repeat = 0;
  public int makeConnected(int n, int[][] connections) {
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
    for (int[] connection : connections) {
      merge(connection[0], connection[1]);
    }
    Set<Integer> diff = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int parent = find(i);
      if (!diff.contains(parent)) {
        diff.add(parent);
      }
    }
    return repeat < diff.size()-1 ? -1 : diff.size()-1;
  }

  private int find(int n) {
    if (parent[n] == n) {
      return n;
    }
    parent[n] = find(parent[n]);
    return parent[n];
  }
  private void merge(int a, int b) {
    int aParent = find(a);
    int bParent = find(b);
    if (aParent == bParent) {
      repeat++;
      return;
    }
    parent[aParent] = bParent;
  }
}
