package darren.gong.leetcode;

import java.util.Arrays;

public class ReversePairs_Offer51 {
  public static void main(String[] args) {
    ReversePairs_Offer51 reversePairs_offer51 = new ReversePairs_Offer51();
    reversePairs_offer51.reversePairs(new int[]{1,3,2,3,1});
  }
  int result = 0;
  public int reversePairs(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    sort(0, nums.length-1, nums, new int[nums.length]);
    return result;
  }
  private void sort(int start, int end, int[] nums, int[] tempArr) {
    if (start >= end) {
      return;
    }
    if (start == end-1) {
      if (nums[start] > nums[end]) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        result++;
      }
      return;
    }
    int mid = start+((end-start)>>>1);
    sort(start, mid, nums, tempArr);
    sort(mid+1, end, nums, tempArr);
    if (nums[mid] <= nums[mid+1]) {
      return;
    }
    int left = start;
    int right = mid+1;

    for (int i = start; i <= end; i++) {
      tempArr[i] = nums[i];
    }

    int index = start;
    while (index <= end) {
      if (left > mid) {
        nums[index++] = tempArr[right];
        right++;
      } else if (right > end) {
        nums[index++] = tempArr[left];
        left++;
      } else if (tempArr[left] <= tempArr[right]) {
        nums[index++] = tempArr[left];
        left++;
      } else {
        nums[index++] = tempArr[right];
        result += mid-left+1;
        right++;
      }
    }
    return;
  }
}
