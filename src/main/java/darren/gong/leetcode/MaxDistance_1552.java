package darren.gong.leetcode;

import java.util.Arrays;

public class MaxDistance_1552 {
  public int maxDistance(int[] position, int m) {
    Arrays.sort(position);
    int length = position.length;
    int right = position[length-1]-position[0];
    int left = 1;
    int mid = right;
    while (true) {
      if (canPut(position, mid, m)) {
        left = mid+1;
      } else {
        right = mid-1;
      }
      if (left > right) {
        break;
      }
      mid = left+((right-left)>>>1);
    }
    return left-1;
  }
  private boolean canPut(int[] position, int distance, int m) {
    int needPosition = 0;
    int positionIndex = 0;
    while (m > 0) {
      while (needPosition > position[positionIndex]) {
        positionIndex++;
        if (positionIndex >= position.length) {
          return false;
        }
      }
      m--;
      needPosition = position[positionIndex]+distance;
    }
    return true;
  }
}
