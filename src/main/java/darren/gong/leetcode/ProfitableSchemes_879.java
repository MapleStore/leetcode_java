package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ProfitableSchemes_879 {
  public static void main(String[] args) {
    ProfitableSchemes_879 profitableSchemes_879 = new ProfitableSchemes_879();
    profitableSchemes_879.profitableSchemes(5, 3, new int[]{2,2}, new int[]{2,3});
  }
  private int[] group;
  private int[] profit;
  private final int MOD = 1000000007;
  private Map<Long, Long> cache = new HashMap<>();
  public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
    this.group = group;
    this.profit = profit;
    return (int)profitableSchemes(n, minProfit, group.length-1);
  }
  private long profitableSchemes(int n, int minProfit, int index) {
    if (index < 0) {
      return n >= 0 && minProfit == 0 ? 1 : 0;
    }
    if (n < 0) {
      return 0;
    }
    long key = (long)n*107*107+(long)minProfit*107+index;
    if (cache.containsKey(key)) {
      return cache.get(key);
    }
    long result = (profitableSchemes(n-group[index], Math.max(0, minProfit-profit[index]), index-1)+profitableSchemes(n, minProfit, index-1))%MOD;
    cache.put(key, result);
    return result;
  }
}
