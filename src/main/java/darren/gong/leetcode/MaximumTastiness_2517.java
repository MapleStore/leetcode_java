package darren.gong.leetcode;

import java.util.Arrays;

public class MaximumTastiness_2517 {
  public int maximumTastiness(int[] price, int k) {
    Arrays.sort(price);
    int left = 0;
    int right = 1000000000;
    while (left < right) {
      int mid = (left+right+1)>>1;
      if (valid(price, k, mid)) {
        left = mid;
      } else {
        right = mid-1;
      }
    }
    return left;
  }
  private boolean valid(int[] price, int k, int distance) {
    long preVal = -1000000000;
    for (int i = 0; i < price.length; i++) {
      if (price[i]-preVal >= distance) {
        preVal = price[i];
        k--;
        if (k <= 0) {
          return true;
        }
      }
    }
    return false;
  }
}
