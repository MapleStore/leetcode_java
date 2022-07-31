package darren.gong.leetcode;

public class IsCousins993 {
  private int deepX;
  private int deepY;
  private TreeNode xParent;
  private TreeNode yParent;
  public boolean isCousins(TreeNode root, int x, int y) {
    visit(root, x, y, 0, null);
    if (deepX == deepY && xParent != yParent) {
      return true;
    }
    return false;
  }
  private void visit(TreeNode root, int x, int y, int deep, TreeNode parent) {
    if (root == null) {
      return;
    }
    if (root.val == x) {
      deepX = deep;
      xParent = parent;
      if (yParent != null) {
        return;
      }
    }
    if (root.val == y) {
      deepY = deep;
      yParent = parent;
      if (xParent != null) {
        return;
      }
    }
    visit(root.left, x, y, deep+1, root);
    visit(root.right, x, y, deep+1, root);
  }
}
