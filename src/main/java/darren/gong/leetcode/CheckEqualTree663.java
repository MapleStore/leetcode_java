package darren.gong.leetcode;

public class CheckEqualTree663 {
  private int sum;
  private boolean result = false;
  public boolean checkEqualTree(TreeNode root) {
    if (root == null) {
      return false;
    }
    sum = countSum(root);
    if (sum % 2 != 0) {
      return false;
    }
    sum = sum/2;
    checkEqualTreeHelper(root);
    return result;
  }
  public int checkEqualTreeHelper(TreeNode root) {
    int leftValue = 0;
    int rightValue = 0;
    if (root.left != null) {
      leftValue = checkEqualTreeHelper(root.left);
      if (leftValue == sum) {
        result = true;
      }
    }
    if (root.right != null) {
      rightValue = checkEqualTreeHelper(root.right);
      if (rightValue == sum) {
        result = true;
      }
    }
    return root.val+leftValue+rightValue;
  }
  public int countSum(TreeNode root) {
    int value = root.val;
    value += root.left == null ? 0 : countSum(root.left);
    value += root.right == null ? 0 : countSum(root.right);
    return value;
  }
}
