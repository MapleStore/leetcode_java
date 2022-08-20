package darren.gong.leetcode.interview;

public class CheckSubTree_0410 {
  // 面试题 04.10. 检查子树
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  public boolean checkSubTree(TreeNode t1, TreeNode t2) {
    if (t2 == null) {
      return true;
    }
    if (t1 == null) {
      return false;
    }
    if (t1.val == t2.val) {
      return equals(t1.left, t2.left) && equals(t1.right, t2.right);
    }
    return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
  }
  private boolean equals(TreeNode t1, TreeNode t2) {
    if (t1 == null || t2 == null) {
      if (t1 == null && t2 == null) {
        return true;
      }
      return false;
    }
    if (t1.val != t2.val) {
      return false;
    }
    return equals(t1.left, t2.left) && equals(t1.right, t2.right);
  }
}
