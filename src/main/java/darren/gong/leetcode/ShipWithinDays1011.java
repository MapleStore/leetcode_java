package darren.gong.leetcode;

public class ShipWithinDays1011 {
  public int shipWithinDays(int[] weights, int D) {
    int right = 0;
    int left = Integer.MIN_VALUE;
    int length = weights.length;
    for (int i = 0; i < length; i++) {
      right += weights[i];
      left = Math.max(left, weights[i]);
    }
    while (left < right) {
      int mid = left+((right-left)>>>1);

      int day = 1;
      int canUse = mid;
      for (int i = 0; i < length && day <= D;) {
        if (canUse >= weights[i]) {
          canUse -= weights[i];
          i++;
        } else {
          day++;
          canUse = mid;
        }
      }

      if (day <= D) {
        right = mid;
      } else {
        left = mid+1;
      }
    }
    return right;
  }
}
