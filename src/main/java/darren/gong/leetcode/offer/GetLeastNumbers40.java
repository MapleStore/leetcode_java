package darren.gong.leetcode.offer;

import java.util.PriorityQueue;

public class GetLeastNumbers40 {
  public int[] getLeastNumbers(int[] arr, int k) {
    int length = arr.length;
    int[] appear = new int[length+1];
    for (int value : arr) {
      appear[value]++;
    }
    int[] result = new int[k];
    int index = 0;
    for (int i = 0; i <= length && k > 0; i++) {
      while (appear[i] != 0 && k > 0) {
        result[index++] = i;
        appear[i]--;
        k--;
      }
    }
    return result;
  }
}
