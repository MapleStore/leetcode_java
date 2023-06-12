package darren.gong.leetcode.race;

public class AmountOfTime {
  public static void main(String[] args) {
    AmountOfTime amountOfTime = new AmountOfTime();
    TreeNode root = new TreeNode(7);
    root.right = new TreeNode(1);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(3);
    amountOfTime.amountOfTime(root, 3);
  }
  static public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  private int result = Integer.MIN_VALUE;
  private int left = 0;
  private int right = 0;
  private int start;
  public int amountOfTime(TreeNode root, int start) {
    this.start = start;
    dfs(root);
    dfs1(root);
    if (result > left && result > right) {
      return result;
    }
    return Math.max(left, right);
  }
  private int dfs(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    }
    int left = dfs(treeNode.left);
    int right = dfs(treeNode.right);
    if (treeNode.val == start) {
      this.left = left;
      this.right = right;
    }
    return Math.max(left, right)+1;
  }

  private int[] dfs1(TreeNode treeNode) {
    if (treeNode == null) {
      return new int[]{0, 0};
    }
    if (treeNode.val == start) {
      return new int[]{1, 1};
    }
    int[] left = dfs1(treeNode.left);
    int[] right = dfs1(treeNode.right);
    if (left[1] == 1 || right[1] == 1) {
      int tempResult = left[0]+right[0];
      result = Math.max(result, tempResult);
      return left[1] == 1 ? new int[]{left[0]+1, 1} : new int[]{right[0]+1, 1};
    }
    return new int[]{Math.max(left[0], right[0])+1, 0};
  }
}
