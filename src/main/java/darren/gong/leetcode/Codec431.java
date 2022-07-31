package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Codec431 {
  private static class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  };

  // Encodes an n-ary tree to a binary tree.
  public TreeNode encode(Node root) {
    if (root == null) {
      return null;
    }
    TreeNode treeNode = new TreeNode(root.val);
    treeNode.left = encodeHelper(root.children);
    return treeNode;
  }

  public TreeNode encodeHelper(List<Node> children) {
    if (children == null || children.size() == 0) {
      return null;
    }
    TreeNode treeNode = new TreeNode(-1);
    TreeNode current = treeNode;
    for (Node node : children) {
      current.right = encode(node);
      current = current.right;
    }
    return treeNode.right;
  }

  // Decodes your binary tree to an n-ary tree.
  public Node decode(TreeNode root) {
    if (root == null) {
      return null;
    }
    Node node = new Node(root.val);
    node.children = decodeHelper(root.left);
    return node;
  }

  public List<Node> decodeHelper(TreeNode treeNode) {
    List<Node> children = new ArrayList<>();
    while (treeNode != null) {
      children.add(decode(treeNode));
      treeNode = treeNode.right;
    }
    return children;
  }
}
