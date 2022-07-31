package darren.gong.leetcode;

public class ReversePairs493 {
  public static void main(String[] args) {
    ReversePairs493 reversePairs493 = new ReversePairs493();
    reversePairs493.reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647});
  }
  private int result = 0;
  public int reversePairs(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    mergeSort(nums, new int[nums.length], 0, nums.length-1);
    return result;
  }

  private void mergeSort(int[] nums, int[] temp, int start, int end) {
    if (start >= end) {
      return;
    }
    if (end == start+1) {
      if ((long)nums[start] > 2*(long)nums[end]) {
        result += 1;
      }
      if (nums[start] > nums[end]) {
        int tempNum = nums[start];
        nums[start] = nums[end];
        nums[end] = tempNum;
      }
      return;
    }

    int mid = start+((end-start)>>>1);
    mergeSort(nums, temp, start, mid);
    mergeSort(nums, temp, mid+1, end);

    for (int i = start; i <= end; i++) {
      temp[i] = nums[i];
    }

    int left = start;
    int right = mid+1;
    while (left <= mid || right <= end) {
      if (left > mid) {
        break;
      } else if (right > end) {
        left++;
        result += end-mid;
      } else {
        if ((long)nums[left] > 2*(long)nums[right]) {
          right++;
        } else {
          result += right-mid-1;
          left++;
        }
      }
    }

    left = start;
    right = mid+1;
    int index = start;
    while (index <= end) {
      if (left > mid) {
        nums[index++] = temp[right++];
      } else if (right > end) {
        nums[index++] = temp[left++];
      } else {
        if (temp[left] > temp[right]) {
          nums[index++] = temp[right++];
        } else {
          nums[index++] = temp[left++];
        }
      }
    }
    return;
  }
}
