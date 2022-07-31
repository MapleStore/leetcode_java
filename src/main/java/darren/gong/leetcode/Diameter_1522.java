package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Diameter_1522 {
  // 1522. N 叉树的直径
  class Node {
    public int val;
    public List<Node> children;


    public Node() {
      children = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
      val = _val;
      children = _children;
    }
  };
  private int result = 0;
  public int diameter(Node root) {
    biggestDepth(root);
    return result;
  }
  private int biggestDepth(Node node) {
    if (node.children.isEmpty()) {
      return 0;
    }
    int big1 = -100000;
    int big2 = -100000;
    for (Node child : node.children) {
      int childDepth = biggestDepth(child);
      if (childDepth >= big1) {
        big2 = big1;
        big1 = childDepth;
      } else if (childDepth > big2) {
        big2 = childDepth;
      }
    }
    result = Math.max(result, big1+1);
    result = Math.max(result, big1+big2+2);
    return Math.max(big1, big2)+1;
  }
}
