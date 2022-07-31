package darren.gong.leetcode;

public class PseudoPalindromicPaths_1457 {
  // 1457. 二叉树中的伪回文路径
  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(3);
    PseudoPalindromicPaths_1457 pseudoPalindromicPaths_1457 = new PseudoPalindromicPaths_1457();
    pseudoPalindromicPaths_1457.pseudoPalindromicPaths(root);
  }
  private int[] count = new int[10];
  private int result = 0;
  private int num = 0;
  public int pseudoPalindromicPaths (TreeNode root) {
    pseudoPalindromicPathsHelper(root);
    return result;
  }
  public void pseudoPalindromicPathsHelper(TreeNode root) {
    if (root == null) {
      return;
    }
    count[root.val]++;
    num = num+(count[root.val] % 2 == 1 ? 1 : -1);
    if (root.left == null && root.right == null && num <= 1) {
      result++;
    }
    pseudoPalindromicPathsHelper(root.left);
    pseudoPalindromicPathsHelper(root.right);
    count[root.val]--;
    num = num+(count[root.val] % 2 == 1 ? 1 : -1);
  }
}
