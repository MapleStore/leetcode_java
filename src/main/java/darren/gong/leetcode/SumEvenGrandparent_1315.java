package darren.gong.leetcode;

public class SumEvenGrandparent_1315 {
  public int sumEvenGrandparent(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int result = 0;
    if (root.val%2 == 0) {
      result += count(root);
    }
    return result+sumEvenGrandparent(root.left)+sumEvenGrandparent(root.right);
  }
  private int count(TreeNode node) {
    TreeNode left = node.left;
    TreeNode right = node.right;
    int result = 0;
    if (left != null) {
      result += left.left == null ? 0 : left.left.val;
      result += left.right == null ? 0 : left.right.val;
    }
    if (right != null) {
      result += right.left == null ? 0 : right.left.val;
      result += right.right == null ? 0 : right.right.val;
    }
    return result;
  }
}
