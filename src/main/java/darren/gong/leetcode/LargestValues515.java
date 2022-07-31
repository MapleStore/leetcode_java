package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues515 {
  public List<Integer> largestValues(TreeNode root) {
    if (root == null) {
      return new LinkedList<>();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    List<Integer> result = new LinkedList<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      int oneResult = Integer.MIN_VALUE;
      while (size-- > 0) {
        TreeNode current = queue.poll();
        oneResult = Math.max(oneResult, current.val);
        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }
      result.add(oneResult);
    }
    return result;
  }
}
