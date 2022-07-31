package darren.gong.leetcode;

public class MaximumProduct628 {
  public int maximumProduct(int[] nums) {
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int max3 = Integer.MIN_VALUE;
    for (int num : nums) {
      if (num > max1) {
        max3 = max2;
        max2 = max1;
        max1 = num;
      } else if (num > max2) {
        max3 = max2;
        max2 = num;
      } else if (num > max3) {
        max3 = num;
      }
      if (num < 0) {
        if (num < min1) {
          min2 = min1;
          min1 = num;
        } else if (num < min2) {
          min2 = num;
        }
      }
    }
    if (min2 >= 0) {
      return max1*max2*max3;
    } else if (min1*min2 > max2*max3) {
      return min1*min2*max1;
    } else {
      return max1*max2*max3;
    }
  }
}
