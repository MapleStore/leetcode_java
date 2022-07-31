package darren.gong.leetcode;

public class FindPeakGrid_1901 {
  public int[] findPeakGrid(int[][] mat) {
    int left = 0;
    int right = mat[0].length-1;
    while (left <= right) {
      int mid = left+((right-left)>>>1);
      int max = Integer.MIN_VALUE;
      int[] maxPos = new int[2];
      for (int col = mid-1; col <= mid+1; col++) {
        if (col < 0 || col >= mat[0].length) {
          continue;
        }
        for (int row = 0; row < mat.length; row++) {
          if (mat[row][col] > max) {
            max = mat[row][col];
            maxPos[0] = row;
            maxPos[1] = col;
          }
        }
      }
      if (maxPos[1] == mid) {
        return maxPos;
      } else if (maxPos[1] > mid) {
        left = mid+1;
      } else {
        right = mid-1;
      }
    }
    return new int[0];
  }
}
