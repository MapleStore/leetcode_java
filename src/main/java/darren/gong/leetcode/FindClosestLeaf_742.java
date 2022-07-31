package darren.gong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindClosestLeaf_742 {
  public static void main(String[] args) {
    FindClosestLeaf_742 findClosestLeaf_742 = new FindClosestLeaf_742();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(5);
    root.left.left.left.left = new TreeNode(6);
    findClosestLeaf_742.findClosestLeaf(root, 2);
  }
  private Map<TreeNode, Set<TreeNode>> paths = new HashMap<>();
  private int target;
  private TreeNode targetNode;
  // 742. 二叉树最近的叶节点
  public int findClosestLeaf(TreeNode root, int k) {
    target = k;
    makeGraph(root);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(targetNode);
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      if (current.left == null && current.right == null) {
        return current.val;
      }
      Set<TreeNode> next = paths.get(current);
      if (next != null && !next.isEmpty()) {
        queue.addAll(next);
      }
    }
    return -1;
  }
  private boolean makeGraph(TreeNode node) {
    boolean result;
    if (node.val == target) {
      result = true;
      targetNode = node;
    } else {
      result = false;
    }

    if (node.left != null) {
      boolean containsTarget = makeGraph(node.left);
      result |= containsTarget;
      if (containsTarget) {
        Set<TreeNode> set = paths.computeIfAbsent(node.left, k->new HashSet<>());
        set.add(node);
      } else {
        Set<TreeNode> set = paths.computeIfAbsent(node, k->new HashSet<>());
        set.add(node.left);
      }
    }

    if (node.right != null) {
      boolean containsTarget = makeGraph(node.right);
      result |= containsTarget;
      if (containsTarget) {
        Set<TreeNode> set = paths.computeIfAbsent(node.right, k->new HashSet<>());
        set.add(node);
      } else {
        Set<TreeNode> set = paths.computeIfAbsent(node, k->new HashSet<>());
        set.add(node.right);
      }
    }
    return result;
  }
}
