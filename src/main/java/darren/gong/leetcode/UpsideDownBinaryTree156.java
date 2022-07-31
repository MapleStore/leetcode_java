package darren.gong.leetcode;

public class UpsideDownBinaryTree156 {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    UpsideDownBinaryTree156 upsideDownBinaryTree156 = new UpsideDownBinaryTree156();
    upsideDownBinaryTree156.upsideDownBinaryTree(root);
  }
  private TreeNode result;
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null) return null;
    upsideDownBinaryTreeHelper(root);
    return result;
  }
  public TreeNode upsideDownBinaryTreeHelper(TreeNode root) {
    if (root.left == null && root.right == null) {
      if (result == null) result = root;
      return root;
    }
    TreeNode left = upsideDownBinaryTreeHelper(root.left);
    left.left = root.right;
    left.right = root;

    root.left = null;
    root.right = null;
    return root;
  }
}
