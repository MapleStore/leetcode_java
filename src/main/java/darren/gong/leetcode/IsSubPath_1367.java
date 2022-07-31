package darren.gong.leetcode;

public class IsSubPath_1367 {
  public boolean isSubPath(ListNode head, TreeNode root) {
    if (head == null) {
      return true;
    }
    if (root == null) {
      return false;
    }
    return match(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
  }
  private boolean match(TreeNode root, ListNode head) {
    if (head == null) {
      return true;
    }
    if (root == null) {
      return false;
    }
    if (root.val != head.val) {
      return false;
    }
    return match(root.left, head.next) || match(root.right, head.next);
  }
}
