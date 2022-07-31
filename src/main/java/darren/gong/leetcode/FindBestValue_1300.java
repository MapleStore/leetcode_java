package darren.gong.leetcode;

import java.util.Arrays;

public class FindBestValue_1300 {
  public static void main(String[] args) {
    FindBestValue_1300 findBestValue_1300 = new FindBestValue_1300();
    findBestValue_1300.findBestValue(new int[]{2,2}, 3);
  }
  public int findBestValue(int[] arr, int target) {
    if (getValue(arr, Integer.MAX_VALUE) <= target) {
      return Arrays.stream(arr).max().getAsInt();
    }

    int left = 0;
    int right = target;
    int result = -1;
    long minDistance = Long.MAX_VALUE;
    while (left < right) {
      int mid = left+((right-left)>>>1);
      long val = getValue(arr, mid);
      long distance = Math.abs(val-target);
      if (distance < minDistance) {
        minDistance = distance;
        result = mid;
      } else if (distance == minDistance && mid < result) {
        result = mid;
      }
      if (val >= target) {
        right = mid;
      } else {
        left = mid+1;
      }
    }
    return result;
  }
  private long getValue(int[] arr, int upNum) {
    long result = 0;
    for (int val : arr) {
      result += Math.min(val, upNum);
    }
    return result;
  }
}
