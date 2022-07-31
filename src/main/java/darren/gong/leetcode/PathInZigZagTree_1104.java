package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class PathInZigZagTree_1104 {
  public static void main(String[] args) {
    PathInZigZagTree_1104 pathInZigZagTree_1104 = new PathInZigZagTree_1104();
    pathInZigZagTree_1104.pathInZigZagTree(1);
  }
  // 1104. 二叉树寻路
  // 奇数层: 下标 = label-Math.pow(2, level-1)
  // 偶数层: 下标 = label-Math.pow(2, level)-1
  // 下标从0开始计算, n-1层下标 = n层下标/2
  public List<Integer> pathInZigZagTree(int label) {
    int level = 1;
    while (Math.pow(2, level)-1 < label) {
      level++;
    }
    LinkedList<Integer> result = new LinkedList<>();
    int index = level % 2 == 0 ? (2<<(level-1))-1-label : label-(2<<(level-2));
    while (level > 1) {
      result.addFirst(label);
      index = index>>>1;
      level--;
      label = level % 2 == 0 ? (2<<(level-1))-1-index : index+(2<<(level-2));
    }
    result.addFirst(1);
    return result;
  }
}
