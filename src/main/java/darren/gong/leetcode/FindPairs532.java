package darren.gong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindPairs532 {
  public int findPairs(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0)+1);
    }
    int result = 0;
    if (k == 0) {
      for (int key : map.keySet()) {
        if (map.get(key) >= 2) {
          result++;
        }
      }
      return result;
    } else {
      for (int key : map.keySet()) {
        if (map.containsKey(key+k)) {
          result++;
        }
        if (map.containsKey(key-k)) {
          result++;
        }
      }
    }
    return result/2;
  }
}
