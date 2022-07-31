package darren.gong.leetcode;

import java.util.TreeMap;

public class IsPossibleDivide_1296 {
  public boolean isPossibleDivide(int[] nums, int k) {
    if (nums.length % k != 0) {
      return false;
    }
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0)+1);
    }
    while (!map.isEmpty()) {
      int min = map.firstKey();
      for (int i = min; i < min+k; i++) {
        int times = map.getOrDefault(i, 0);
        times--;
        if (times < 0) {
          return false;
        }
        if (times == 0) {
          map.remove(i);
        } else {
          map.put(i, times);
        }
      }
    }
    return true;
  }
}
