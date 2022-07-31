package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter_919 {
  // 919. 完全二叉树插入器
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    CBTInserter_919 cbtInserter_919 = new CBTInserter_919(root);
    cbtInserter_919.insert(2);
    cbtInserter_919.insert(3);
    cbtInserter_919.insert(4);
  }
  private Queue<TreeNode> queue = new LinkedList<>();
  private TreeNode root;
  public CBTInserter_919(TreeNode root) {
    this.root = root;
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode current = queue.peek();
      if (current.left != null) {
        queue.add(current.left);
      } else {
        break;
      }
      if (current.right != null) {
        queue.add(current.right);
      } else {
        break;
      }
      queue.poll();
    }
  }

  public int insert(int v) {
    TreeNode current = queue.peek();
    if (current.left == null) {
      current.left = new TreeNode(v);
      queue.add(current.left);
    } else if (current.right == null) {
      current.right = new TreeNode(v);
      queue.add(current.right);
    }
    if (current.left != null && current.right != null) {
      queue.poll();
    }
    return current.val;
  }

  public TreeNode get_root() {
    return root;
  }
}
