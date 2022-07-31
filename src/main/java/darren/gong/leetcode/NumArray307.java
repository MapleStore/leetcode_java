package darren.gong.leetcode;

public class NumArray307 {
  public static void main(String[] args) {
    NumArray307 numArray307 = new NumArray307(new int[]{1,3,5});
    numArray307.sumRange(0,2);
    numArray307.update(1,2);
    numArray307.sumRange(0,1);
  }
  private Node root;
  private static class Node {
    private int left;
    private int right;
    private int value;
    private Node leftNode;
    private Node rightNode;
    public Node(int left, int right, int value) {
      this.left = left;
      this.right = right;
      this.value = value;
    }
  }
  public NumArray307(int[] nums) {
    root = makeTree(nums, 0, nums.length-1);
  }
  private Node makeTree(int[] nums, int left, int right) {
    if (left == right) {
      return new Node(left, right, nums[left]);
    }
    int mid = left+((right-left)>>>1);
    Node node = new Node(left, right, 0);
    node.leftNode = makeTree(nums, left, mid);
    node.rightNode = makeTree(nums, mid+1, right);
    node.value = node.leftNode.value+node.rightNode.value;
    return node;
  }

  public void update(int index, int val) {
    update(root, index, val);
  }

  private void update(Node node, int index, int val) {
    if (index > node.right && index < node.left) {
      return;
    }
    if (index == node.left && index == node.right) {
      node.value = val;
      return;
    }
    if (index <= node.leftNode.right) {
      update(node.leftNode, index, val);
    }
    if (index >= node.rightNode.left) {
      update(node.rightNode, index, val);
    }
    node.value = node.leftNode.value+node.rightNode.value;
  }

  public int sumRange(int left, int right) {
    return sumRange(root, left, right);
  }

  private int sumRange(Node node, int left, int right) {
    if (left <= node.left && right >= node.right) {
      return node.value;
    }
    int result = 0;
    if (left <= node.leftNode.right) {
      result += sumRange(node.leftNode, left, right);
    }
    if (right >= node.rightNode.left) {
      result += sumRange(node.rightNode, left, right);
    }
    return result;
  }
}
