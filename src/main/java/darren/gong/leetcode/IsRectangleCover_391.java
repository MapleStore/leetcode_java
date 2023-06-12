package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class IsRectangleCover_391 {
  public static void main(String[] args) {
    IsRectangleCover_391 isRectangleCover_391 = new IsRectangleCover_391();
    isRectangleCover_391.isRectangleCover(new int[][]{{1,2,4,4},{1,0,4,1},{0,2,1,3},{0,1,3,2},{3,1,4,2},{0,3,1,4},{0,0,1,1}});
  }
  private static class Node {
    int max = 0;
    int min = 0;
    int flag = 0;
    Node left;
    Node right;
  }
  public boolean isRectangleCover(int[][] rectangles) {
    int maxX = rectangles.length;
    TreeSet<Integer> treeSet = new TreeSet<>();
    int[][] lines = new int[maxX*2][];
    for (int i = 0; i < maxX; i++) {
      int[] rectangle = rectangles[i];
      lines[i*2] = new int[]{rectangle[0], rectangle[1], rectangle[3], 1};
      lines[i*2+1] = new int[]{rectangle[2], rectangle[1], rectangle[3], -1};
      treeSet.add(rectangle[1]);
      treeSet.add(rectangle[3]);
    }
    Arrays.sort(lines, (a,b)->{
      return a[0]-b[0];
    });
    int[] indexToY = new int[treeSet.size()];
    Map<Integer, Integer> yToIndex = new HashMap<>();
    int yIndex = 0;
    for (int y : treeSet) {
      indexToY[yIndex] = y;
      yToIndex.put(y, yIndex);
      yIndex++;
    }
    int maxY = treeSet.size()-1;
    Node root = buildTree(0, maxY-1);
    for (int i = 0; i < lines.length; i++) {
      int[] line = lines[i];
      add(yToIndex.get(line[1]), yToIndex.get(line[2])-1, 0, maxY-1, line[3], root);
      if (i != lines.length-1 && lines[i+1][0] != line[0]) {
        if (root.max != 1) {
          return false;
        }
        if (root.min != 1) {
          return false;
        }
      }
    }
    return true;
  }
  Node buildTree(int rangeLeft, int rangeRight) {
    if (rangeLeft == rangeRight) {
      return new Node();
    }
    Node current = new Node();
    int mid = (rangeLeft+rangeRight)>>1;
    current.left = buildTree(rangeLeft, mid);
    current.right = buildTree(mid+1, rangeRight);
    return current;
  }
  void add(int left, int right, int rangeLeft, int rangeRight, int val, Node current) {
    if (left <= rangeLeft && right >= rangeRight) {
      current.max += val;
      current.min += val;
      current.flag += val;
      return;
    }
    spread(current);
    int mid = (rangeLeft+rangeRight)>>1;
    if (left <= mid) {
      add(left, right, rangeLeft, mid, val, current.left);
    }
    if (right > mid) {
      add(left, right, mid+1, rangeRight, val, current.right);
    }
    current.max = Math.max(current.left.max, current.right.max);
    current.min = Math.min(current.left.min, current.right.min);
  }
  void spread(Node current) {
    if (current.flag != 0) {
      current.left.max += current.flag;
      current.right.max += current.flag;

      current.left.min += current.flag;
      current.right.min += current.flag;

      current.left.flag += current.flag;
      current.right.flag += current.flag;
      current.flag = 0;
    }
  }
}
