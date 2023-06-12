package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumSimilarGroups_839 {
  public static void main(String[] args) {
    NumSimilarGroups_839 numSimilarGroups_839 = new NumSimilarGroups_839();
    numSimilarGroups_839.numSimilarGroups(new String[]{"tars","rats","arts","star"});
  }
  private int[] parents;
  public int numSimilarGroups(String[] strs) {
    int length = strs.length;
    this.parents = new int[length];
    for (int i = 0; i < length; i++) {
      parents[i] = i;
    }
    for (int i = 0; i < length; i++) {
      for (int j = i+1; j < length; j++) {
        if (valid(strs[i], strs[j])) {
          merge(i, j);
        }
      }
    }
    Set<Integer> groups = new HashSet<>();
    for (int i = 0; i < length; i++) {
      groups.add(getParent(i));
    }
    return groups.size();
  }
  private boolean valid(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < str1.length(); i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        list.add(i);
      }
      if (list.size() > 2) {
        return false;
      }
    }
    if (list.size() == 0) {
      return true;
    }
    if (list.size() != 2) {
      return false;
    }
    return str1.charAt(list.get(0)) == str2.charAt(list.get(1)) && str1.charAt(list.get(1)) == str2.charAt(list.get(0));
  }
  private void merge(int node1, int node2) {
    int parent1 = getParent(node1);
    int parent2 = getParent(node2);
    if (parent1 == parent2) {
      return;
    }
    parents[parent1] = parent2;
  }
  private int getParent(int node) {
    if (parents[node] == node) {
      return node;
    }
    parents[node] = getParent(parents[node]);
    return parents[node];
  }
}
