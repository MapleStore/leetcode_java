package darren.gong.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LeafSimilar872 {
  private List<Integer> tree1Leaves = new LinkedList<>();
  private List<Integer> tree2Leaves = new LinkedList<>();
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    visited(root1, tree1Leaves);
    visited(root2, tree2Leaves);
    Iterator<Integer> tree1Iterator = tree1Leaves.iterator();
    Iterator<Integer> tree2Iterator = tree2Leaves.iterator();
    if (tree1Leaves.size() != tree2Leaves.size()) {
      return false;
    }
    while (tree1Iterator.hasNext()) {
      if (tree1Iterator.next() != tree2Iterator.next()) {
        return false;
      }
    }
    return true;
  }
  private void visited(TreeNode node, List<Integer> leaves) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null) {
      leaves.add(node.val);
      return;
    }
    visited(node.left, leaves);
    visited(node.right, leaves);
  }
}
