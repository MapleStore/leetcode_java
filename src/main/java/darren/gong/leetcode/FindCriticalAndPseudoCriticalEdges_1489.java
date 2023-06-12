package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindCriticalAndPseudoCriticalEdges_1489 {
  public static void main(String[] args) {
    FindCriticalAndPseudoCriticalEdges_1489 findCriticalAndPseudoCriticalEdges_1489 = new FindCriticalAndPseudoCriticalEdges_1489();
    findCriticalAndPseudoCriticalEdges_1489.findCriticalAndPseudoCriticalEdges(4,
        new int[][]{{0,1,1},{0,3,1},{0,2,1},{1,2,1},{1,3,1},{2,3,1}});
  }
  private Set<Integer> allEdges = new HashSet<>();
  private Set<Integer> mustEdges = new HashSet<>();
  private int n;
  private int weight;
  public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
    this.n = n;
    Map<int[], Integer> edge2Index = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      edge2Index.put(edges[i], i);
    }
    Arrays.sort(edges, (a,b)->a[2]-b[2]);
    this.weight = getMinTree(-1, -1, edges);
    for (int i = 0; i < edges.length; i++) {
      int currentWeight = getMinTree(i, -1, edges);
      if (currentWeight == -1 || currentWeight > weight) {
        mustEdges.add(i);
      }
      currentWeight = getMinTree(-1, i, edges);
      if (currentWeight == weight && !mustEdges.contains(i)) {
        allEdges.add(i);
      }
    }
    List<List<Integer>> result = new ArrayList<>();
    result.add(new LinkedList<>());
    result.add(new LinkedList<>());
    for (int mustEdge : mustEdges) {
      result.get(0).add(edge2Index.get(edges[mustEdge]));
    }
    for (int notMust : allEdges) {
      result.get(1).add(edge2Index.get(edges[notMust]));
    }
    return result;
  }

  private int getMinTree(int missIndex, int mustAddIndex, int[][] edges) {
    List<Integer> treeNodes = new LinkedList<>();
    int[] parents = new int[n];
    for (int i = 0; i < parents.length; i++) {
      parents[i] = i;
    }
    int weight = 0;
    if (mustAddIndex != -1) {
      int[] edge = edges[mustAddIndex];
      merge(edge[0], edge[1], parents);
      weight += edge[2];
      treeNodes.add(mustAddIndex);
    }
    for (int i = 0; i < edges.length; i++) {
      if (i == missIndex) {
        continue;
      }
      int[] edge = edges[i];
      if (getParent(edge[0], parents) == getParent(edge[1], parents)) {
        continue;
      }
      merge(edge[0], edge[1], parents);
      weight += edge[2];
      treeNodes.add(i);
    }
    if (treeNodes.size() == n-1) {
      return weight;
    } else {
      return -1;
    }
  }
  private void merge(int a, int b, int[] parents) {
    if (parents[a] == parents[b]) {
      return;
    }
    parents[getParent(a, parents)] = getParent(b, parents);
  }
  private int getParent(int child, int[] parents) {
    if (child == parents[child]) {
      return child;
    }
    parents[child] = getParent(parents[child], parents);
    return parents[child];
  }
}
