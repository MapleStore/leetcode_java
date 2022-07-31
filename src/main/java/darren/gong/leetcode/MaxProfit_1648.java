package darren.gong.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class MaxProfit_1648 {
  // 1648. 销售价值减少的颜色球
  public static void main(String[] args) {
    MaxProfit_1648 maxProfit_1648 = new MaxProfit_1648();
    maxProfit_1648.maxProfit(new int[]{1000000000,999999999}, 1000000000);
  }
  private long result = 0;
  private final long MOD = (long)Math.pow(10, 9)+7;
  private TreeMap<Long, Long> treeMap = new TreeMap<>();
  private int orders;
  public int maxProfit(int[] inventory, int orders) {
    this.orders = orders;
    for (int num : inventory) {
      treeMap.put((long)num, treeMap.getOrDefault((long)num, 0L)+1);
    }
    while (this.orders > 0) {
      addValue();
    }
    return (int)result;
  }
  private void addValue() {
    Map.Entry<Long, Long> max = treeMap.lastEntry();
    Long secMax = treeMap.lowerKey(max.getKey());
    if (secMax == null) {
      secMax = 0L;
    }
    if (orders <= max.getValue()) {
      result += orders*max.getKey();
      result = result%MOD;
      orders = 0;
    }

    // 最大的球 每种球取多少个
    long times = orders/max.getValue();
    times = Math.min(max.getKey()-secMax, times);
    result += (max.getValue()*(max.getKey()-times+1+max.getKey()))*times/2;
    result = result%MOD;
    orders -= max.getValue()*times;
    treeMap.remove(max.getKey());
    treeMap.put(max.getKey()-times, treeMap.getOrDefault(max.getKey()-times, 0L)+max.getValue());
  }
}
