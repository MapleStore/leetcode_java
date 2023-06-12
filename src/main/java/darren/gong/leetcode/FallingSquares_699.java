package darren.gong.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class FallingSquares_699 {
  private class Node {
    int max = 0;
    int flag = -1;
    Node left;
    Node right;
  }
  public static void main(String[] args) {
    FallingSquares_699 fallingSquares_699 = new FallingSquares_699();
    fallingSquares_699.fallingSquares(new int[][]{{1,2},{2,3},{6,1}});
  }
  public List<Integer> fallingSquares(int[][] positions) {
    Map<Integer, Integer> positionToIndex = new HashMap<>();
    TreeSet<Integer> treeSet = new TreeSet<>();
    for (int[] position : positions) {
      int num1 = position[0];
      int num2 = position[0]+position[1]-1;
      treeSet.add(num1);
      treeSet.add(num2);
    }
    int index = 0;
    for (int num : treeSet) {
      positionToIndex.put(num, index++);
    }

    Node root = build(0, index-1);
    List<Integer> results = new LinkedList<>();
    for (int[] position : positions) {
      int leftPos = positionToIndex.get(position[0]);
      int rightPos = positionToIndex.get(position[0]+position[1]-1);
      int height = getMax(leftPos, rightPos,0, index-1, root)+position[1];
      setVal(leftPos, rightPos, height, 0, index-1, root);
      results.add(getMax(0, index-1, 0, index-1, root));
    }
    return results;
  }

  private int getMax(int left, int right, int rangeLeft, int rangeRight, Node node) {
    if (left <= rangeLeft && right >= rangeRight) {
      return node.max;
    }
    spread(node);
    int mid = (rangeLeft+rangeRight)>>1;
    int result = Integer.MIN_VALUE;
    if (left <= mid) {
      result = Math.max(result, getMax(left, right, rangeLeft, mid, node.left));
    }
    if (right > mid) {
      result = Math.max(result, getMax(left, right, mid+1, rangeRight, node.right));
    }
    return result;
  }

  private void setVal(int left, int right, int val, int rangeLeft, int rangeRight, Node node) {
    if (left <= rangeLeft && right >= rangeRight) {
      node.max = val;
      node.flag = val;
      return;
    }
    spread(node);
    int mid = (rangeLeft+rangeRight)>>1;
    if (left <= mid) {
      setVal(left, right, val, rangeLeft, mid, node.left);
    }
    if (right > mid) {
      setVal(left, right, val, mid+1, rangeRight, node.right);
    }
    node.max = Math.max(node.left.max, node.right.max);
  }
  private void spread(Node node) {
    if (node.flag == -1) {
      return;
    }
    node.left.flag = node.flag;
    node.right.flag = node.flag;
    node.left.max = node.flag;
    node.right.max = node.flag;
    node.flag = -1;
  }
  private Node build(int leftRange, int rightRange) {
    if (leftRange == rightRange) {
      return new Node();
    }
    int mid = (leftRange+rightRange)>>1;
    Node result = new Node();
    result.left = build(leftRange, mid);
    result.right = build(mid+1, rightRange);
    return result;
  }
}
