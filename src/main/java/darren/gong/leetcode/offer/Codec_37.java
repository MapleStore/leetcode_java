package darren.gong.leetcode.offer;

import java.util.LinkedList;
import java.util.Queue;

public class Codec_37 {
  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        TreeNode node = queue.poll();
        sb.append(node == null ? null : node.val);
        sb.append(',');
        if (node != null) {
          queue.add(node.left);
          queue.add(node.right);
        }
      }
    }
    return sb.deleteCharAt(sb.length()-1).toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.equals("null")) {
      return null;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    String[] vals = data.split(",");
    int index = 1;
    TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (!vals[index].equals("null")) {
        node.left = new TreeNode(Integer.parseInt(vals[index]));
        queue.add(node.left);
      }
      index++;
      if (!vals[index].equals("null")) {
        node.right = new TreeNode(Integer.parseInt(vals[index]));
        queue.add(node.right);
      }
      index++;
    }
    return root;
  }
}
