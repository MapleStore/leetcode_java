package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree958 {
  public static void main(String[] args) {
    IsCompleteTree958 isCompleteTree958 = new IsCompleteTree958();

  }
  public boolean isCompleteTree(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean endFlag = false;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0){
        TreeNode current = queue.poll();
        if (current.left != null && endFlag) {
          return false;
        }
        if (current.left == null) {
          endFlag = true;
        } else {
          queue.add(current.left);
        }
        if (current.right != null && endFlag) {
          return false;
        }
        if (current.right == null) {
          endFlag = true;
        } else {
          queue.add(current.right);
        }
      }
    }
    return true;
  }
}
