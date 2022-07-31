package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinSetSize_1338 {
  public int minSetSize(int[] arr) {
    Map<Integer, Integer> hashCounts = new HashMap<>();
    for (int val : arr) {
      hashCounts.put(val, hashCounts.getOrDefault(val, 0)+1);
    }
    int[] counts = new int[hashCounts.size()];
    int index = 0;
    int sum = 0;
    for (int oneCount : hashCounts.values()) {
      counts[index++] = oneCount;
      sum += oneCount;
    }
    Arrays.sort(counts);
    sum /= 2;
    int result = 0;
    for (int i = counts.length-1; i >= 0; i--) {
      sum -= counts[i];
      result++;
      if (sum <= 0) {
        break;
      }
    }
    return result;
  }
}
