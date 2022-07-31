package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Preorder589 {
  private class Node {
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
  private List<Integer> result = new LinkedList<>();
  public List<Integer> preorder(Node root) {
    preorderHelper(root);
    return result;
  }
  public void preorderHelper(Node root) {
    if (root == null) {
      return;
    }
    result.add(root.val);
    for (Node node : root.children) {
      preorderHelper(node);
    }
  }

}
