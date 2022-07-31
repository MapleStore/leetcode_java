package darren.gong.leetcode.interview;

import java.util.Arrays;

public class SmallestK_1714 {
  // 面试题 17.14. 最小K个数
  public static void main(String[] args) {
    SmallestK_1714 smallestK_1714 = new SmallestK_1714();
    smallestK_1714.smallestK(new int[]{1,3,5,7,2,4,6,8}, 4);
  }
  public int[] smallestK(int[] arr, int k) {
    if (k == 0) {
      return new int[0];
    }
    int left = 0;
    int right = arr.length-1;
    while (left < right) {
      int index = partition(arr, left, right);
      if (index == k || index == k-1) {
        break;
      }
      if (index < k-1) {
        left = index+1;
      } else {
        right = index-1;
      }
    }
    return Arrays.copyOf(arr, k);
  }
  private int partition(int[] arr, int left, int right) {
    int current = arr[left];
    swap(arr, left, right);
    int minIndex = left;
    for (int i = left; i <= right; i++) {
      if (arr[i] < current) {
        swap(arr, minIndex++, i);
      }
    }
    swap(arr, minIndex, right);
    return minIndex;
  }
  private void swap(int[] arr, int oneIndex, int twoIndex) {
    int temp = arr[oneIndex];
    arr[oneIndex] = arr[twoIndex];
    arr[twoIndex] = temp;
  }
}
