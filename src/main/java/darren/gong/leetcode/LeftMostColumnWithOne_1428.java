package darren.gong.leetcode;

import java.util.List;

public class LeftMostColumnWithOne_1428 {
  // 1428. 至少有一个 1 的最左端列
  interface BinaryMatrix {
    int get(int row, int col);
    List<Integer> dimensions();
  };
  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    List<Integer> size = binaryMatrix.dimensions();
    int maxX = size.get(0);
    int maxY = size.get(1);

    int result = maxY;
    for (int i = 0; i < maxX; i++) {
      int left = 0;
      int right = result-1;
      while (left <= right) {
        int mid = left+((right-left)>>>1);
        if (binaryMatrix.get(i, mid) == 0) {
          left = mid+1;
        } else {
          right = mid-1;
        }
      }
      if (left >= 0 && left < maxY) {
        result = Math.min(left, result);
      }
    }
    return result == maxY ? -1 : result;
  }
}
