package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinCameraCover_968 {
  private Map<String, Integer> remember = new HashMap<>();
  public int minCameraCover(TreeNode root) {
    return minCameraCoverHelper(root, false);
  }
  private int minCameraCoverHelper(TreeNode node, boolean fatherCamera) {
    if (node == null) {
      return 0;
    }
    Integer result = remember.get(node.toString()+fatherCamera);
    if (result != null) {
      return result;
    }
    if (fatherCamera) {
      int add = 1+minCameraCoverHelper(node.left, true)+minCameraCoverHelper(node.right, true);
      int notAdd = minCameraCoverHelper(node.left, false)+minCameraCoverHelper(node.right, false);
      remember.put(node.toString()+true, Math.min(add, notAdd));
      return Math.min(add, notAdd);
    } else {
      if (node.left == null && node.right == null) {
        return 1;
      }
      // current add
      int add = 1+minCameraCoverHelper(node.left, true)+minCameraCoverHelper(node.right, true);
      // current not add
      int leftChildAdd = Integer.MAX_VALUE>>>1;
      if (node.left != null) {
        leftChildAdd = 1+minCameraCoverHelper(node.left.left, true)+minCameraCoverHelper(node.left.right, true)+minCameraCoverHelper(node.right, false);
      }
      int rightChildAdd = Integer.MAX_VALUE>>>1;
      if (node.right != null) {
        rightChildAdd = 1+minCameraCoverHelper(node.right.left, true)+minCameraCoverHelper(node.right.right, true)+minCameraCoverHelper(node.left, false);
      }
      remember.put(node.toString()+false, Math.min(add, Math.min(leftChildAdd, rightChildAdd)));
      return Math.min(add, Math.min(leftChildAdd, rightChildAdd));
    }
  }
}
