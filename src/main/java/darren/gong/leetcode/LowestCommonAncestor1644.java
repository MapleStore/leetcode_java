package darren.gong.leetcode;

public class LowestCommonAncestor1644 {
  // 1644. 二叉树的最近公共祖先 II
  private TreeNode result = null;
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    contains(root, p, q);
    return result;
  }
  private boolean contains(TreeNode node, TreeNode p, TreeNode q) {
    if (node == null) {
      return false;
    }
    boolean left = contains(node.left, p, q);
    boolean right = contains(node.right, p, q);
    if ((node == p && (left || right)) || (node == q && (left || right)) || (left && right)) {
      result = node;
      return true;
    }
    return node == p || node == q || left || right;
  }
}
