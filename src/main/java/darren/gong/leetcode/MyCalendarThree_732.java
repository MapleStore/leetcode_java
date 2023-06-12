package darren.gong.leetcode;

public class MyCalendarThree_732 {
  public MyCalendarThree_732() {

  }
  private static class Node {
    int flag = 0;
    int max = 0;
    Node left;
    Node right;
  }
  private Node root = new Node();
  public int book(int startTime, int endTime) {
    add(startTime, endTime-1, 0, 1000000000, 1, root);
    return root.max;
  }

  private void add(long left, long right, long nodeMin, long nodeMax, int val, Node current) {
    if (left <= nodeMin && right >= nodeMax) {
      current.max += val;
      current.flag += val;
      return;
    }
    long mid = (nodeMin+nodeMax)>>1;
    if (current.left == null) {
      current.left = new Node();
    }
    if (current.right == null) {
      current.right = new Node();
    }
    spread(current);
    if (left <= mid) {
      add(left, right, nodeMin, mid, val, current.left);
    }
    if (right > mid) {
      add(left, right, mid+1, nodeMax, val, current.right);
    }
    current.max = Math.max(current.left.max, current.right.max);
  }

  private void spread(Node node) {
    if (node.flag != 0) {
      node.left.max += node.flag;
      node.right.max += node.flag;
      node.left.flag += node.flag;
      node.right.flag += node.flag;
      node.flag = 0;
    }
  }
}
