package darren.gong.leetcode;

public class BstToGst1038 {
  private int value;
  public TreeNode bstToGst(TreeNode root) {
    dfs(root);
    return root;
  }
  private void dfs(TreeNode root) {
    if (root.right != null) {
      dfs(root.right);
    }
    value += root.val;
    root.val = value;
    if (root.left != null) {
      dfs(root.left);
    }
  }
}
