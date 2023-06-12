package darren.gong.leetcode;

public class MinInteger_1505 {
  public static void main(String[] args) {
    MinInteger_1505 minInteger_1505 = new MinInteger_1505();
    minInteger_1505.minInteger("9000900", 3);
  }
  private static class Node {
    int count;
    int minIndex;
    Node left;
    Node right;
  }
  private Node root;
  private String num;
  public String minInteger(String num, int k) {
    this.num = num;
    this.root = build(0, num.length()-1);
    StringBuilder sb = new StringBuilder();
    while (k >= 0) {
      if (sb.length() == num.length()) {
        break;
      }
      int index = getMin(k+1, root);
      k -= getCountByIndex(index, root, 0, num.length()-1)-1;
      remove(index, root, 0, num.length()-1);
      sb.append(num.charAt(index));
    }
    return sb.toString();
  }
  private int getMin(int size, Node node) {
    if (size >= node.count) {
      return node.minIndex;
    }
    if (size <= node.left.count) {
      return getMin(size, node.left);
    }
    int leftIndex = node.left.minIndex;
    int rightIndex = getMin(size-node.left.count, node.right);
    if (leftIndex == Integer.MAX_VALUE) {
      return rightIndex;
    }
    if (rightIndex == Integer.MAX_VALUE) {
      return leftIndex;
    }
    return num.charAt(leftIndex) <= num.charAt(rightIndex) ? leftIndex : rightIndex;
  }
  private int getCountByIndex(int index, Node node, int left, int right) {
    if (index >= right) {
      return node.count;
    }
    int mid = (left+right)>>1;
    if (index <= mid) {
      return getCountByIndex(index, node.left, left, mid);
    }
    return node.left.count+getCountByIndex(index, node.right, mid+1, right);
  }
  private void remove(int index, Node node, int left, int right) {
    if (left == right) {
      node.count = 0;
      node.minIndex = Integer.MAX_VALUE;
      return;
    }
    int mid = (left+right)>>1;
    if (index <= mid) {
      remove(index, node.left, left, mid);
      node.count = node.left.count+node.right.count;
      updateMinIndex(node);
      return;
    }
    remove(index, node.right, mid+1, right);
    node.count = node.left.count+node.right.count;
    updateMinIndex(node);
  }
  private Node build(int left, int right) {
    if (left == right) {
      Node node = new Node();
      node.count = 1;
      node.minIndex = left;
      return node;
    }
    int mid = (left+right)>>1;
    Node node = new Node();
    node.left = build(left, mid);
    node.right = build(mid+1, right);
    node.count = node.left.count+node.right.count;
    updateMinIndex(node);
    return node;
  }
  private void updateMinIndex(Node node) {
    int leftIndex = node.left.minIndex;
    int rightIndex = node.right.minIndex;
    if (leftIndex == Integer.MAX_VALUE) {
      node.minIndex = rightIndex;
    } else if (rightIndex == Integer.MAX_VALUE) {
      node.minIndex = leftIndex;
    } else node.minIndex = num.charAt(leftIndex) <= num.charAt(rightIndex) ? leftIndex : rightIndex;
  }
}
