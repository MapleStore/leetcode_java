package darren.gong.leetcode;

public class BtreeGameWinningMove1145 {
  private int x;
  private int leftValue;
  private int rightValue;
  public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    this.x = x;
    dfs(root);
    return leftValue > n/2 || rightValue > n/2 || leftValue+rightValue+1 <= n/2;
  }
  private int dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int leftValue = dfs(node.left);
    int rightValue = dfs(node.right);
    if (node.val == x) {
      this.leftValue = leftValue;
      this.rightValue = rightValue;
    }
    return leftValue+rightValue+1;
  }
}
