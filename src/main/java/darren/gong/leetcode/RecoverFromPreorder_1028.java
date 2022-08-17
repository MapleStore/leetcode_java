package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RecoverFromPreorder_1028 {
  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  private int index = 0;
  public TreeNode recoverFromPreorder(String traversal) {
    List<int[]> nodes = parseNode(traversal);
    return buildTree(nodes, 0);
  }

  private TreeNode buildTree(List<int[]> nodes, int level) {
    int[] current = nodes.get(index++);
    TreeNode treeNode = new TreeNode(current[1]);
    if (index >= nodes.size()) {
      return treeNode;
    }

    int[] next = nodes.get(index);
    if (next[0] > level) {
      treeNode.left = buildTree(nodes, level+1);
    }
    if (index >= nodes.size()) {
      return treeNode;
    }

    next = nodes.get(index);
    if (next[0] > level) {
      treeNode.right = buildTree(nodes, level+1);
    }
    return treeNode;
  }

  private List<int[]> parseNode(String traversal) {
    List<int[]> result = new ArrayList<>();
    char[] chars = traversal.toCharArray();
    int index = 0;
    while (index < chars.length) {
      int[] one = new int[2];

      int i = index;
      while (chars[i] == '-') i++;
      one[0] = i-index;

      int val = 0;
      while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
        val = val*10+chars[i]-'0';
        i++;
      }
      one[1] = val;
      index = i;
      result.add(one);
    }
    return result;
  }
}
