package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TreeQueries_2458 {
/*
  public static void main(String[] args) {
    TreeQueries_2458 treeQueries_2458 = new TreeQueries_2458();
    treeQueries_2458.treeQueries()
  }
*/
  private static class Node {
    //TreeNode treeNode;
    Node left;
    Node right;
    int height = 0;
    private Node() {
    }
  }
  private Map<Integer, Integer> resultMap = new HashMap<>();
  private Map<Integer, Integer> deepCache = new HashMap<>();
  public int[] treeQueries(TreeNode root, int[] queries) {
    int length = queries.length;
    helper(root, 0, 0);
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      result[i] = resultMap.get(queries[i]);
    }
    return result;
  }
  private void helper(TreeNode node, int length, int maxLength) {
    if (node == null) {
      return;
    }
    resultMap.put(node.val, maxLength);
    int leftDeep = getDeep(node.left);
    int rightDeep = getDeep(node.right);
    if (node.left != null) {
      helper(node.left, length+1, Math.max(maxLength, length+1+rightDeep));
    }
    if (node.right != null) {
      helper(node.right, length+1, Math.max(maxLength, length+1+leftDeep));
    }
  }
  private int getDeep(TreeNode node) {
    if (node == null) {
      return -1;
    }
    if (deepCache.containsKey(node.val)) {
      return deepCache.get(node.val);
    }
    int deep = Math.max(getDeep(node.left), getDeep(node.right));
    deepCache.put(node.val, deep+1);
    return deep+1;
  }
}
