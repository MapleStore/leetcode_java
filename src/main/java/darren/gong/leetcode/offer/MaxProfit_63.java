package darren.gong.leetcode.offer;

public class MaxProfit_63 {
  public int maxProfit(int[] prices) {
    int length = prices.length;
    int currentMin = Integer.MAX_VALUE;
    int result = 0;
    for (int i = 0; i < length; i++) {
      result = Math.max(prices[i]-currentMin, result);
      currentMin = Math.min(currentMin, prices[i]);
    }
    return result;
  }
}
