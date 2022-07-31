package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class PancakeSort969 {
  public List<Integer> pancakeSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return new LinkedList<>();
    }
    int alreadySortIndex = arr.length;
    List<Integer> result = new LinkedList<>();
    while (alreadySortIndex > 1) {
      int bigIndex = alreadySortIndex-1;
      int big = arr[alreadySortIndex-1];
      for (int i = alreadySortIndex-1; i >= 0; i--) {
        if (arr[i] > big) {
          big = arr[i];
          bigIndex = i;
        }
      }
      if (bigIndex == alreadySortIndex-1) {
        alreadySortIndex--;
        continue;
      }
      result.add(bigIndex+1);
      result.add(alreadySortIndex);

      reverse(arr, 0, bigIndex);
      reverse(arr, 0, alreadySortIndex-1);
      alreadySortIndex--;
    }
    return result;
  }

  private void reverse(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
    return;
  }
}
