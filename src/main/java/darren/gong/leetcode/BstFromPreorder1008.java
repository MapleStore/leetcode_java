package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class BstFromPreorder1008 {
  public TreeNode bstFromPreorder(int[] preorder) {
    if (preorder == null || preorder.length == 0) {
      return null;
    }
    return bstFromPreorderHelper(preorder, 0, preorder.length-1);
  }
  public TreeNode bstFromPreorderHelper(int[] preorder, int startIndex, int endIndex) {
    if (startIndex > endIndex) {
      return null;
    }
    if (startIndex == endIndex) {
      return new TreeNode(preorder[startIndex]);
    }
    int root = preorder[startIndex];
    TreeNode rootNode = new TreeNode(root);
    int i = startIndex+1;
    for (; i <= endIndex; i++) {
      if (preorder[i] > root) {
        break;
      }
    }
    rootNode.left = bstFromPreorderHelper(preorder, startIndex+1, i-1);
    rootNode.right = bstFromPreorderHelper(preorder, i, endIndex);
    return rootNode;
  }
}
