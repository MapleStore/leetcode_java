package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class KidsWithCandies1431 {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> result = new LinkedList<>();
    int max = Integer.MIN_VALUE;
    int length = candies.length;
    for (int i = 0; i < length; i++) {
      max = Math.max(max, candies[i]);
    }
    for (int i = 0; i < length; i++) {
      result.add(candies[i]+extraCandies >= max);
    }
    return result;
  }
}
