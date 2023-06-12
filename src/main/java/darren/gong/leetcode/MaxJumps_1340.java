package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxJumps_1340 {
  private Map<Integer, Integer> cache = new HashMap<>();
  public int maxJumps(int[] arr, int d) {
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      result = Math.max(result, maxJump(arr, d, i));
    }
    return result;
  }
  private int maxJump(int[] arr, int d, int index) {
    if (cache.containsKey(index)) {
      return cache.get(index);
    }
    int result = 1;
    for (int x = 1; x <= d; x++) {
      int nextIndex = index+x;
      if (nextIndex >= arr.length || arr[nextIndex] >= arr[index]) {
        break;
      }
      result = Math.max(result, maxJump(arr, d, nextIndex)+1);
    }
    for (int x = 1; x <= d; x++) {
      int nextIndex = index-x;
      if (nextIndex < 0 || arr[nextIndex] >= arr[index]) {
        break;
      }
      result = Math.max(result, maxJump(arr, d, nextIndex)+1);
    }
    cache.put(index, result);
    return result;
  }
}
