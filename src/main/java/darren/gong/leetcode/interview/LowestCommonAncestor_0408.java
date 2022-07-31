package darren.gong.leetcode.interview;

public class LowestCommonAncestor_0408 {
  // 面试题 04.08. 首个共同祖先
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  private TreeNode result;
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    lowestCommonAncestorHelper(root, p, q);
    return result;
  }
  public boolean lowestCommonAncestorHelper(TreeNode node, TreeNode p, TreeNode q) {
    if (node == null) {
      return false;
    }
    boolean left = lowestCommonAncestorHelper(node.left, p, q);
    boolean right = lowestCommonAncestorHelper(node.right, p, q);
    if (node == p || node == q) {
      if (left || right) {
        result = node;
      }
      return true;
    }
    if (left && right) {
      result = node;
      return true;
    }
    return left || right;
  }
}
