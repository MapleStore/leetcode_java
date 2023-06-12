package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinDays_1553 {
  private Map<Integer, Integer> map = new HashMap<>();
  public int minDays(int n) {
    if (n == 1) {
      return 1;
    }
    if (n <= 3) {
      return 2;
    }
    if (map.containsKey(n)) {
      return map.get(n);
    }
    int result = +1+Math.min((n%2)+minDays(n/2), (n%3)+minDays(n/3));
    map.put(n, result);
    return result;
  }
}
