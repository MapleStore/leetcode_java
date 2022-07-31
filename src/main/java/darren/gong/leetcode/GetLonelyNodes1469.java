package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GetLonelyNodes1469 {
  private List<Integer> result = new ArrayList<>();
  public List<Integer> getLonelyNodes(TreeNode root) {
    dfs(root);
    return result;
  }
  private void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right != null) {
      result.add(root.right.val);
    }
    if (root.left != null && root.right == null) {
      result.add(root.left.val);
    }
    dfs(root.left);
    dfs(root.right);
  }
}
