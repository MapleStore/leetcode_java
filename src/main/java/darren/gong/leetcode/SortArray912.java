package darren.gong.leetcode;

import java.util.Arrays;

public class SortArray912 {
  public int[] sortArray(int[] nums) {
    mergeSort(nums, 0, nums.length-1);
    return nums;
  }

  private void quickSort(int[] nums, int start, int end) {
    if (end <= start) {
      return;
    }
    int index = partition(nums, start, end);
    quickSort(nums, start, index-1);
    quickSort(nums, index+1, end);
  }

  private int partition(int[] nums, int start, int end) {
    int bigIndex = start;
    for (int i = start; i < end; i++) {
      if (nums[i] < nums[end]) {
        int temp = nums[bigIndex];
        nums[bigIndex] = nums[i];
        nums[i] = temp;
        bigIndex++;
      }
    }
    int temp = nums[end];
    nums[end] = nums[bigIndex];
    nums[bigIndex] = temp;
    return bigIndex;
  }

  private void mergeSort(int[] nums, int start, int end) {
    if (end-start <= 1) {
      if (nums[end] < nums[start]) {
        int temp = nums[end];
        nums[end] = nums[start];
        nums[start] = temp;
      }
      return;
    }
    int mid = start+((end-start)>>>2);
    mergeSort(nums, start, mid);
    mergeSort(nums, mid+1, end);
    int[] temp = new int[end-start+1];
    int tempIndex = 0;
    int arrIndex1 = start;
    int arrIndex2 = mid+1;
    while (arrIndex1 <= mid || arrIndex2 <= end) {
      int arrValue1 = arrIndex1 <= mid ? nums[arrIndex1] : Integer.MAX_VALUE;
      int arrValue2 = arrIndex2 <= end ? nums[arrIndex2] : Integer.MAX_VALUE;
      if (arrValue1 <= arrValue2) {
        temp[tempIndex++] = arrValue1;
        arrIndex1++;
      } else {
        temp[tempIndex++] = arrValue2;
        arrIndex2++;
      }
    }
    tempIndex = 0;
    for (int i = start; i <= end; i++) {
      nums[i] = temp[tempIndex++];
    }
    return;
  }
}
