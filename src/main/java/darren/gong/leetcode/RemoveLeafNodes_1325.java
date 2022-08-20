package darren.gong.leetcode;

public class RemoveLeafNodes_1325 {
  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if (root == null) {
      return null;
    }
    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);
    return root.left == null && root.right == null && root.val == target ? null : root;
  }
}
