package darren.gong.leetcode;

import java.util.ArrayList;

public class BalanceBST_1382 {
  private ArrayList<TreeNode> list = new ArrayList<>();
  public TreeNode balanceBST(TreeNode root) {
    dfs(root);
    return buildTree(list, 0, list.size()-1);
  }

  private TreeNode buildTree(ArrayList<TreeNode> list, int left, int right) {
    if (left > right) {
      return null;
    }
    int mid = left+((right-left)>>>1);
    TreeNode result = list.get(mid);
    result.left = buildTree(list, left, mid-1);
    result.right = buildTree(list, mid+1, right);
    return result;
  }

  private void dfs(TreeNode node) {
    if (node == null) {
      return;
    }
    dfs(node.left);
    list.add(node);
    dfs(node.right);
  }
}
