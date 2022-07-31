package darren.gong.leetcode;

public class SubtreeWithAllDeepest_865 {
  private int maxDeep = Integer.MIN_VALUE;
  private TreeNode result;
  // 865. 具有所有最深节点的最小子树
  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    maxDeep(root, 0);
    return result;
  }
  private int maxDeep(TreeNode node, int deep) {
    if (node == null) {
      return deep;
    }
    int left = maxDeep(node.left, deep+1);
    int right = maxDeep(node.right, deep+1);
    int currentMax = Math.max(left, right);
    maxDeep = Math.max(maxDeep, currentMax);
    if (left == maxDeep && right == maxDeep) {
      result = node;
    }
    return currentMax;
  }
}
