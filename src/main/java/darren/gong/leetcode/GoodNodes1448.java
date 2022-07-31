package darren.gong.leetcode;

public class GoodNodes1448 {
  private int result = 0;
  public int goodNodes(TreeNode root) {
    goodNodesHelper(root, Integer.MIN_VALUE);
    return result;
  }
  private void goodNodesHelper(TreeNode node, int maxValue) {
    if (node == null) {
      return;
    }
    if (node.val >= maxValue) {
      result++;
      maxValue = node.val;
    }
    goodNodesHelper(node.left, maxValue);
    goodNodesHelper(node.right, maxValue);
  }
}
