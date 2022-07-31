package darren.gong.leetcode;

import java.util.TreeSet;

public class MaxSumSubmatrix_363 {
  public int maxSumSubmatrix(int[][] matrix, int k) {
    int maxX = matrix.length;
    int maxY = matrix[0].length;
    int result = Integer.MIN_VALUE;
    for (int line1 = 0; line1 < maxX; line1++) {
      int[] sum = new int[maxY];
      for (int line2 = line1; line2 < maxX; line2++) {
        for (int col = 0; col < maxY; col++) {
          sum[col] += matrix[line2][col];
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(0);
        int prefixSum = 0;
        for (int val : sum) {
          prefixSum += val;
          Integer nearest = treeSet.ceiling(prefixSum-k);
          if (nearest != null) {
            result = Math.max(result, prefixSum-nearest);
          }
          treeSet.add(prefixSum);
        }
      }
    }
    return result;
  }
}
