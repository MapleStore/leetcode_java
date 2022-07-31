package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteTreeNodes1273 {
  public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
    Map<Integer, List<Integer>> nodeToChildren = new HashMap<>();
    for (int i = 0; i < nodes; i++) {
      List<Integer> children = nodeToChildren.get(parent[i]);
      if (children == null) {
        children = new ArrayList<>();
        nodeToChildren.put(parent[i], children);
      }
      children.add(i);
    }
    buildValue(nodeToChildren, value, 0);
    for (int i = 0; i < nodes; i++) {
      if (value[i] == 0) {
        deleteTree(nodeToChildren, i, parent);
      }
    }
    int result = 0;
    for (int i = 0; i < nodes; i++) {
      if (parent[i] != -2) {
        result++;
      }
    }
    return result;
  }
  private int buildValue(Map<Integer, List<Integer>> nodeToChildren, int[] value, int current) {
    if (!nodeToChildren.containsKey(current)) {
      return value[current];
    }
    for (Integer child : nodeToChildren.get(current)) {
      value[current] += buildValue(nodeToChildren, value, child);
    }
    return value[current];
  }
  private int deleteTree(Map<Integer, List<Integer>> nodeToChildren, int current, int[] parent) {
    if (parent[current] == -2) {
      return 0;
    }
    if (!nodeToChildren.containsKey(current)) {
      parent[current] = -2;
      return 1;
    }
    int result = 0;
    for (Integer child : nodeToChildren.get(current)) {
      result += deleteTree(nodeToChildren, child, parent);
    }
    parent[current] = -2;
    return result;
  }
}
