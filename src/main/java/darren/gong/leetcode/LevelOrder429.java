package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder429 {
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

  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> oneResult = new ArrayList<>();
      while (size-- > 0) {
        Node current = queue.poll();
        oneResult.add(current.val);
        for (Node next : current.children) {
          queue.add(next);
        }
      }
      result.add(oneResult);
    }
    return result;
  }
}
