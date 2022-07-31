package darren.gong.leetcode.interview;

public class PathSum_0412 {
  // 面试题 04.12. 求和路径
  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(0);
    root.left.left = new TreeNode(0);
    PathSum_0412 pathSum_0412 = new PathSum_0412();
    pathSum_0412.pathSum(root, 0);
  }
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  private int max;
  private int result = 0;
  public int pathSum(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    this.max = sum;
    pathSumHelper(root, sum);
    return result;
  }
  private void pathSumHelper(TreeNode root, int sum) {
    if (root == null) {
      return;
    }
    sum -= root.val;
    if (sum == 0) {
      result++;
    }
    dfs(root.left, sum);
    dfs(root.right, sum);
    pathSumHelper(root.left, max);
    pathSumHelper(root.right, max);
  }
  private void dfs(TreeNode root, int sum) {
    if (root == null) {
      return;
    }
    sum -= root.val;
    if (sum == 0) {
      result++;
    }
    dfs(root.left, sum);
    dfs(root.right, sum);
  }
}
