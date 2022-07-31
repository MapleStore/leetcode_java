package darren.gong.leetcode;

import java.util.Arrays;

public class RelativeSortArray1122 {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    int[] values = new int[1001];
    int arr2Length = arr2.length;
    int arr1Length = arr1.length;
    for (int i = 0; i < arr1Length; i++) {
      values[arr1[i]]++;
    }
    int[] result = new int[arr1Length];
    int index = 0;
    for (int i = 0; i < arr2Length; i++) {
      while (values[arr2[i]] > 0) {
        result[index++] = arr2[i];
        values[arr2[i]]--;
      }
    }
    for (int i = 0; i < 1001; i++) {
      while (values[i]-- > 0) {
        result[index++] = i;
      }
    }
    return result;
  }
}
