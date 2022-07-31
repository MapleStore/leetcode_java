package darren.gong.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum_34 {
  // 剑指 Offer 34. 二叉树中和为某一值的路径
  private static class TreeNode {
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

  private List<List<Integer>> result = new LinkedList<>();

  public List<List<Integer>> pathSum(TreeNode root, int target) {
    dfs(root, target, new ArrayList<>());
    return result;
  }

  private void dfs(TreeNode current, int target, List<Integer> list) {
    if (current == null) {
      return;
    }
    target -= current.val;
    list.add(current.val);
    if (target == 0 && current.left == null && current.right == null) {
      result.add(new ArrayList<>(list));
    }
    dfs(current.left, target, list);
    dfs(current.right, target, list);
    list.remove(list.size()-1);
  }
}
