package darren.gong.leetcode;

public class InorderSuccessor510 {
  private class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
  };

  public Node inorderSuccessor(Node node) {
    if (node == null) {
      return null;
    }
    if (node.right != null) {
      node = node.right;
      while (node.left != null) {
        node = node.left;
      }
      return node;
    }
    int val = node.val;
    while (node.parent != null && node.parent.val < val) {
      node = node.parent;
    }
    return node.parent == null ? null : node.parent;
  }
}
