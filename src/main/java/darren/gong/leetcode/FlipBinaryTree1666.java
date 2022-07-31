package darren.gong.leetcode;

public class FlipBinaryTree1666 {
  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
  };
  private Node root;
  public Node flipBinaryTree(Node root, Node leaf) {
    this.root = root;
    flipBinaryTreeHelper(leaf);
    leaf.parent = null;
    return leaf;
  }
  private void flipBinaryTreeHelper(Node cur) {
    if (cur == root) return;
    Node left = cur.left;
    Node parent = cur.parent;
    if (cur.left != null) {
      cur.right = left;
    }
    cur.left = parent;
    if (parent.left == cur) parent.left = null;
    if (parent.right == cur) parent.right = null;
    flipBinaryTreeHelper(parent);
    parent.parent = cur;
  }
}
