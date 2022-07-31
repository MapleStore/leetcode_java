package darren.gong.leetcode;

public class NumMatrix308 {
  public static void main(String[] args) {
    NumMatrix308 numMatrix308 = new NumMatrix308(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
    numMatrix308.update(3,2,2);
  }
  private static class TreeNode {
    int leftIndex;
    int rightIndex;
    int sum;
    TreeNode left;
    TreeNode right;
    TreeNode(int leftIndex, int rightIndex, int sum) {
      this.leftIndex = leftIndex;
      this.rightIndex = rightIndex;
      this.sum = sum;
    }
  }
  private TreeNode[] root;
  private int maxX;
  private int maxY;
  public NumMatrix308(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return;
    }
    this.maxX = matrix.length;
    this.maxY = matrix[0].length;
    root = new TreeNode[maxX];
    for (int i = 0; i < maxX; i++) {
      root[i] = buildTree(matrix[i], 0, maxY-1);
    }
    return;
  }

  private TreeNode buildTree(int[] arr, int left, int right) {
    if (left == right) {
      return new TreeNode(left, right, arr[left]);
    }
    TreeNode result = new TreeNode(left, right, 0);
    int mid = left+((right-left)>>>1);
    result.left = buildTree(arr, left, mid);
    result.right = buildTree(arr, mid+1, right);
    result.sum = result.left.sum+result.right.sum;
    return result;
  }

  public void update(int row, int col, int val) {
    if (root == null) {
      return;
    }
    update(root[row], col, val);
  }
  private void update(TreeNode node, int index, int val) {
    if (node.leftIndex == index && node.rightIndex == index) {
      node.sum = val;
      return;
    }
    if (index >= node.left.leftIndex && index <= node.left.rightIndex) {
      update(node.left, index, val);
    } else {
      update(node.right, index, val);
    }
    node.sum = node.left.sum+node.right.sum;
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if (root == null) {
      return 0;
    }
    int result = 0;
    for (int i = row1; i <= row2; i++) {
      result += sumRegion(root[i], col1, col2);
    }
    return result;
  }
  private int sumRegion(TreeNode node, int leftIndex, int rightIndex) {
    if (node.leftIndex >= leftIndex && node.rightIndex <= rightIndex) {
      return node.sum;
    }
    int result = 0;
    if (leftIndex <= node.left.rightIndex) {
      result += sumRegion(node.left, leftIndex, rightIndex);
    }
    if (rightIndex >= node.right.leftIndex) {
      result += sumRegion(node.right, leftIndex, rightIndex);
    }
    return result;
  }
}
