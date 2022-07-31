package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindLeaves_366 {
  private List<List<Integer>> result = new ArrayList<>();
  public List<List<Integer>> findLeaves(TreeNode root) {
    findLeavesHelper(root);
    return result;
  }
  private int findLeavesHelper(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int leftHigh = findLeavesHelper(node.left);
    int rightHigh = findLeavesHelper(node.right);
    int currentHigh = Math.max(leftHigh, rightHigh)+1;

    if (result.size() < currentHigh) {
      result.add(currentHigh-1, new LinkedList<>());
    }
    result.get(currentHigh-1).add(node.val);

    node.left = null;
    node.right = null;
    return currentHigh;
  }
}
