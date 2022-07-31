package darren.gong.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FlipMatchVoyage_971 {
  private List<Integer> result = new LinkedList<>();
  public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
    if (flipMatchVoyageHelper(root, voyage, 0, voyage.length-1)) {
      return result;
    }
    return Collections.singletonList(-1);
  }
  private boolean flipMatchVoyageHelper(TreeNode root, int[] voyage, int left, int right) {
    if (root == null || left > right) {
      if (root == null && left > right) {
        return true;
      }
      return false;
    }
    if (root.val != voyage[left]) {
      return false;
    }
    if (root.left == null) {
      return flipMatchVoyageHelper(root.right, voyage, left+1, right);
    }
    if (root.right == null) {
      return flipMatchVoyageHelper(root.left, voyage, left+1, right);
    }
    if (root.left.val == voyage[left+1]) {
      int index = left+2;
      while (index <= right && voyage[index] != root.right.val) {
        index++;
      }
      return flipMatchVoyageHelper(root.left, voyage, left+1, index-1) && flipMatchVoyageHelper(root.right, voyage, index, right);
    }
    if (root.right.val == voyage[left+1]) {
      result.add(root.val);
      int index = left+2;
      while (index <= right && voyage[index] != root.left.val) {
        index++;
      }
      return flipMatchVoyageHelper(root.right, voyage, left+1, index-1) && flipMatchVoyageHelper(root.left, voyage, index, right);
    }
    return false;
  }
}
