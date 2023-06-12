package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs_70 {
  private Map<Integer, Integer> cache = new HashMap<>();
  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    if (cache.containsKey(n)) {
      return cache.get(n);
    }
    int result = climbStairs(n-1)+climbStairs(n-2);
    cache.put(n, result);
    return result;
  }
}
