package darren.gong.leetcode.offer;

public class BuildTree07 {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTreeHelper(preorder, 0, preorder.length-1, inorder, 0,  inorder.length-1);
  }
  public TreeNode buildTreeHelper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
    if (preLeft > preRight) {
      return null;
    }
    TreeNode node = new TreeNode(preorder[preLeft]);
    if (preLeft == preRight) {
      return node;
    }
    int nodeInIndex = inLeft;
    for (; nodeInIndex <= inRight; nodeInIndex++) {
      if (inorder[nodeInIndex] == preorder[preLeft]) {
        break;
      }
    }
    int leftNum = nodeInIndex-inLeft;
    node.left = buildTreeHelper(preorder, preLeft+1, preLeft+leftNum, inorder, inLeft, nodeInIndex-1);
    node.right = buildTreeHelper(preorder, preLeft+leftNum+1, preRight, inorder, nodeInIndex+1, inRight);
    return node;
  }
}
