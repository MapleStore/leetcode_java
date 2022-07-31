package darren.gong.leetcode;

public class DeepestLeavesSum_1302 {
  private int maxDeep = -1;
  private int count = 0;
  public int deepestLeavesSum(TreeNode root) {
    dfs(root, 0);
    return count;
  }
  private void dfs(TreeNode node, int deep) {
    if (node == null) {
      return;
    }
    if (deep > maxDeep) {
      maxDeep = deep;
      count = node.val;
    } else if (deep == maxDeep) {
      count += node.val;
    }
    dfs(node.left, deep+1);
    dfs(node.right, deep+1);
  }
}
