package darren.gong.leetcode;

public class PruneTree_814 {
  // 814. 二叉树剪枝
  public TreeNode pruneTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);
    if (root.left == null && root.right == null && root.val == 0) {
      return null;
    }
    return root;
  }
}
