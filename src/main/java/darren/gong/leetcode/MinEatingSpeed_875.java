package darren.gong.leetcode;

import java.util.Arrays;

public class MinEatingSpeed_875 {
  public static void main(String[] args) {
    MinEatingSpeed_875 minEatingSpeed_875 = new MinEatingSpeed_875();
    minEatingSpeed_875.minEatingSpeed(new int[]{3,6,7,11}, 8);
  }
  public int minEatingSpeed(int[] piles, int h) {
    int right = Arrays.stream(piles).max().getAsInt();
    int left = 1;
    while (left <= right) {
      int mid = left+((right-left)>>>1);
      if (canEat(piles, h, mid)) {
        right = mid-1;
      } else {
        left = mid+1;
      }
    }
    return right+1;
  }
  private boolean canEat(int[] piles, int h, int speed) {
    int useHour = 0;
    for (int pile : piles) {
      useHour += (pile+(speed-1))/speed;
    }
    return useHour <= h;
  }
}
