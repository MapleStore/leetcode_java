package darren.gong.leetcode;

public class MaxAncestorDiff1026 {
  private int result = 0;
  public int maxAncestorDiff(TreeNode root) {
    if (root == null) {
      return 0;
    }
    maxAncestorDiffHelper(root);
    return result;
  }
  private int[] maxAncestorDiffHelper(TreeNode root) {
    int max = root.val;
    int min = root.val;
    if (root.left != null) {
      int[] leftValue = maxAncestorDiffHelper(root.left);
      max = Math.max(max, leftValue[0]);
      min = Math.min(min, leftValue[1]);
    }
    if (root.right != null) {
      int[] rightValue = maxAncestorDiffHelper(root.right);
      max = Math.max(max, rightValue[0]);
      min = Math.min(min, rightValue[1]);
    }
    result = Math.max(result, Math.max(Math.abs(root.val-max), Math.abs(root.val-min)));
    return new int[]{max, min};
  }
}
