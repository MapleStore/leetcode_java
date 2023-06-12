package darren.gong.leetcode;

public class SecondGreaterElement_2454 {
  public static void main(String[] args) {
    SecondGreaterElement_2454 secondGreaterElement_2454 = new SecondGreaterElement_2454();
    secondGreaterElement_2454.secondGreaterElement(new int[]{2,4,0,9,6,2,4,0,9,6,2,2,4,0,9,6,2,4,0,9,6,2,4,0,9,6,2,4,0,9,6,2,4,0,9,6,2,4,0,9,6,2,4,0,9,6,2,4,0,9,6,4,0,9,6,2,4,0,9,6});
  }
  private static class Node {
    int max = -1;
    Node left;
    Node right;
  }
  int[] nums;
  public int[] secondGreaterElement(int[] nums) {
    this.nums = nums;
    int length = nums.length;
    if (length <= 1) {
      return new int[]{-1};
    }
    Node root = buildTree(0, length-1);
    int[] result = new int[length];
    for (int i = length-3; i >= 0; i--) {
      int num = nums[i];
      int oneIndex = findIndex(num, i+1, 0,length-1, root);
      if (oneIndex == -1 || oneIndex >= length-1) {
        result[i] = -1;
      } else {
        int twoIndex = findIndex(num, oneIndex+1, 0, length-1, root);
        if (twoIndex == -1) {
          result[i] = -1;
        } else {
          result[i] = nums[twoIndex];
        }
      }
    }
    result[length-1] = -1;
    result[length-2] = -1;
    return result;
  }
  private int findIndex(int val, int left, int leftRange, int rightRange, Node node) {
    if (node.max <= val) {
      return -1;
    }
    if (leftRange == rightRange) {
      return leftRange;
    }
    int mid = (leftRange+rightRange)>>1;
    if (getMax(left, mid, leftRange, mid, node.left) > val) {
      return findIndex(val, left, leftRange, mid, node.left);
    } else {
      return findIndex(val, left, mid+1, rightRange, node.right);
    }
  }
  private int getMax(int left, int right, int leftRange, int rightRange, Node node) {
    if (left <= leftRange && right >= rightRange) {
      return node.max;
    }
    int mid = (leftRange+rightRange)>>1;
    int max = 0;
    if (left <= mid) {
      max = Math.max(max, getMax(left, right, leftRange, mid, node.left));
    }
    if (right > mid) {
      max = Math.max(max, getMax(left, right, mid+1, rightRange, node.right));
    }
    return max;
  }
  private Node buildTree(int leftRange, int rightRange) {
    Node node = new Node();
    if (leftRange == rightRange) {
      node.max = nums[leftRange];
      return node;
    }
    int mid = (leftRange+rightRange)>>1;
    node.left = buildTree(leftRange, mid);
    node.right = buildTree(mid+1, rightRange);
    node.max = Math.max(node.left.max, node.right.max);
    return node;
  }
}
