package darren.gong.leetcode;

public class MaxProduct1339 {
  private long sum = 0;
  private long result = 0;
  private static int MOD = (int)Math.pow(10, 9)+7;
  public int maxProduct(TreeNode root) {
    getSum(root);
    visit(root);
    return (int)(result%MOD);
  }
  private void getSum(TreeNode node) {
    if (node == null) {
      return;
    }
    sum+=node.val;
    getSum(node.left);
    getSum(node.right);
  }
  private long visit(TreeNode node) {
    if (node == null) {
      return 0;
    }
    long leftSum = visit(node.left);
    long rightSum = visit(node.right);
    result = Math.max(result, Math.max(leftSum*(sum-leftSum), rightSum*(sum-rightSum)));
    return leftSum+rightSum+node.val;
  }
}
