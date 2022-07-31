package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingOffers638 {
  public static void main(String[] args) {
    ShoppingOffers638 shoppingOffers638 = new ShoppingOffers638();
    List<Integer> price = new ArrayList<>(Arrays.asList(new Integer[]{4,3,2,9,8,8}));
    List<List<Integer>> special = new ArrayList<>();
    special.add(new ArrayList<>(Arrays.asList(new Integer[]{1,5,5,1,4,0,18})));
    special.add(new ArrayList<>(Arrays.asList(new Integer[]{3,3,6,6,4,2,32})));
    List<Integer> needs = new ArrayList<>(Arrays.asList(new Integer[]{6,5,5,6,4,1}));
    shoppingOffers638.shoppingOffers(price, special, needs);
  }
  private int result = Integer.MAX_VALUE;
  private int goodNum;
  public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    if (price == null || price.size() == 0) {
      return 0;
    }
    goodNum = price.size();
    dfs(special, needs, 0, price);
    return result;
  }
  private void dfs(List<List<Integer>> special, List<Integer> needs, int currentPrice, List<Integer> price) {
    result = Math.min(result, currentPrice+countMoney(price, needs));
    for (List<Integer> oneSpecial : special) {
      List<Integer> next = nextNeeds(needs, oneSpecial);
      if (next == null) {
        continue;
      }
      int nextPrice = currentPrice+oneSpecial.get(goodNum);
      dfs(special, next, nextPrice, price);
    }
  }
  private boolean finish(List<Integer> needs) {
    for (int value : needs) {
      if (value > 0) {
        return false;
      }
    }
    return true;
  }
  private int countMoney(List<Integer> price, List<Integer> needs) {
    int result = 0;
    for (int i = 0; i < goodNum; i++) {
      result += price.get(i)*needs.get(i);
    }
    return result;
  }
  private List<Integer> nextNeeds(List<Integer> needs, List<Integer> oneSpecial) {
    List<Integer> next = new ArrayList<>();
    for (int i = 0; i < goodNum; i++) {
      int nextNeed = needs.get(i)-oneSpecial.get(i);
      if (nextNeed < 0) {
        return null;
      }
      next.add(nextNeed);
    }
    return next;
  }
}
