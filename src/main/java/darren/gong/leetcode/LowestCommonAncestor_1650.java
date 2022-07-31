package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LowestCommonAncestor_1650 {
  // 1650. 二叉树的最近公共祖先 III
  private static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
  };
  public Node lowestCommonAncestor(Node p, Node q) {
    Set<Node> visited = new HashSet<>();
    while (p != null || q != null) {
      if (p != null) {
        if (visited.contains(p)) {
          return p;
        } else {
          visited.add(p);
          p = p.parent;
        }
      }
      if (q != null) {
        if (visited.contains(q)) {
          return q;
        } else {
          visited.add(q);
          q = q.parent;
        }
      }
    }
    return null;
  }
}
