package darren.gong.leetcode;

public class CountUnivalSubtrees_250 {
  // 250. 统计同值子树
  private int result = 0;
  public int countUnivalSubtrees(TreeNode root) {
    isUnivalSubtree(root);
    return result;
  }
  private boolean isUnivalSubtree(TreeNode node) {
    if (node == null) {
      return true;
    }
    boolean leftIs = isUnivalSubtree(node.left);
    boolean rightIs = isUnivalSubtree(node.right);
    if (!leftIs || !rightIs) {
      return false;
    }
    int leftValue = node.left == null ? node.val : node.left.val;
    int rightValue = node.right == null ? node.val : node.right.val;
    if (leftValue == node.val && rightValue == node.val) {
      result++;
      return true;
    }
    return false;
  }
}
