package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LenLongestFibSubseq873 {
  public static void main(String[] args) {
    System.out.println(Integer.MAX_VALUE);
    LenLongestFibSubseq873 lenLongestFibSubseq873 = new LenLongestFibSubseq873();
    lenLongestFibSubseq873.lenLongestFibSubseq(new int[]{7,8,17,24,41,65});
  }
  public int lenLongestFibSubseq(int[] arr) {
    int length = arr.length;
    int[] max = new int[length*length+length];
    Map<Integer, Integer> valueToIndex = new HashMap<>(length);
    for (int i = 0; i < length; i++) {
      valueToIndex.put(arr[i], i);
    }
    int result = 0;
    for (int i = 1; i < length; i++) {
      for (int j = i-1; j >= 0; j--) {
        int left = arr[i]-arr[j];
        int leftIndex = valueToIndex.getOrDefault(left, -1);
        if (leftIndex >= 0 && leftIndex < j) {
          int value = Math.max(max[leftIndex*length+j], 2)+1;
          result = Math.max(result, value);
          max[j*length+i] = value;
        }
      }
    }
    return result <= 2 ? 0 : result;
  }
}
