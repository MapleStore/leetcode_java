package darren.gong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DelNodes1110 {
  private List<TreeNode> result = new LinkedList<>();
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    boolean[] toDelete = new boolean[1001];
    for (int deleteIndex : to_delete) {
      toDelete[deleteIndex] = true;
    }
    delNodes(root, toDelete);
    if (!toDelete[root.val]) {
      result.add(root);
    }
    return result;
  }
  private TreeNode delNodes(TreeNode node, boolean[] toDelete) {
    if (node == null) {
      return null;
    }
    node.left = delNodes(node.left, toDelete);
    node.right = delNodes(node.right, toDelete);
    if (!toDelete[node.val]) {
      return node;
    }
    if (node.left != null) {
      result.add(node.left);
    }
    if (node.right != null) {
      result.add(node.right);
    }
    return null;
  }
}
