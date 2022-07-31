package darren.gong.leetcode;

public class LcaDeepestLeaves_1123 {
  private int maxDeep = Integer.MIN_VALUE;
  private TreeNode result = null;
  public TreeNode lcaDeepestLeaves(TreeNode root) {
    maxDeep(root, 0);
    return result;
  }
  private int maxDeep(TreeNode node, int deep) {
    if (node == null) {
      return deep;
    }
    int leftMax = maxDeep(node.left, deep+1);
    int rightMax = maxDeep(node.right, deep+1);
    if (leftMax == rightMax && leftMax >= maxDeep) {
      maxDeep = leftMax;
      result = node;
    }
    return Math.max(leftMax, rightMax);
  }
}
