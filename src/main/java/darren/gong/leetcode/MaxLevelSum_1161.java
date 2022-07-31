package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum_1161 {
  public int maxLevelSum(TreeNode root) {
    int maxCount = Integer.MIN_VALUE;
    int result = 1;
    int level = 1;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      int count = 0;
      while (size-- > 0) {
        TreeNode current = queue.poll();
        count += current.val;
        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }
      if (count > maxCount) {
        maxCount = count;
        result = level;
      }
      level++;
    }
    return result;
  }
}
