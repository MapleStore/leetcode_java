package darren.gong.leetcode;

public class DistributeCoins979 {
  private int result = 0;
  public int distributeCoins(TreeNode root) {
    dfs(root);
    return result;
  }
  private int dfs(TreeNode root) {
    int left = 0;
    if (root.left != null) {
      left = dfs(root.left);
      result += Math.abs(left);
    }
    int right = 0;
    if (root.right != null) {
      right = dfs(root.right);
    }
    result += Math.abs(right);
    return left+right+root.val-1;
  }
}
