package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LargestNumber_1449 {
  private Map<Integer, String> cache = new HashMap<>();
  public String largestNumber(int[] cost, int target) {
    Map<Integer, Integer> costs = new HashMap<>();
    for (int i = 0; i < cost.length; i++) {
      costs.put(cost[i], i+1);
    }
    return largestNumber(costs, target);
  }
  public String largestNumber(Map<Integer, Integer> costs, int target) {
    if (target < 0) {
      return "0";
    }
    if (target == 0) {
      return null;
    }
    if (cache.containsKey(target)) {
      return cache.get(target);
    }
    String result = "0";
    for (Map.Entry<Integer, Integer> oneCost : costs.entrySet()) {
      String next = largestNumber(costs, target-oneCost.getKey());
      if ("0".equals(next)) {
        continue;
      }
      String tempResult = next == null ? ""+oneCost.getValue() : oneCost.getValue()+next;
      if (tempResult.length() > result.length() || (tempResult.length() == result.length() && tempResult.compareTo(result) > 0)) {
        result = tempResult;
      }
    }
    cache.put(target, result);
    return result;
  }
}
