package darren.gong.leetcode;

public class CountComponents323 {
  private int[] parent;
  public int countComponents(int n, int[][] edges) {
    this.parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
    for (int[] edge : edges) {
      union(edge[0], edge[1]);
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      if (find(i) == i) {
        result++;
      }
    }
    return result;
  }

  private void union(int nodeA, int nodeB) {
    parent[find(nodeA)] = parent[find(nodeB)];
  }

  private int find(int node) {
    if (parent[node] == node) {
      return node;
    }
    parent[node] = find(parent[node]);
    return parent[node];
  }
}
