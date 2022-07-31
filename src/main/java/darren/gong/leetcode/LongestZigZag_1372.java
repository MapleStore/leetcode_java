package darren.gong.leetcode;

public class LongestZigZag_1372 {
  // 1372. 二叉树中的最长交错路径
  public static void main(String[] args) {
    LongestZigZag_1372 longestZigZag_1372 = new LongestZigZag_1372();
    longestZigZag_1372.longestZigZag(new TreeNode(1));
  }
  private int result = -1;
  public int longestZigZag(TreeNode root) {
    longestZigZag(root, true);
    longestZigZag(root, false);
    return result;
  }
  public int longestZigZag(TreeNode node, boolean isLeft) {
    if (node == null) {
      return -1;
    }
    int goLeft = longestZigZag(node.left, true);
    int goRight = longestZigZag(node.right, false);
    int fromNode = Math.max(goLeft, goRight)+1;
    result = Math.max(fromNode, result);
    if (isLeft) {
      return goRight+1;
    } else {
      return goLeft+1;
    }
  }
}
